package org.sir.erplain.dao.inventaire.boncommande;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BonCommandeDao extends JpaRepository<BonCommande, Long> {
int deleteByIdIn(List<Long> ids);
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