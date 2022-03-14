package uga.groupe7.bd.model;

public enum Model {
	Manuelle(2.00),
	Electrique(3.00);
	
	private double cout;

	private Model(double coutHoraire) {
		this.cout = coutHoraire;
	}
	
	public Double getCout() {
		return this.cout;
	}
}
