package org.sir.erplain.dao.address;
import org.sir.erplain.bean.core.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AddressDao extends JpaRepository<Address, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByCountryId(Long id);
List<Address> findByCountryId(Long id);
}