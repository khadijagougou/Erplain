package org.sir.erplain.service.facade.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import java.util.List;
public interface EstimationService {
Estimation findById(Long id);
List<Estimation> findAllOptimized();
List<Estimation> findAll();
Estimation create(Estimation item);
List<Estimation> create(List<Estimation> item);
Estimation update(Estimation item);
List<Estimation> update(List<Estimation> item);
void deleteById(Long id);
void delete(Estimation item);
void delete(List<Estimation> items);
void deleteByIdIn(List<Long> ids);
int deleteByFactureId(Long id);
Estimation findByFactureId(Long id);
int deleteByClientId(Long id);
List<Estimation> findByClientId(Long id);
int deleteByEntrepriseId(Long id);
List<Estimation> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Estimation> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Estimation> findByNiveauPrixId(Long id);
}