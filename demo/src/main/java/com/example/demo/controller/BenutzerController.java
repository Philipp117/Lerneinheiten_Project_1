package com.example.demo.controller;


import com.example.demo.BenutzerService;
import com.example.demo.model.Gruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/benutzer")
@RequiredArgsConstructor    //Konstruktor für alle finals (Wie Autowired)
public class BenutzerController
{

    private final BenutzerService benutzerService;

    @GetMapping
    public String showBenutzer(@RequestParam Integer benutzerId)
    {
        return benutzerService.showBenutzerInfo(benutzerId);
    }


    @PostMapping        //Neuen Eintrag
    public String anlegenBenutzer(@RequestBody String newBenutzer, String mailAdresse, Integer gruppeId)    //Anlegen einer neuen gruppe mittels Anfrage an den Service //@RequestBody Nachricht (der neue Name) schicke ich per Body mit
    {
        return benutzerService.addNewBenutzer(newBenutzer, mailAdresse, gruppeId);
    }

    @PutMapping
    public String updateBenutzer(@RequestBody String updateBenutzerName, Integer oldBenutzerId)
    {
        return benutzerService.updateBenutzer(updateBenutzerName, oldBenutzerId);
    }
}
