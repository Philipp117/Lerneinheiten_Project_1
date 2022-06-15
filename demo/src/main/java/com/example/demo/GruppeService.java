package com.example.demo;


import com.example.demo.db.GruppeRepository;
import com.example.demo.model.Gruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GruppeService
{

    private final GruppeRepository gruppeRepository;



    @Transactional(readOnly = true)
    public String showGruppeInfo(Integer gruppeId)
    {
        Integer gruppe_Id = null;
        String gruppe_Name = null;
        Integer gruppe_benutzerAnzahl = 0;
        if(gruppeRepository.existsById(gruppeId)) {
            Gruppe gId = gruppeRepository.getReferenceById(gruppeId);
            gruppe_Name = gId.getGruppenName();
            gruppe_benutzerAnzahl = gId.getBenutzerZaehler();
            gruppe_Id = gId.getGruppeId();

            System.out.println("Gruppe: " + gruppe_Name);
            System.out.println("Anzahl der Benutzer = " + gruppe_benutzerAnzahl);
            System.out.println("Gruppen ID = " + gruppe_Id);

            String.valueOf(gruppe_benutzerAnzahl);
            //String.valueOf(gruppe_Id);
        }
        else
        {
            System.out.println("Gruppe nicht vorhanden! ");
        }
        return String.valueOf(gruppe_Id);
    }



    @Transactional
    public String addNewGruppe(String newGruppenName)
    {
        Gruppe g = new Gruppe(newGruppenName);
        g.setBenutzerZaehler(0);
        g = gruppeRepository.save(g);
        return String.valueOf(g.getGruppeId());
    }


    @Transactional
    public String updateGruppe(String updateGruppeName, Integer oldId)
    {
        gruppeRepository.getReferenceById(oldId).setGruppenName(updateGruppeName);
        return oldId.toString();
    }
}
