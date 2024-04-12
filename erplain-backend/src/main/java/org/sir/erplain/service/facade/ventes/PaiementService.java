package org.sir.erplain.service.facade.ventes;
import org.sir.erplain.bean.core.ventes.Paiement;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.MethodePaiement;
import java.util.List;
public interface PaiementService {
Paiement findById(Long id);
List<Paiement> findAllOptimized();
List<Paiement> findAll();
Paiement create(Paiement item);
List<Paiement> create(List<Paiement> item);
Paiement update(Paiement item);
List<Paiement> update(List<Paiement> item);
void deleteById(Long id);
void delete(Paiement item);
void delete(List<Paiement> items);
void deleteByIdIn(List<Long> ids);
int deleteByMethodePaiementId(Long id);
List<Paiement> findByMethodePaiementId(Long id);
int deleteByEntrepriseId(Long id);
List<Paiement> findByEntrepriseId(Long id);
}