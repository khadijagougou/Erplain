package org.sir.erplain.dao.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeDao extends JpaRepository<Employe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Employe findByAddressId(Long id);
int deleteByEntrepriseId(Long id);
List<Employe> findByEntrepriseId(Long id);
}