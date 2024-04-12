package org.sir.erplain.dao.contacts.user;
import org.sir.erplain.bean.core.contacts.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AdminDao extends JpaRepository<Admin, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByEntrepriseId(Long id);
Admin findByEntrepriseId(Long id);
}