package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum EstimationProduitPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EstimationProduitPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "estimationProduit";
    }

    @Override
    public String authority() {
        return value;
    }
}
