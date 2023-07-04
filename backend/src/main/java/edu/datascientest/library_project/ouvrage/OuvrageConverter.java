package edu.datascientest.library_project.ouvrage;

import edu.datascientest.library_project.auteur.Auteur;
import edu.datascientest.library_project.exemplaire.Exemplaire;

import java.util.List;

public class OuvrageConverter {

    public static OuvrageDto convertToDto(Ouvrage ouvrage){
        OuvrageDto dto = new OuvrageDto();

        dto.setId_ouvrage(ouvrage.getId_ouvrage());
        dto.setTitre(ouvrage.getTitre());
        dto.setTypeOuvrage(ouvrage.getTypeOuvrage());
        dto.setAuteurs(ouvrage.getAuteurs());
        dto.setAuteurs(ouvrage.getAuteurs());
        dto.setExemplaires(ouvrage.getExemplaires());

        return dto;
    }

}