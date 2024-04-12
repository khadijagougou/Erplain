package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum RemboursementTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    RemboursementTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "remboursementTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
