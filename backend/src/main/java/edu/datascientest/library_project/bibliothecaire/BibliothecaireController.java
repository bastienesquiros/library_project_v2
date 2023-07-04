package edu.datascientest.library_project.bibliothecaire;

import edu.datascientest.library_project.auteur.AuteurService;
import edu.datascientest.library_project.ouvrage.Ouvrage;
import edu.datascientest.library_project.ouvrage.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bibliothecaire")
public class BibliothecaireController {
	@Autowired
	OuvrageService ouvrageService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Ouvrage> getOuvrage(){
		return ouvrageService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("ouvrage")
	public Ouvrage findById(@RequestParam(name = "id_ouvrage") Integer id_ouvrage) {
		return ouvrageService.findById(id_ouvrage);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postOuvrage(@RequestBody Ouvrage ouvrage) {
		ouvrageService.save(ouvrage);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateClient(@RequestBody Ouvrage request) {
		ouvrageService.update(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("{id_ouvrage}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOuvrage(@PathVariable("id_ouvrage") Integer id_ouvrage) {
		ouvrageService.delete(id_ouvrage);
	}
}
