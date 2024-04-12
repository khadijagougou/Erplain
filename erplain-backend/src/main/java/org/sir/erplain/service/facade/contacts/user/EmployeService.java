package org.sir.erplain.service.facade.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.address.Address;
import java.util.List;
public interface EmployeService {
Employe findById(Long id);
List<Employe> findAllOptimized();
List<Employe> findAll();
Employe create(Employe item);
List<Employe> create(List<Employe> item);
Employe update(Employe item);
List<Employe> update(List<Employe> item);
void deleteById(Long id);
void delete(Employe item);
void delete(List<Employe> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Employe findByAddressId(Long id);
int deleteByEntrepriseId(Long id);
List<Employe> findByEntrepriseId(Long id);
}