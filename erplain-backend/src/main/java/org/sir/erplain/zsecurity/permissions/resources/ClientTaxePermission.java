package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum ClientTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ClientTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "clientTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
