package org.sir.erplain.dao.contacts;
import org.sir.erplain.bean.core.contacts.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ClientDao extends JpaRepository<Client, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Client findByAddressId(Long id);
int deleteByEntrepriseId(Long id);
List<Client> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Client> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Client> findByNiveauPrixId(Long id);
}