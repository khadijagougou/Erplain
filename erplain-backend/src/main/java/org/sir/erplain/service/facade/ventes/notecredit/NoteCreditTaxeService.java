package org.sir.erplain.service.facade.ventes.notecredit;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCreditTaxe;
import org.sir.erplain.bean.core.parametres.Taxe;
import org.sir.erplain.bean.core.ventes.notecredit.NoteCredit;
import java.util.List;
public interface NoteCreditTaxeService {
NoteCreditTaxe findById(Long id);
List<NoteCreditTaxe> findAllOptimized();
List<NoteCreditTaxe> findAll();
NoteCreditTaxe create(NoteCreditTaxe item);
List<NoteCreditTaxe> create(List<NoteCreditTaxe> item);
NoteCreditTaxe update(NoteCreditTaxe item);
List<NoteCreditTaxe> update(List<NoteCreditTaxe> item);
void deleteById(Long id);
void delete(NoteCreditTaxe item);
void delete(List<NoteCreditTaxe> items);
void deleteByIdIn(List<Long> ids);
int deleteByNoteCreditId(Long id);
List<NoteCreditTaxe> findByNoteCreditId(Long id);
int deleteByTaxeId(Long id);
List<NoteCreditTaxe> findByTaxeId(Long id);
}