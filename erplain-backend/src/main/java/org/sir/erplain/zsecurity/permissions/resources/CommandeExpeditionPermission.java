package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum CommandeExpeditionPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CommandeExpeditionPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "commandeExpedition";
    }

    @Override
    public String authority() {
        return value;
    }
}
