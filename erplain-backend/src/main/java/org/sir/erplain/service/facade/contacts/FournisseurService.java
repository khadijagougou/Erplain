package org.sir.erplain.service.facade.contacts;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.address.Address;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.core.produit.Produit;
import java.util.List;
public interface FournisseurService {
Fournisseur findById(Long id);
List<Fournisseur> findAllOptimized();
List<Fournisseur> findAll();
Fournisseur create(Fournisseur item);
List<Fournisseur> create(List<Fournisseur> item);
Fournisseur update(Fournisseur item);
List<Fournisseur> update(List<Fournisseur> item);
void deleteById(Long id);
void delete(Fournisseur item);
void delete(List<Fournisseur> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Fournisseur findByAddressId(Long id);
int deleteByEntrepriseId(Long id);
List<Fournisseur> findByEntrepriseId(Long id);
int deleteByNiveauPrixId(Long id);
List<Fournisseur> findByNiveauPrixId(Long id);
}