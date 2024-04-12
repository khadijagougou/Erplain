package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import java.util.List;
public interface DevisService {
Devis findById(Long id);
List<Devis> findAllOptimized();
List<Devis> findAll();
Devis create(Devis item);
List<Devis> create(List<Devis> item);
Devis update(Devis item);
List<Devis> update(List<Devis> item);
void deleteById(Long id);
void delete(Devis item);
void delete(List<Devis> items);
void deleteByIdIn(List<Long> ids);
int deleteByNouvelleDeviseId(Long id);
List<Devis> findByNouvelleDeviseId(Long id);
}