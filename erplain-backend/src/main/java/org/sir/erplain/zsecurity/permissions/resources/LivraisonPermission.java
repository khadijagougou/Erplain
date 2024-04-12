package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum LivraisonPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    LivraisonPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "livraison";
    }

    @Override
    public String authority() {
        return value;
    }
}
