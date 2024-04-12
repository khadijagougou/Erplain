package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum AdminPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    AdminPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "admin";
    }

    @Override
    public String authority() {
        return value;
    }
}
