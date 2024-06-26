package org.sir.erplain.service.facade.ventes.remboursement;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementProduit;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.ventes.remboursement.RemboursementTaxe;
import java.util.List;
public interface RemboursementService {
Remboursement findById(Long id);
List<Remboursement> findAllOptimized();
List<Remboursement> findAll();
Remboursement create(Remboursement item);
List<Remboursement> create(List<Remboursement> item);
Remboursement update(Remboursement item);
List<Remboursement> update(List<Remboursement> item);
void deleteById(Long id);
void delete(Remboursement item);
void delete(List<Remboursement> items);
void deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<Remboursement> findByClientId(Long id);
int deleteByRetourProduitId(Long id);
List<Remboursement> findByRetourProduitId(Long id);
int deleteByEntrepriseId(Long id);
List<Remboursement> findByEntrepriseId(Long id);
int deleteByDevisId(Long id);
List<Remboursement> findByDevisId(Long id);
int deleteByNiveauPrixId(Long id);
List<Remboursement> findByNiveauPrixId(Long id);
}