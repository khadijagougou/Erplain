package org.sir.erplain.service.facade.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Admin;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.Alerte;
import java.util.List;
public interface AdminService {
Admin findById(Long id);
List<Admin> findAllOptimized();
List<Admin> findAll();
Admin create(Admin item);
List<Admin> create(List<Admin> item);
Admin update(Admin item);
List<Admin> update(List<Admin> item);
void deleteById(Long id);
void delete(Admin item);
void delete(List<Admin> items);
void deleteByIdIn(List<Long> ids);
int deleteByEntrepriseId(Long id);
Admin findByEntrepriseId(Long id);
}