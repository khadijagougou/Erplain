package org.sir.erplain.dao.contacts;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ClientTaxeDao extends JpaRepository<ClientTaxe, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<ClientTaxe> findByClientId(Long id);
int deleteByTaxeId(Long id);
List<ClientTaxe> findByTaxeId(Long id);
}