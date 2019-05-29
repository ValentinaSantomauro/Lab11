package it.polito.tdp.model;

import java.time.LocalTime;

public class Evento implements Comparable <Evento> {

	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI,
		USCITA_GRUPPO_CLIENTI,
		VAI_AL_BANCONE
		
	}
	
	private LocalTime time; //tempo discreto --> ogni 10 min arriva un cliente
	private TipoEvento tipo;
	GruppoClienti gc;
	
	
	

	public Evento(LocalTime time, TipoEvento tipo,GruppoClienti gc) {
		super();
		this.time = time;
		this.tipo = tipo;
		this.gc=gc;
	}



	public void setTime(LocalTime time) {
		this.time = time;
	}



	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}



	


	public LocalTime getTime() {
		return time;
	}



	public TipoEvento getTipo() {
		return tipo;
	}



	



	public GruppoClienti getGc() {
		return gc;
	}



	public void setGc(GruppoClienti gc) {
		this.gc = gc;
	}



	@Override
	public int compareTo(Evento e) {
		// TODO Auto-generated method stub
		return this.time.compareTo(e.time);
	}
	

}
