package org.sir.erplain.dao.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface LivraisonTaxeExpeditionDao extends JpaRepository<LivraisonTaxeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByLivraisonId(Long id);
List<LivraisonTaxeExpedition> findByLivraisonId(Long id);
int deleteByTaxeId(Long id);
List<LivraisonTaxeExpedition> findByTaxeId(Long id);
}