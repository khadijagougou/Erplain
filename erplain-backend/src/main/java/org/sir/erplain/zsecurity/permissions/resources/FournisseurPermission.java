package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum FournisseurPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    FournisseurPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "fournisseur";
    }

    @Override
    public String authority() {
        return value;
    }
}
