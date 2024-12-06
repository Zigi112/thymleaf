
// HANDLING NAVBAR SHADOW WHEN SCROLLING
const navbar = document.querySelector("nav");
window.addEventListener("scroll", () =>{
    const scrollY = window.scrollY;
    console.log("ScrollY: ", scrollY)
    if(scrollY > 60) {
        navbar.classList.add("navbar_box_shadow");
    } else {
        navbar.classList.remove("navbar_box_shadow")
    }
});

// HANDLING EVENTS FORM
const cree_evenement_form = document.querySelector("#ajouter_evenement");
const reserver_evenement_form = document.querySelector("#reserver_evenement");

const reserver_redirect_btn = document.querySelector("#ajouter_evenement .reserver");
const cree_redirect_btn = document.querySelector("#reserver_evenement .cree");

reserver_redirect_btn.addEventListener("click", e => {
    e.preventDefault();
    cree_evenement_form.style.display = "none";
    reserver_evenement_form.style.display = "flex"
});

cree_redirect_btn.addEventListener("click", e => {
    e.preventDefault();
    reserver_evenement_form.style.display = "none";
    cree_evenement_form.style.display = "flex"
});

document.addEventListener("DOMContentLoaded", function() {
    const signUpButton = document.getElementById("signUp");
    const signInButton = document.getElementById("signIn");
    const containeren = document.getElementById("containeren");
      
    signUpButton.addEventListener("click", () => {
        containeren.classList.add("right-panel-active");
    });
      
    signInButton.addEventListener("click", () => {
        containeren.classList.remove("right-panel-active");
    });
});
    
const containerr = document.getElementById('containerr');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    containerr.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    containerr.classList.remove("active");
});

const images = document.querySelectorAll('.imageee');

    images.forEach((imageee, index) => {
      imageee.style.animation = `fadeIn 1s ease-out ${index / 6}s both`;
    });
