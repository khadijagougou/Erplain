package org.sir.erplain.ws.dto.contacts.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.erplain.bean.enums.LangueEnum;
import org.sir.erplain.ws.dto.parametres.AlerteDto;
import org.sir.erplain.ws.dto.parametres.EntrepriseDto;
import org.sir.erplain.zsecurity.ws.dto.AppUserDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDto extends AppUserDto {
    private Long id;
    private String nom;
    private String prenom;
    private LangueEnum languePDF;
    private EntrepriseDto entreprise;
    private List<AlerteDto> alertes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String value) {
        this.prenom = value;
    }

    public LangueEnum getLanguePDF() {
        return languePDF;
    }

    public void setLanguePDF(LangueEnum value) {
        this.languePDF = value;
    }

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto value) {
        this.entreprise = value;
    }

    public List<AlerteDto> getAlertes() {
        return alertes;
    }

    public void setAlertes(List<AlerteDto> value) {
        this.alertes = value;
    }
}