package org.sir.erplain.service.facade.contacts;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface ClientTaxeService {
ClientTaxe findById(Long id);
List<ClientTaxe> findAllOptimized();
List<ClientTaxe> findAll();
ClientTaxe create(ClientTaxe item);
List<ClientTaxe> create(List<ClientTaxe> item);
ClientTaxe update(ClientTaxe item);
List<ClientTaxe> update(List<ClientTaxe> item);
void deleteById(Long id);
void delete(ClientTaxe item);
void delete(List<ClientTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<ClientTaxe> findByClientId(Long id);
int deleteByTaxeId(Long id);
List<ClientTaxe> findByTaxeId(Long id);
}