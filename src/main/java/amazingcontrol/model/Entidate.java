package amazingcontrol.model;

public class Entidate<PK> {
	
	private PK id; // Tipo generico.


	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	public boolean isNullId() {
		return id == null;
	}

	public boolean isNotNullId() {
		return !isNullId();
	}

}
