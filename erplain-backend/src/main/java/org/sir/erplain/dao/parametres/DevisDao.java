package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface DevisDao extends JpaRepository<Devis, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByNouvelleDeviseId(Long id);
List<Devis> findByNouvelleDeviseId(Long id);
}