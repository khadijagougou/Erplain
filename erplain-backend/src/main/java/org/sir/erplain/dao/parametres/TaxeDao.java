package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface TaxeDao extends JpaRepository<Taxe, Long> {
int deleteByIdIn(List<Long> ids);
}