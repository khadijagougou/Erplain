package org.sir.erplain.service.facade.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import java.util.List;
public interface FactureTaxeService {
FactureTaxe findById(Long id);
List<FactureTaxe> findAllOptimized();
List<FactureTaxe> findAll();
FactureTaxe create(FactureTaxe item);
List<FactureTaxe> create(List<FactureTaxe> item);
FactureTaxe update(FactureTaxe item);
List<FactureTaxe> update(List<FactureTaxe> item);
void deleteById(Long id);
void delete(FactureTaxe item);
void delete(List<FactureTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
List<FactureTaxe> findByFactureId(Long id);
int deleteByTaxeId(Long id);
List<FactureTaxe> findByTaxeId(Long id);
}