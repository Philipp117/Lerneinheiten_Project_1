package com.example.demo;


import com.example.demo.db.BenutzerRepository;
import com.example.demo.db.GruppeRepository;
import com.example.demo.model.Benutzer;
import com.example.demo.model.Gruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BenutzerService
{
    Gruppe Entwickler;
    Gruppe Administrator;

    private final BenutzerRepository benutzerRepository;
    private final GruppeRepository gruppeRepository;


    @Transactional(readOnly = true)
    public String showBenutzerInfo(Integer benutzerId)
    {
        Integer benutzer_Id = null;
        if(benutzerRepository.existsById(benutzerId)) {
            Benutzer bId = benutzerRepository.getReferenceById(benutzerId);
            String benutzer_Name = bId.getBenutzerName();
            String mail_Adresse = bId.getMailAdresse();
            //Integer gruppe_Name = benutzerRepository.getReferenceById(benutzerId).get
            benutzer_Id = bId.getBenutzerId();

            System.out.println("Benutzer: " + benutzer_Name);
            System.out.println("Mail Adresse: " + mail_Adresse);
            System.out.println("Benutzer ID = " + benutzer_Id);
        }
        else
        {
            System.out.println("Benutzer nicht vorhanden!");
        }
        return String.valueOf(benutzer_Id) ;
    }


    @Transactional
    public String addNewBenutzer(String newBenutzer, String mailAdresse, Integer gruppeId)
    {
        Benutzer b = new Benutzer(newBenutzer);
        b.setMailAdresse(mailAdresse);

        if(gruppeRepository.existsById(gruppeId)) {
            Gruppe gId = gruppeRepository.getReferenceById(gruppeId);
            String gruppe_Name = gId.getGruppenName();
            b.setGruppenName(gruppe_Name);
            Integer benutzerAnzahl = gId.getBenutzerZaehler();
            benutzerAnzahl ++;
            gId.setBenutzerZaehler(benutzerAnzahl);
            b = benutzerRepository.save(b);
        }
        else
        {
            System.out.println("Gruppe nicht vorhanden!");
        }
        return String.valueOf(b.getBenutzerId());
    }


    @Transactional
    public String updateBenutzer(String updateBenutzerName, Integer oldId)
    {
        Benutzer b = new Benutzer();
        benutzerRepository.getReferenceById(oldId).setBenutzerName(updateBenutzerName);
        return String.valueOf(b.getBenutzerId());
    }
}
