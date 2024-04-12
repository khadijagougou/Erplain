package org.sir.erplain.ws.converter.contacts.user;

import org.sir.erplain.bean.core.contacts.user.Admin;
import org.sir.erplain.ws.converter.parametres.AlerteConverter;
import org.sir.erplain.ws.converter.parametres.EntrepriseConverter;
import org.sir.erplain.ws.dto.contacts.user.AdminDto;
import org.sir.erplain.zsecurity.ws.converter.AppUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminConverter {
    @Autowired
    private AppUserConverter appUserConverter;
    @Autowired
    private EntrepriseConverter entrepriseConverter;
    @Autowired
    private AlerteConverter alerteConverter;
    private boolean entreprise = true;
    private boolean alertes = true;

    protected void configure(boolean value) {
        this.alerteConverter.setAdmin(value);
    }

    public final AdminDto toDto(Admin item) {
        this.configure(false);
        var dto = item != null ? convertToDto(item) : null;
        this.configure(true);
        return dto;
    }

    public final Admin toItem(AdminDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Admin> toItem(List<AdminDto> dtos) {
        if (dtos == null) return null;
        List<Admin> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<AdminDto> toDto(List<Admin> items) {
        if (items == null) return null;
        List<AdminDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Admin convertToItem(AdminDto dto) {
        var item = new Admin();
        appUserConverter.convertToChildItem(dto, item);
        item.setNom(dto.getNom());
        item.setPrenom(dto.getPrenom());
        item.setLanguePDF(dto.getLanguePDF());
        item.setEntreprise(entrepriseConverter.toItem(dto.getEntreprise()));
        item.setAlertes(alerteConverter.toItem(dto.getAlertes()));
        return item;
    }

    protected AdminDto convertToDto(Admin item) {
        var dto = new AdminDto();
        appUserConverter.convertToChildDto(item, dto);
        dto.setNom(item.getNom());
        dto.setPrenom(item.getPrenom());
        dto.setLanguePDF(item.getLanguePDF());
        dto.setEntreprise(entreprise ? entrepriseConverter.toDto(item.getEntreprise()) : null);
        dto.setAlertes(alertes ? alerteConverter.toDto(item.getAlertes()) : null);
        return dto;
    }

    public void setEntreprise(boolean value) {
        this.entreprise = value;
    }

    public void setAlertes(boolean value) {
        this.alertes = value;
    }

    public void setEntrepriseConverter(EntrepriseConverter value) {
        this.entrepriseConverter = value;
    }

    public EntrepriseConverter getEntrepriseConverter() {
        return entrepriseConverter;
    }

    public void setAlerteConverter(AlerteConverter value) {
        this.alerteConverter = value;
    }

    public AlerteConverter getAlerteConverter() {
        return alerteConverter;
    }
}