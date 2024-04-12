package org.sir.erplain.service.facade.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditProduit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import java.util.List;
public interface NoteCreditProduitService {
NoteCreditProduit findById(Long id);
List<NoteCreditProduit> findAllOptimized();
List<NoteCreditProduit> findAll();
NoteCreditProduit create(NoteCreditProduit item);
List<NoteCreditProduit> create(List<NoteCreditProduit> item);
NoteCreditProduit update(NoteCreditProduit item);
List<NoteCreditProduit> update(List<NoteCreditProduit> item);
void deleteById(Long id);
void delete(NoteCreditProduit item);
void delete(List<NoteCreditProduit> items);
void deleteByIdIn(List<Long> ids);
int deleteByNoteCreditId(Long id);
List<NoteCreditProduit> findByNoteCreditId(Long id);
}