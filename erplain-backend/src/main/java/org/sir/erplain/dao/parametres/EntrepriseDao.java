package org.sir.erplain.dao.parametres;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EntrepriseDao extends JpaRepository<Entreprise, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Entreprise findByAddressId(Long id);
}