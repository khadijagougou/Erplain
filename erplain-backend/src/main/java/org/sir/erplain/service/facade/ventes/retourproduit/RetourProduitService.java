package org.sir.erplain.service.facade.ventes.retourproduit;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduit;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.bean.core.ventes.remboursement.Remboursement;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.bean.core.ventes.retourproduit.RetourProduitProduit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import java.util.List;
public interface RetourProduitService {
RetourProduit findById(Long id);
List<RetourProduit> findAllOptimized();
List<RetourProduit> findAll();
RetourProduit create(RetourProduit item);
List<RetourProduit> create(List<RetourProduit> item);
RetourProduit update(RetourProduit item);
List<RetourProduit> update(List<RetourProduit> item);
void deleteById(Long id);
void delete(RetourProduit item);
void delete(List<RetourProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<RetourProduit> findByClientId(Long id);
int deleteByFactureId(Long id);
List<RetourProduit> findByFactureId(Long id);
int deleteByEntrepriseId(Long id);
List<RetourProduit> findByEntrepriseId(Long id);
}