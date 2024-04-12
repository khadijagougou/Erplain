package org.sir.erplain.service.impl.produit;

import org.sir.erplain.bean.core.produit.Produit;
import org.sir.erplain.bean.core.produit.ProduitTaxe;
import org.sir.erplain.dao.produit.ProduitDao;
import org.sir.erplain.service.facade.contacts.FournisseurService;
import org.sir.erplain.service.facade.inventaire.NiveauStockService;
import org.sir.erplain.service.facade.parametres.EntrepriseService;
import org.sir.erplain.service.facade.produit.ProduitService;
import org.sir.erplain.service.facade.produit.ProduitTaxeService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    //--------------- FIND -------------------------------------
    public Produit findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Produit> findAll() {
        return dao.findAll();
    }

    public List<Produit> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Produit create(Produit item) {
        if (item == null) return null;
        Produit saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Produit> create(List<Produit> items) {
        List<Produit> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Produit update(Produit item) {
        if (item == null || item.getId() == null) return null;
        Produit saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Produit> update(List<Produit> items) {
        List<Produit> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Produit item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Produit item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Produit> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Produit item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByNiveauStockId(Long id) {
        Produit found = findByNiveauStockId(id);
        if (found == null) return 0;
        this.deleteAssociated(found);
        return dao.deleteByNiveauStockId(id);
    }

    @Override
    public Produit findByNiveauStockId(Long id) {
        return dao.findByNiveauStockId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByFournisseurId(Long id) {
        if (id == null) return 0;
        List<Produit> found = findByFournisseurId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByFournisseurId(id);
    }

    @Override
    public List<Produit> findByFournisseurId(Long id) {
        return dao.findByFournisseurId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByEntrepriseId(Long id) {
        if (id == null) return 0;
        List<Produit> found = findByEntrepriseId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByEntrepriseId(id);
    }

    @Override
    public List<Produit> findByEntrepriseId(Long id) {
        return dao.findByEntrepriseId(id);
    }

    //----------------------------------------------------------
    public void createAssociatedList(Produit item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Produit::getProduitTaxe, ProduitTaxe::setProduit, produitTaxeService::create);
    }

    public void updateAssociatedList(Produit item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, produitTaxeService.findByProduitId(item.getId()),
                item.getProduitTaxe(), ProduitTaxe::setProduit,
                produitTaxeService::update,
                produitTaxeService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Produit item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Produit item) {
        produitTaxeService.deleteByProduitId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private ProduitDao dao;
    @Lazy
    @Autowired
    private NiveauStockService niveauStockService;
    @Lazy
    @Autowired
    private ProduitTaxeService produitTaxeService;
    @Lazy
    @Autowired
    private FournisseurService fournisseurService;
    @Lazy
    @Autowired
    private EntrepriseService entrepriseService;
}