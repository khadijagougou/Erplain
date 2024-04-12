package org.sir.erplain.service.facade.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import java.util.List;
public interface LivraisonProduitService {
LivraisonProduit findById(Long id);
List<LivraisonProduit> findAllOptimized();
List<LivraisonProduit> findAll();
LivraisonProduit create(LivraisonProduit item);
List<LivraisonProduit> create(List<LivraisonProduit> item);
LivraisonProduit update(LivraisonProduit item);
List<LivraisonProduit> update(List<LivraisonProduit> item);
void deleteById(Long id);
void delete(LivraisonProduit item);
void delete(List<LivraisonProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByLivraisonId(Long id);
List<LivraisonProduit> findByLivraisonId(Long id);
}