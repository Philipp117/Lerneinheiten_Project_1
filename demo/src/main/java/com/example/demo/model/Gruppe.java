package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="gruppe_id_gen", sequenceName = "gruppe_id_seq")
@Getter //Lombok
@Setter //Lombok
@AllArgsConstructor
@NoArgsConstructor
public class Gruppe
{

    @Id
    @GeneratedValue(generator = "gruppe_id_gen")
    @Column(name ="gruppe_id")
    private Integer gruppeId;

    @Column(name="gruppen_name")
    private String gruppenName;

    @Column(name = "benutzer_zaehler")
    private Integer benutzerZaehler;


    @OneToMany(mappedBy = "gruppe")
    private List<Benutzer> benutzers;


    public Gruppe(String gruppenName)
    {
        this.gruppenName = gruppenName;
    }


}