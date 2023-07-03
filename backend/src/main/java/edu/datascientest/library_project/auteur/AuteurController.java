package edu.datascientest.library_project.auteur;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/auteur")
public class AuteurController {
	
	@Autowired
	AuteurService auteurservice;
	
	@GetMapping
	public List<Auteur>getAuteurs(){
		return auteurservice.findAll();
		}
					
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addAuteur(@RequestBody Auteur auteur) {
		auteurservice.save(auteur);
	}
	
	@DeleteMapping("{id}")
	public void deleteAuteur(@PathVariable("id") Integer id) {
		auteurservice.delete(id);
	}
	
	@PutMapping
	public void updateAuteur(@RequestBody Auteur auteur) {
		auteurservice.update(auteur);
	}
	
	@GetMapping("auteur")
	public Auteur getAuteurById(@RequestParam(name = "id") Integer id) {
		return auteurservice.findById(id);
	}

}
