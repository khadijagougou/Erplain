package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum CommandePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CommandePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "commande";
    }

    @Override
    public String authority() {
        return value;
    }
}
