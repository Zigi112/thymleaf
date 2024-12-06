package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Contact;
import com.example.Model.Personne;

public interface contactRepository extends JpaRepository<Contact, Long> {

}
