package com.example.demo;

import com.example.demo.db.BenutzerRepository;
import com.example.demo.db.GruppeRepository;
import com.example.demo.model.Benutzer;
import com.example.demo.model.Gruppe;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
@Component
@AllArgsConstructor
public class FillDatabase implements CommandLineRunner {

    private GruppeRepository gruppeRepository;

    private BenutzerRepository benutzerRepository;

    @Override
    public void run(String... args) throws Exception {
        Gruppe g = new Gruppe("Test Gruppe 1");
        gruppeRepository.save(g);

        Benutzer b = new Benutzer("Philipp");
        benutzerRepository.save(b);


    }
}*/