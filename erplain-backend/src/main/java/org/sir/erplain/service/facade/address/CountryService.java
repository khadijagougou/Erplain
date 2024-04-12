package org.sir.erplain.service.facade.address;
import org.sir.erplain.bean.core.address.Country;
import org.sir.erplain.bean.core.address.Address;
import java.util.List;
public interface CountryService {
Country findById(Long id);
List<Country> findAllOptimized();
List<Country> findAll();
Country create(Country item);
List<Country> create(List<Country> item);
Country update(Country item);
List<Country> update(List<Country> item);
void deleteById(Long id);
void delete(Country item);
void delete(List<Country> items);
void deleteByIdIn(List<Long> ids);
}