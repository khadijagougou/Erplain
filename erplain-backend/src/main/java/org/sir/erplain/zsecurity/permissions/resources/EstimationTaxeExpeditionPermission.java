package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum EstimationTaxeExpeditionPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EstimationTaxeExpeditionPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "estimationTaxeExpedition";
    }

    @Override
    public String authority() {
        return value;
    }
}
