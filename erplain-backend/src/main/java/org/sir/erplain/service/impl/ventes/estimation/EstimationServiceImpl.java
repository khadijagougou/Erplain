package org.sir.erplain.service.impl.ventes.estimation;
import org.sir.erplain.bean.core.ventes.estimation.Estimation;
import org.sir.erplain.dao.ventes.estimation.EstimationDao;
import org.sir.erplain.service.facade.ventes.estimation.EstimationService;
import org.sir.erplain.bean.core.ventes.facture.Facture;
import org.sir.erplain.service.facade.ventes.facture.FactureService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxe;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationTaxeExpedition;
import org.sir.erplain.service.facade.ventes.estimation.EstimationTaxeExpeditionService;
import org.sir.erplain.bean.core.ventes.estimation.EstimationProduit;
import org.sir.erplain.service.facade.ventes.estimation.EstimationProduitService;
import org.sir.erplain.bean.core.contacts.Client;
import org.sir.erplain.service.facade.contacts.ClientService;
import org.sir.erplain.bean.core.parametres.Entreprise;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.bean.core.parametres.Devis;
import org.sir.erplain.service.facade.parametres.DevisService;
import org.sir.erplain.bean.core.parametres.NiveauPrix;
import org.sir.erplain.service.facade.parametres.NiveauPrixService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class EstimationServiceImpl implements EstimationService {
//--------------- FIND -------------------------------------
public Estimation findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Estimation> findAll() {
return dao.findAll();
}
public List<Estimation> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Estimation create(Estimation item) {
if (item == null) return null;
Estimation saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Estimation> create(List<Estimation> items) {
List<Estimation> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Estimation update(Estimation item) {
if (item == null || item.getId() == null) return null;
Estimation saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Estimation> update(List<Estimation> items) {
List<Estimation> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Estimation item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Estimation item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Estimation> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Estimation item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByFactureId(Long id){
Estimation found = findByFactureId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByFactureId(id);
}
@Override
public Estimation findByFactureId(Long id){
return dao.findByFactureId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
List<Estimation> found = findByClientId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByClientId(id);
}
@Override
public List<Estimation> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEntrepriseId(Long id){
if (id == null) return 0;
List<Estimation> found = findByEntrepriseId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByEntrepriseId(id);
}
@Override
public List<Estimation> findByEntrepriseId(Long id){
return dao.findByEntrepriseId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByDevisId(Long id){
if (id == null) return 0;
List<Estimation> found = findByDevisId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByDevisId(id);
}
@Override
public List<Estimation> findByDevisId(Long id){
return dao.findByDevisId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByNiveauPrixId(Long id){
if (id == null) return 0;
List<Estimation> found = findByNiveauPrixId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByNiveauPrixId(id);
}
@Override
public List<Estimation> findByNiveauPrixId(Long id){
return dao.findByNiveauPrixId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Estimation item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Estimation::getEstimationTaxe, EstimationTaxe::setEstimation, estimationTaxeService::create);
ServiceHelper.createList(item, Estimation::getEstimationTaxeExpedition, EstimationTaxeExpedition::setEstimation, estimationTaxeExpeditionService::create);
ServiceHelper.createList(item, Estimation::getEstimationProduit, EstimationProduit::setEstimation, estimationProduitService::create);
}
public void updateAssociatedList(Estimation item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, estimationTaxeService.findByEstimationId(item.getId()),
item.getEstimationTaxe(), EstimationTaxe::setEstimation,
estimationTaxeService::update,
estimationTaxeService::delete
);
ServiceHelper.updateList(
item, estimationTaxeExpeditionService.findByEstimationId(item.getId()),
item.getEstimationTaxeExpedition(), EstimationTaxeExpedition::setEstimation,
estimationTaxeExpeditionService::update,
estimationTaxeExpeditionService::delete
);
ServiceHelper.updateList(
item, estimationProduitService.findByEstimationId(item.getId()),
item.getEstimationProduit(), EstimationProduit::setEstimation,
estimationProduitService::update,
estimationProduitService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Estimation item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Estimation item) {
estimationTaxeService.deleteByEstimationId(item.getId());
estimationTaxeExpeditionService.deleteByEstimationId(item.getId());
estimationProduitService.deleteByEstimationId(item.getId());
}
//----------------------------------------------------------
@Autowired private EstimationDao dao;
@Lazy @Autowired private FactureService factureService;
@Lazy @Autowired private EstimationTaxeService estimationTaxeService;
@Lazy @Autowired private EstimationTaxeExpeditionService estimationTaxeExpeditionService;
@Lazy @Autowired private EstimationProduitService estimationProduitService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EntrepriseService entrepriseService;
@Lazy @Autowired private DevisService devisService;
@Lazy @Autowired private NiveauPrixService niveauPrixService;
}