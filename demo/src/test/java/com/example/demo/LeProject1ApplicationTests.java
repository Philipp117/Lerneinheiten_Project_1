package com.example.demo;

import com.example.demo.db.BenutzerRepository;
import com.example.demo.db.GruppeRepository;
import com.example.demo.model.Benutzer;
import com.example.demo.model.Gruppe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class LeProject1ApplicationTests {

	@Autowired
	private MockMvc mvc;	//Für die Simulation

	@Autowired
	private GruppeRepository gruppeRepository;
	@Autowired
	private BenutzerRepository benutzerRepository;



	@Test
	void contextLoads() throws Exception {
		MvcResult mvcResult = mvc.perform(post("/gruppe").content("TestGruppe")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		Integer erg = Integer.valueOf(mvcResult.getResponse().getContentAsString());

		Gruppe gruppe = gruppeRepository.findById(erg).orElse(null);

		Assertions.assertEquals("TestGruppe", gruppe.getGruppenName());
		Assertions.assertEquals(0, gruppe.getBenutzerZaehler());
	}

	@Test
	void secondTest () throws Exception
	{
		Gruppe g = new Gruppe(null, "Gruppe", 0,null);
		gruppeRepository.save(g);
		MvcResult mvcResult = mvc.perform(post("/benutzer").content("TestBenutzer").param("mailAdresse", "mail").param("gruppeId", String.valueOf(g.getGruppeId()))//Content = body
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		Integer erg = Integer.valueOf(mvcResult.getResponse().getContentAsString());
		Benutzer benutzer = benutzerRepository.findById(erg).orElse(null);

		Assertions.assertEquals("TestBenutzer", benutzer.getBenutzerName());
		Assertions.assertEquals("mail", benutzer.getMailAdresse());
		Assertions.assertEquals("Gruppe", benutzer.getGruppenName());
	}



}
