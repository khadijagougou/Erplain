package org.sir.erplain.service.facade.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import java.util.List;
public interface LivraisonService {
Livraison findById(Long id);
List<Livraison> findAllOptimized();
List<Livraison> findAll();
Livraison create(Livraison item);
List<Livraison> create(List<Livraison> item);
Livraison update(Livraison item);
List<Livraison> update(List<Livraison> item);
void deleteById(Long id);
void delete(Livraison item);
void delete(List<Livraison> items);
void deleteByIdIn(List<Long> ids);
int deleteByFournisseurId(Long id);
List<Livraison> findByFournisseurId(Long id);
int deleteByEntrepriseId(Long id);
List<Livraison> findByEntrepriseId(Long id);
}