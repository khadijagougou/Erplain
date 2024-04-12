package org.sir.erplain.dao.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface LivraisonProduitDao extends JpaRepository<LivraisonProduit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByLivraisonId(Long id);
List<LivraisonProduit> findByLivraisonId(Long id);
}