package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface DestinataireEmployeDao extends JpaRepository<DestinataireEmploye, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAlerteId(Long id);
List<DestinataireEmploye> findByAlerteId(Long id);
}