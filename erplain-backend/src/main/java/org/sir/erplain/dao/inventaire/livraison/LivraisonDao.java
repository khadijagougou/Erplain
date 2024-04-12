package org.sir.erplain.dao.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface LivraisonDao extends JpaRepository<Livraison, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByFournisseurId(Long id);
List<Livraison> findByFournisseurId(Long id);
int deleteByEntrepriseId(Long id);
List<Livraison> findByEntrepriseId(Long id);
}