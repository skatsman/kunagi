package scrum.client.wiki;

public class EntityReference extends AWikiElement {

	private String reference;
	private String label;

	public EntityReference(String reference, String label) {
		super();
		this.reference = reference;
		this.label = label;
	}

	public EntityReference(String reference) {
		this(reference, reference);
	}

	@Override
	String toHtml(HtmlContext context) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a class='reference' onclick='window.scrum.showEntityByReference(\"");
		sb.append(reference);
		sb.append("\")");
		String entityLabel = context.getEntityLabelByReference(reference);
		if (entityLabel != null) {
			entityLabel = entityLabel.replace("'", "`");
			entityLabel = entityLabel.replace("\"", "`");
			sb.append("' title='");
			sb.append(entityLabel);
		}
		sb.append("'>");
		sb.append(escapeHtml(label));
		sb.append("</a>");
		return sb.toString();
	}

	public String getLabel() {
		return label;
	}

	public String getReference() {
		return reference;
	}

	@Override
	public String toString() {
		return "EntityReference(" + reference + "," + label + ")";
	}
}
