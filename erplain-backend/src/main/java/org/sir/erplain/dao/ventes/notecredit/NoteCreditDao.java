package org.sir.erplain.dao.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface NoteCreditDao extends JpaRepository<NoteCredit, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<NoteCredit> findByClientId(Long id);
int deleteByRetourProduitId(Long id);
List<NoteCredit> findByRetourProduitId(Long id);
int deleteByEntrepriseId(Long id);
List<NoteCredit> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<NoteCredit> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<NoteCredit> findByNiveauPrixId(Long id);
}