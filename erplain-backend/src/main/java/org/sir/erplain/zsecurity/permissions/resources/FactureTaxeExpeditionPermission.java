package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum FactureTaxeExpeditionPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    FactureTaxeExpeditionPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "factureTaxeExpedition";
    }

    @Override
    public String authority() {
        return value;
    }
}
