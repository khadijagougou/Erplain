package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.sir.erplain.bean.core.parametres.Alerte;
import java.util.List;
public interface DestinataireEmployeService {
DestinataireEmploye findById(Long id);
List<DestinataireEmploye> findAllOptimized();
List<DestinataireEmploye> findAll();
DestinataireEmploye create(DestinataireEmploye item);
List<DestinataireEmploye> create(List<DestinataireEmploye> item);
DestinataireEmploye update(DestinataireEmploye item);
List<DestinataireEmploye> update(List<DestinataireEmploye> item);
void deleteById(Long id);
void delete(DestinataireEmploye item);
void delete(List<DestinataireEmploye> items);
void deleteByIdIn(List<Long> ids);
int deleteByAlerteId(Long id);
List<DestinataireEmploye> findByAlerteId(Long id);
}