package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum EmployePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EmployePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "employe";
    }

    @Override
    public String authority() {
        return value;
    }
}
