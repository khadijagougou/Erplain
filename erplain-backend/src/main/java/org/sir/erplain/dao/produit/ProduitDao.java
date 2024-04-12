package org.sir.erplain.dao.produit;
import org.sir.erplain.bean.core.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProduitDao extends JpaRepository<Produit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByNiveauStockId(Long id);
Produit findByNiveauStockId(Long id);
int deleteByFournisseurId(Long id);
List<Produit> findByFournisseurId(Long id);
int deleteByEntrepriseId(Long id);
List<Produit> findByEntrepriseId(Long id);
}