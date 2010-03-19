package scrum.client.common;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.undo.AUndoOperation;
import scrum.client.ComponentManager;
import scrum.client.Dao;
import scrum.client.ScrumGwtApplication;
import scrum.client.ScrumScopeManager;
import scrum.client.admin.Auth;
import scrum.client.admin.User;
import scrum.client.project.Project;
import scrum.client.sprint.Sprint;
import scrum.client.undo.Undo;
import scrum.client.workspace.Ui;

public abstract class AScrumAction extends AAction {

	protected static final ComponentManager cm = ComponentManager.get();

	public AScrumAction() {
		super(Scope.get().getComponent(Ui.class).getWorkspace());
	}

	// --- helper ---

	protected static final void addUndo(AUndoOperation undo) {
		Scope.get().getComponent(Undo.class).getManager().add(undo);
	}

	protected static final boolean isCurrentSprint(Sprint sprint) {
		return getCurrentProject().isCurrentSprint(sprint);
	}

	protected static final User getCurrentUser() {
		assert getAuth().isUserLoggedIn();
		return getAuth().getUser();
	}

	protected static final Auth getAuth() {
		return Scope.get().getComponent(Auth.class);
	}

	protected static final Dao getDao() {
		return Dao.get();
	}

	protected static final Project getCurrentProject() {
		assert ScrumScopeManager.isProjectScope();
		return ScrumScopeManager.getProject();
	}

	protected static final ScrumGwtApplication getApp() {
		return (ScrumGwtApplication) Scope.get().getComponent("app");
	}

	protected abstract class ALocalUndo extends AUndoOperation {

		@Override
		public String getLabel() {
			return "Undo " + AScrumAction.this.getLabel();
		}

	}

}
