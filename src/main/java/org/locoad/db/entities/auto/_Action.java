package org.locoad.db.entities.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;
import org.locoad.db.entities.ActionPermission;

/**
 * Class _Action was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Action extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ACTION_ID_PK_COLUMN = "action_id";

    public static final Property<String> ACTION_NAME = Property.create("actionName", String.class);
    public static final Property<List<ActionPermission>> ACTION_PERMISSIONS = Property.create("actionPermissions", List.class);

    protected String actionName;

    protected Object actionPermissions;

    public void setActionName(String actionName) {
        beforePropertyWrite("actionName", this.actionName, actionName);
        this.actionName = actionName;
    }

    public String getActionName() {
        beforePropertyRead("actionName");
        return this.actionName;
    }

    public void addToActionPermissions(ActionPermission obj) {
        addToManyTarget("actionPermissions", obj, true);
    }

    public void removeFromActionPermissions(ActionPermission obj) {
        removeToManyTarget("actionPermissions", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<ActionPermission> getActionPermissions() {
        return (List<ActionPermission>)readProperty("actionPermissions");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "actionName":
                return this.actionName;
            case "actionPermissions":
                return this.actionPermissions;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "actionName":
                this.actionName = (String)val;
                break;
            case "actionPermissions":
                this.actionPermissions = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.actionName);
        out.writeObject(this.actionPermissions);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.actionName = (String)in.readObject();
        this.actionPermissions = in.readObject();
    }

}
