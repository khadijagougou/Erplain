package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum FacturePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    FacturePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "facture";
    }

    @Override
    public String authority() {
        return value;
    }
}
