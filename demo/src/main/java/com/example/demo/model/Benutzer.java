package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="benutzer_id_gen", sequenceName = "benutzer_id_seq")
@Getter //Lombok
@Setter //Lombok
@AllArgsConstructor
@NoArgsConstructor
public class Benutzer
{

    @Id
    @GeneratedValue(generator = "benutzer_id_gen")
    @Column(name ="benutzer_id")
    private Integer benutzerId;


    @Column(name="benutzer_mailadresse")
    private String mailAdresse;

    @Column(name = "benutzer_name", length = 300)
    private String benutzerName;

    @Column(name= "gruppen_name")
    private String gruppenName;

    @ManyToOne
    private Gruppe gruppe;


    public Benutzer(String benutzerName)
    {
        this.benutzerName = benutzerName;
    }

}