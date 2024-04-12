package org.sir.erplain.service.facade.inventaire.livraison;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.livraison.Livraison;
import org.sir.erplain.bean.core.parametres.Taxe;
import java.util.List;
public interface LivraisonTaxeExpeditionService {
LivraisonTaxeExpedition findById(Long id);
List<LivraisonTaxeExpedition> findAllOptimized();
List<LivraisonTaxeExpedition> findAll();
LivraisonTaxeExpedition create(LivraisonTaxeExpedition item);
List<LivraisonTaxeExpedition> create(List<LivraisonTaxeExpedition> item);
LivraisonTaxeExpedition update(LivraisonTaxeExpedition item);
List<LivraisonTaxeExpedition> update(List<LivraisonTaxeExpedition> item);
void deleteById(Long id);
void delete(LivraisonTaxeExpedition item);
void delete(List<LivraisonTaxeExpedition> items);
void deleteByIdIn(List<Long> ids);
int deleteByLivraisonId(Long id);
List<LivraisonTaxeExpedition> findByLivraisonId(Long id);
int deleteByTaxeId(Long id);
List<LivraisonTaxeExpedition> findByTaxeId(Long id);
}