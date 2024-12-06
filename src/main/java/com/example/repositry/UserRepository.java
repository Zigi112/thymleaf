package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Personne;

public interface UserRepository extends JpaRepository<Personne, Long> {
    Personne findByEmail(String email);
}
