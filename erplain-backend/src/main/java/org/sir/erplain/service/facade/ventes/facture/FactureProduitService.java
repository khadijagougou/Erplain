package org.sir.erplain.service.facade.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureProduit;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import java.util.List;
public interface FactureProduitService {
FactureProduit findById(Long id);
List<FactureProduit> findAllOptimized();
List<FactureProduit> findAll();
FactureProduit create(FactureProduit item);
List<FactureProduit> create(List<FactureProduit> item);
FactureProduit update(FactureProduit item);
List<FactureProduit> update(List<FactureProduit> item);
void deleteById(Long id);
void delete(FactureProduit item);
void delete(List<FactureProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
List<FactureProduit> findByFactureId(Long id);
}