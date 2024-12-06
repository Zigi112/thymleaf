package com.example.Controllers;

import java.util.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Model.Contact;
import com.example.Model.Event;
import com.example.Model.Personne;
import com.example.repositry.EventRepository;
import com.example.repositry.UserRepository;
import com.example.repositry.contactRepository;

import org.springframework.ui.Model;

@Controller
public class AuthController {
		
	@Autowired
	    private UserRepository userRepository;
	@Autowired
    private contactRepository contactRepository;
	@Autowired
	private EventRepository eventRepository ;

	@GetMapping("/home")
    public String showLoginPage() {
        return "index" ; 
    }
	@GetMapping("/about")
    public String showAboutPage() {
        return "about" ; 
    }
	@GetMapping("/event")
    public String showEventPage() {
        return "event" ; 
    }
	@GetMapping("/contact")
    public String showContactPage() {
        return "contact" ; 
    }
	
    @PostMapping("/loginn")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Personne user = userRepository.findByEmail(email);
        if (user != null && BCrypt.checkpw(password, user.getMotPasse())) {
            model.addAttribute("message", "Bienvenue, " + email + " !");
            //index without auth
            return "indexw"; 
        }
        model.addAttribute("error", "Identifiants invalides !");
        return "index"; 
    }
    
    @PostMapping("/signup")
    public String processSignup(@RequestParam String email ,@RequestParam String password,@RequestParam String name, Model model) {
    	System.out.println("Données de l'inscription : " + email + " " + password + " " + name);
    	String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Personne user = new Personne(name, email,hashedPassword);
        
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Cet email est déjà utilisé !");
            return "signup";
        }
        try {
            userRepository.save(user);
            model.addAttribute("success", "Inscription réussie !");
            return "login"; // Rediriger vers la page de connexion
        } catch (Exception e) {
            model.addAttribute("error", "Une erreur est survenue lors de l'enregistrement de l'utilisateur : " + e.getMessage());
            return "signup";
        }
    }
    @PostMapping("/contacter")
    public String processContacter(@RequestParam String email ,@RequestParam String telephone,@RequestParam String nom,@RequestParam String prenom,@RequestParam String message, Model model) {
    	System.out.println("!!!");
    	Contact contact = new Contact(nom,prenom,email,telephone,message) ;
        contactRepository.save(contact) ;
        model.addAttribute("success", " réussie !!!!!");
		return "index"; // Rediriger vers la page de connexion
        
        }
    @PostMapping("/createvent")
    public String processEvent(@RequestParam String eventname ,@RequestParam String eventdate,@RequestParam String eventtime,@RequestParam int participantsnbr , Model model) {
    	System.out.println("west event");
    	String eventdat = ""+eventdate;
    	String eventime=""+eventtime;
    	Event event = new Event(eventname,eventdat,eventime,participantsnbr) ;
    	eventRepository.save(event) ;
        model.addAttribute("success", " réussie !!!!!");
        return "index"; // Rediriger vers la page de connexion
        
        }
    }

