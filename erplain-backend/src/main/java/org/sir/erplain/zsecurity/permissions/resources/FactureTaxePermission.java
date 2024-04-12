package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum FactureTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    FactureTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "factureTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
