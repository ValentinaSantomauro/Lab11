package it.polito.tdp.model;

public class Tavolo {
	

	private int numeroPostiPerTavolo;
	
	
	
	public Tavolo( int numeroPostiPerTavolo) {
		super();
	
		this.numeroPostiPerTavolo = numeroPostiPerTavolo;
	}



	public int getNumeroPostiPerTavolo() {
		return numeroPostiPerTavolo;
	}



	public void setNumeroPostiPerTavolo(int numeroPostiPerTavolo) {
		this.numeroPostiPerTavolo = numeroPostiPerTavolo;
	}

	public boolean isDisponibile() {
		return true;
	}
}
