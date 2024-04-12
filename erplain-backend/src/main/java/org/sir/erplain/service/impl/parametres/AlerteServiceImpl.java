package org.sir.erplain.service.impl.parametres;

import org.sir.erplain.bean.core.parametres.Alerte;
import org.sir.erplain.bean.core.parametres.DestinataireEmploye;
import org.sir.erplain.dao.parametres.AlerteDao;
import org.sir.erplain.service.facade.contacts.user.AdminService;
import org.sir.erplain.service.facade.parametres.AlerteService;
import org.sir.erplain.service.facade.parametres.DestinataireEmployeService;
import org.sir.erplain.zutils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlerteServiceImpl implements AlerteService {
    //--------------- FIND -------------------------------------
    public Alerte findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Alerte> findAll() {
        return dao.findAll();
    }

    public List<Alerte> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Alerte create(Alerte item) {
        if (item == null) return null;
        Alerte saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Alerte> create(List<Alerte> items) {
        List<Alerte> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Alerte update(Alerte item) {
        if (item == null || item.getId() == null) return null;
        Alerte saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Alerte> update(List<Alerte> items) {
        List<Alerte> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Alerte item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Alerte item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Alerte> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Alerte item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAdminId(Long id) {
        if (id == null) return 0;
        List<Alerte> found = findByAdminId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<Alerte> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    //----------------------------------------------------------
    public void createAssociatedList(Alerte item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(
                item,
                Alerte::getDestinataireEmploye,
                DestinataireEmploye::setAlerte,
                destinataireEmployeService::create
        );
    }

    public void updateAssociatedList(Alerte item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, destinataireEmployeService.findByAlerteId(item.getId()),
                item.getDestinataireEmploye(), DestinataireEmploye::setAlerte,
                destinataireEmployeService::update,
                destinataireEmployeService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Alerte item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Alerte item) {
        destinataireEmployeService.deleteByAlerteId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private AlerteDao dao;
    @Lazy
    @Autowired
    private DestinataireEmployeService destinataireEmployeService;
    @Lazy
    @Autowired
    private AdminService adminService;
}