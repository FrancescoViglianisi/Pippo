package it.epicode.be.segreteriastudentirest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteriastudentirest.model.CorsoDiLaurea;
import it.epicode.be.segreteriastudentirest.model.Docente;
import it.epicode.be.segreteriastudentirest.model.Libretto;
import it.epicode.be.segreteriastudentirest.model.Studente;
import it.epicode.be.segreteriastudentirest.repository.CorsoDiLaureaRepository;
import it.epicode.be.segreteriastudentirest.repository.DocenteRepository;
import it.epicode.be.segreteriastudentirest.repository.LibrettoRepository;
import it.epicode.be.segreteriastudentirest.repository.StudenteRepository;

@Component
public class DataLoadRunner implements CommandLineRunner {
	
	@Autowired
	StudenteRepository studenteRepository;
	
	@Autowired
	CorsoDiLaureaRepository corsoRepository;
	
	@Autowired
	LibrettoRepository librettoRepository;
	
	@Autowired
	DocenteRepository docenteRepository;


	@Override
	public void run(String... args) throws Exception {
		
		
		Docente docente = new Docente();
		List<Docente> docenti = new ArrayList<>();
		
		docente.setCognome("Babbut");
		docente.setNome("String");
		
		
		docenteRepository.save(docente);
		docenti.add(docente);
		
		
		CorsoDiLaurea corso = new CorsoDiLaurea();
		CorsoDiLaurea corso2 = new CorsoDiLaurea();
		
		
		corso.setCodice("A12");
		corso.setIndirizzo("Via Nazionale 15");
		corso.setNome("Ingegneria gestionale");
		corso.setNumeroEsami(12);
		//corso.setStudenti(studenti);
		corso.setDocenti(docenti);
		
		corso2.setCodice("B21");
		corso2.setIndirizzo("Via di prova 15");
		corso2.setNome("Economia");
		corso2.setNumeroEsami(20);
		//corso2.setStudenti(studenti);
		corso2.setDocenti(docenti);
		
		corsoRepository.save(corso);
		corsoRepository.save(corso2);
		
		Studente studente = new Studente();
		Studente studente2 = new Studente();
		//List<Studente> studenti = new ArrayList<Studente>();
		
		studente.setCitta("Milano");
		studente.setCognome("Banfi");
		studente.setCorsoDiLaurea(corso);
		studente.setEmail("ciao@gmail.com");
		studente.setIndirizzo("Via Bologna 63");
		studente.setNome("Tiberio");
		
		studente2.setCitta("Genova");
		studente2.setCognome("Sparrow");
		studente2.setCorsoDiLaurea(corso2);
		studente2.setEmail("pippo@gmail.com");
		studente2.setIndirizzo("Via di li 63");
		studente2.setNome("Jack");
		
		studenteRepository.save(studente);
		studenteRepository.save(studente2);
		
		Libretto libretto = new Libretto();
		Libretto libretto2 = new Libretto();
		
		libretto.setCodiceLibretto("aaa1");
		libretto.setStudente(studente);
		
		libretto2.setCodiceLibretto("bbb2");
		libretto2.setStudente(studente2);
		
		librettoRepository.save(libretto);
		librettoRepository.save(libretto2);
		
		
		

	}

}
