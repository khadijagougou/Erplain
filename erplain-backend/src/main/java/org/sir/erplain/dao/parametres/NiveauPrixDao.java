package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface NiveauPrixDao extends JpaRepository<NiveauPrix, Long> {
int deleteByIdIn(List<Long> ids);
}