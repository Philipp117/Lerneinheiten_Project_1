package com.example.demo.controller;

import com.example.demo.GruppeService;
import com.example.demo.model.Gruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gruppe")
@RequiredArgsConstructor    //Konstruktor für alle finals (Wie Autowired)
public class GruppeController
{


    private final GruppeService gruppeService;


    @GetMapping
    public String showGruppe(@RequestParam Integer gruppeId)
    {
        return gruppeService.showGruppeInfo(gruppeId);
    }

    @PostMapping        //Neuen Eintrag
    public String anlegenGruppe(@RequestBody String newGruppenName)    //Anlegen einer neuen gruppe mittels Anfrage an den Service //@RequestBody Nachricht (der neue Name) schicke ich per Body mit
    {
        return gruppeService.addNewGruppe(newGruppenName);
    }

    @PutMapping
    public String updateGruppe(@RequestBody String updateGruppeName, Integer gruppeId)
    {
        return gruppeService.updateGruppe(updateGruppeName, gruppeId);
    }




}