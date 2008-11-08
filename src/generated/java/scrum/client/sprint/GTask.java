









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: scrum.mda.GwtBeanGenerator










package scrum.client.sprint;

import java.util.*;

public abstract class GTask
            extends scrum.client.common.AEntity {

    public GTask() {}

    public GTask(Map data) {
        super(data);
        updateProperties(data);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Task setLabel(java.lang.String label) {
        this.label = label ;
        propertyChanged("label", label);
        return (Task)this;
    }

    // --- backlogItem ---

    private String backlogItemId;

    // --- effort ---

    private java.lang.Integer effort ;

    public final java.lang.Integer getEffort() {
        return this.effort ;
    }

    public final Task setEffort(java.lang.Integer effort) {
        this.effort = effort ;
        propertyChanged("effort", toString(effort));
        return (Task)this;
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        label  = (java.lang.String) props.get("label");
        backlogItemId = (String) props.get("id");
        effort  = (java.lang.Integer) props.get("effort");
    }

}