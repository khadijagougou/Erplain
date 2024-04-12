package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum ProduitPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ProduitPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "produit";
    }

    @Override
    public String authority() {
        return value;
    }
}
