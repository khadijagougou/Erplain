package org.sir.erplain.service.facade.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeProduit;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import java.util.List;
public interface BonCommandeService {
BonCommande findById(Long id);
List<BonCommande> findAllOptimized();
List<BonCommande> findAll();
BonCommande create(BonCommande item);
List<BonCommande> create(List<BonCommande> item);
BonCommande update(BonCommande item);
List<BonCommande> update(List<BonCommande> item);
void deleteById(Long id);
void delete(BonCommande item);
void delete(List<BonCommande> items);
void deleteByIdIn(List<Long> ids);
int deleteByLivraisonId(Long id);
BonCommande findByLivraisonId(Long id);
int deleteByFournisseurId(Long id);
List<BonCommande> findByFournisseurId(Long id);
int deleteByEntrepriseId(Long id);
List<BonCommande> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<BonCommande> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<BonCommande> findByNiveauPrixId(Long id);
}