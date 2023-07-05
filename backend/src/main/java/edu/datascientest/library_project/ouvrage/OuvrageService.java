package edu.datascientest.library_project.ouvrage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OuvrageService {
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	public void save(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}
	
	public void delete(Integer id_ouvrage) {
		ouvrageRepository.deleteById(id_ouvrage);
	}
	
	public void update(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}
	
	public List<Ouvrage> findAll() {
		return ouvrageRepository.findAll();
	}

	public Ouvrage findById(Integer id_ouvrage) {
		return ouvrageRepository.findById(id_ouvrage).get();
	}

	public Ouvrage findByTitre(String titre) {
		return ouvrageRepository.findByTitre(titre);
	}
}
