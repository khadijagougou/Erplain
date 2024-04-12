package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum EstimationTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EstimationTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "estimationTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
