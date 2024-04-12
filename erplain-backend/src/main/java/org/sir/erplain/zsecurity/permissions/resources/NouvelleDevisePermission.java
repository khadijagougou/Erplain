package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum NouvelleDevisePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    NouvelleDevisePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "nouvelleDevise";
    }

    @Override
    public String authority() {
        return value;
    }
}
