package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum BonCommandeTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    BonCommandeTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "bonCommandeTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
