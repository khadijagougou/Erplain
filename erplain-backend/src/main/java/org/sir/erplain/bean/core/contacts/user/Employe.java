package org.sir.erplain.bean.core.contacts.user;

import jakarta.persistence.*;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.zsecurity.entity.AppUser;

@Entity
@Table(name = "employe")
public class Employe extends AppUser {
    private String nom;
    private String prenom;
    private String code;
    private String telephone;
    @OneToOne()
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    private Entreprise entreprise;

    public Employe() {
        super();
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

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String value) {
        this.telephone = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = value;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise value) {
        this.entreprise = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Employe employe) {
            return employe.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}