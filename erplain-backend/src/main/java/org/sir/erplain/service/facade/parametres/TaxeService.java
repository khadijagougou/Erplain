package org.sir.erplain.service.facade.parametres;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.bean.core.contacts.ClientTaxe;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxe;
import org.sir.erplain.bean.core.ventes.facture.FactureTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxe;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.livraison.LivraisonTaxeExpedition;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.bean.core.inventaire.boncommande.BonCommandeTaxeExpedition;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import org.sir.erplain.bean.core.ventes.commande.CommandeTaxe;
import java.util.List;
public interface TaxeService {
Taxe findById(Long id);
List<Taxe> findAllOptimized();
List<Taxe> findAll();
Taxe create(Taxe item);
List<Taxe> create(List<Taxe> item);
Taxe update(Taxe item);
List<Taxe> update(List<Taxe> item);
void deleteById(Long id);
void delete(Taxe item);
void delete(List<Taxe> items);
void deleteByIdIn(List<Long> ids);
}