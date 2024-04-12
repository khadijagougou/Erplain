package org.sir.erplain.service.facade.produit;
import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.bean.core.contacts.Fournisseur;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import java.util.List;
public interface ProduitService {
Produit findById(Long id);
List<Produit> findAllOptimized();
List<Produit> findAll();
Produit create(Produit item);
List<Produit> create(List<Produit> item);
Produit update(Produit item);
List<Produit> update(List<Produit> item);
void deleteById(Long id);
void delete(Produit item);
void delete(List<Produit> items);
void deleteByIdIn(List<Long> ids);
int deleteByNiveauStockId(Long id);
Produit findByNiveauStockId(Long id);
int deleteByFournisseurId(Long id);
List<Produit> findByFournisseurId(Long id);
int deleteByEntrepriseId(Long id);
List<Produit> findByEntrepriseId(Long id);
}