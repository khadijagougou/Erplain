package org.sir.erplain.bean.core.parametres;

import jakarta.persistence.*;
import org.sir.erplain.bean.core.contacts.user.Employe;

/**
 * This Class is for Association between 'Alerte' and 'Employe'
 */
@Entity
@Table(name = "destinataireemploye")
public class DestinataireEmploye {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Alerte alerte;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employe employe;

    public DestinataireEmploye() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alerte getAlerte() {
        return alerte;
    }

    public void setAlerte(Alerte value) {
        this.alerte = value;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof DestinataireEmploye destinataireEmploye) {
            return destinataireEmploye.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}