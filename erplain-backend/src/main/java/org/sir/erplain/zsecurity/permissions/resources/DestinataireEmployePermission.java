package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum DestinataireEmployePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    DestinataireEmployePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "destinataireEmploye";
    }

    @Override
    public String authority() {
        return value;
    }
}
