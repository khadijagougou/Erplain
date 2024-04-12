package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum CommandeTaxePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CommandeTaxePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "commandeTaxe";
    }

    @Override
    public String authority() {
        return value;
    }
}
