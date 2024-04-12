package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import java.util.List;
public interface MethodePaiementService {
MethodePaiement findById(Long id);
List<MethodePaiement> findAllOptimized();
List<MethodePaiement> findAll();
MethodePaiement create(MethodePaiement item);
List<MethodePaiement> create(List<MethodePaiement> item);
MethodePaiement update(MethodePaiement item);
List<MethodePaiement> update(List<MethodePaiement> item);
void deleteById(Long id);
void delete(MethodePaiement item);
void delete(List<MethodePaiement> items);
void deleteByIdIn(List<Long> ids);
}