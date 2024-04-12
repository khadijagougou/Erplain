package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum NoteCreditProduitPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    NoteCreditProduitPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "noteCreditProduit";
    }

    @Override
    public String authority() {
        return value;
    }
}
