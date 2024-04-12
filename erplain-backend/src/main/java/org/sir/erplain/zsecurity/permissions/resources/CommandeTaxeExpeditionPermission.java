package org.sir.erplain.zsecurity.permissions.resources;
import org.sir.erplain.zsecurity.permissions.PermissionResource;

public enum CommandeTaxeExpeditionPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CommandeTaxeExpeditionPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "commandeTaxeExpedition";
    }

    @Override
    public String authority() {
        return value;
    }
}
