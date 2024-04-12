package org.sir.erplain.dao.ventes.facture;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface FactureTaxeExpeditionDao extends JpaRepository<FactureTaxeExpedition, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
List<FactureTaxeExpedition> findByFactureId(Long id);
int deleteByTaxeId(Long id);
List<FactureTaxeExpedition> findByTaxeId(Long id);
}