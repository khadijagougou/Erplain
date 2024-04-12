package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum LivraisonTaxeExpeditionPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    LivraisonTaxeExpeditionPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "livraisonTaxeExpedition";
    }

    @Override
    public String authority() {
        return value;
    }
}
