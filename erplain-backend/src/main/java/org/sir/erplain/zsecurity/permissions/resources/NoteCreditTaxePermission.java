package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum NoteCreditTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    NoteCreditTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "noteCreditTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
