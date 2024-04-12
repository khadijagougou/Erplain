package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum FactureProduitPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    FactureProduitPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "factureProduit";
    }

    @Override
    public String authority() {
        return value;
    }
}
