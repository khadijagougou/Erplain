package org.sir.erplain.service.facade.inventaire;
import org.sir.erplain.bean.core.inventaire.NiveauStock;
import org.sir.erplain.bean.core.parametres.Entreprise;
import java.util.List;
public interface NiveauStockService {
NiveauStock findById(Long id);
List<NiveauStock> findAllOptimized();
List<NiveauStock> findAll();
NiveauStock create(NiveauStock item);
List<NiveauStock> create(List<NiveauStock> item);
NiveauStock update(NiveauStock item);
List<NiveauStock> update(List<NiveauStock> item);
void deleteById(Long id);
void delete(NiveauStock item);
void delete(List<NiveauStock> items);
void deleteByIdIn(List<Long> ids);
int deleteByEntrepriseId(Long id);
List<NiveauStock> findByEntrepriseId(Long id);
}