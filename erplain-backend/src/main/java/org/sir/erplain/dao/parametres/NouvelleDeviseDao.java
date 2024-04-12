package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.NouvelleDevise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface NouvelleDeviseDao extends JpaRepository<NouvelleDevise, Long> {
int deleteByIdIn(List<Long> ids);
}