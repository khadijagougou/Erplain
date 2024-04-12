package org.sir.erplain.zsecurity.service.impl;

import org.sir.erplain.zsecurity.entity.Permission;
import org.sir.erplain.zsecurity.dao.PermissionDao;
import org.sir.erplain.zsecurity.service.facade.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}