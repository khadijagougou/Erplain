package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import java.util.List;
public interface NiveauPrixService {
NiveauPrix findById(Long id);
List<NiveauPrix> findAllOptimized();
List<NiveauPrix> findAll();
NiveauPrix create(NiveauPrix item);
List<NiveauPrix> create(List<NiveauPrix> item);
NiveauPrix update(NiveauPrix item);
List<NiveauPrix> update(List<NiveauPrix> item);
void deleteById(Long id);
void delete(NiveauPrix item);
void delete(List<NiveauPrix> items);
void deleteByIdIn(List<Long> ids);
}