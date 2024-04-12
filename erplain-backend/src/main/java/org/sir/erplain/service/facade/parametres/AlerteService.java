package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.sir.erplain.bean.core.contacts.user.Admin;
import java.util.List;
public interface AlerteService {
Alerte findById(Long id);
List<Alerte> findAllOptimized();
List<Alerte> findAll();
Alerte create(Alerte item);
List<Alerte> create(List<Alerte> item);
Alerte update(Alerte item);
List<Alerte> update(List<Alerte> item);
void deleteById(Long id);
void delete(Alerte item);
void delete(List<Alerte> items);
void deleteByIdIn(List<Long> ids);
int deleteByAdminId(Long id);
List<Alerte> findByAdminId(Long id);
}