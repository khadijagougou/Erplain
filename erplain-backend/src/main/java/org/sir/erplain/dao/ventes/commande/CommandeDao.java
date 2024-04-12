package org.sir.erplain.dao.ventes.commande;
import org.sir.erplain.bean.core.ventes.commande.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommandeDao extends JpaRepository<Commande, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
Commande findByFactureId(Long id);
int deleteByClientId(Long id);
List<Commande> findByClientId(Long id);
int deleteByEntrepriseId(Long id);
List<Commande> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Commande> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Commande> findByNiveauPrixId(Long id);
}