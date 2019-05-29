package it.polito.tdp.model;

import java.time.LocalTime;

public class GruppoClienti {
	private int NUM_PERSONE; // numero random tra 1 e 10 --> da inizializzare
	private int durata; //da 60 a 120 min 
	private float tolleranza; //da 0.0 a 0.99
	private LocalTime oraArrivo;
	
	public GruppoClienti(int NUM_PERSONE, LocalTime oraArrivo, int durata, float tolleranza) {
		super();
		NUM_PERSONE = NUM_PERSONE;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.oraArrivo=oraArrivo;
	}
	public int getNUM_PERSONE() {
		return NUM_PERSONE;
	}
	public void setNUM_PERSONE(int NUM_PERSONE) {
		NUM_PERSONE = NUM_PERSONE;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	public LocalTime getOraArrivo() {
		return oraArrivo;
	}
	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	
}
