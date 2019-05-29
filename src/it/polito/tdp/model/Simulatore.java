package it.polito.tdp.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simulatore {
	
	//modello del mondo
	List<GruppoClienti> clienti;
	List<Tavolo> tavoli;
	
	//parametri di simulazione

	private int  NUM_TAVOLI_DA_10 = 2;
	private int NUM_TAVOLI_DA_8 = 4;
	private int NUM_TAVOLI_DA_6 = 4;
	private int NUM_TAVOLI_DA_4=5;
	private int NUM_POSTI_MAX_PER_TAVOLO=10;
	
	
	private int NUM_EVENTI_ARRIVO_CLIENTI = 2000;
	private LocalTime T_inizio = LocalTime.of(8, 0);
	private LocalTime T_fine = LocalTime.of(20, 0);
	Random rand = new Random();
	
	//output
	private Statistiche statistiche;
	
	//coda
	PriorityQueue <Evento> queue;
	
	public void init() {
		LocalTime oraArrivo = T_inizio;
		clienti.clear();
		tavoli.clear();
		
		for(int i =0; i<NUM_EVENTI_ARRIVO_CLIENTI;  i++) {
		//crea un num random tra 1 e 10 --> lo setti come numdiperson del gruppo 
			
			//CREO I NUMERI RANDOM
			int numPersoneGruppo= rand.nextInt(9)+1;
			float tolleranzaGruppo = rand.nextFloat(); //ritorna già un valore compreso tra 0.0 e 1.0 senza che lo specifichi
			int durataPermanenzaBar = rand.nextInt(60)+60;
			int arrivoSuccessivo= rand.nextInt(10);
			
			//la durata va da 60 a 120 min --> setto i num random in questo intervallo
			
				//per il primo cliente l'ora di arrivo sono le 8
				//assegno la tolleranza con un num random tra 0.0 e 0.9
				//aggiungo il cliente alla lista
				GruppoClienti gc = new GruppoClienti(numPersoneGruppo, oraArrivo,durataPermanenzaBar, tolleranzaGruppo); 
				
				//aggiungi un tot di minuti all'ora arrivo del cliente successivo che è un num random tra 1 e 10
				if(arrivoSuccessivo!=0) {
					 Duration arrivi = Duration.ofMinutes(arrivoSuccessivo); // intervallo di tempo tra i pazienti
					 oraArrivo= oraArrivo.plus(arrivi);
				
			}
			
		}
			
		queue= new PriorityQueue<Evento>();
		
		//imposto tutte le statistiche a 0
		statistiche = new Statistiche (0,0,0);
		
		//creare eventi iniziali
		queue.clear();
		for(GruppoClienti g : clienti ) {
			queue.add(new Evento(g.getOraArrivo(),TipoEvento.ARRIVO_GRUPPO_CLIENTI,g));
		}
	
	}
	
	public void run() {
		//while-->switch
		
		while(!queue.isEmpty()) {
			Evento ev = queue.poll();
			
			GruppoClienti gc = ev.getGc();
			
			switch(ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				//posso assegnarlo a un tavolo ? SI--> rispetta vincoli di assegnazione
				//NO --> può aspettare al bar
				
				for(Tavolo t : tavoli) {
					//voglio il tavolo più piccolo, cioè in modo che restino meno posti liberi rispetto al numero di clienti
					int min = NUM_POSTI_MAX_PER_TAVOLO;
					if(t.isDisponibile() && t.getNumeroPostiPerTavolo() >= ev.getGc().getNUM_PERSONE()) {
						min= t.getNumeroPostiPerTavolo() - ev.getGc().getNUM_PERSONE();
						
						if(min <= t.getNumeroPostiPerTavolo()/2) {
							//se occupo almeno il 50% del tavolo posso restare --> dopo durata imposto l'evento d'uscita con quel tempo
							
						}else {
							//altrimenti devo andare al bar --> chiamo l'evento bancone
						}
					}
				}
				break;
			case USCITA_GRUPPO_CLIENTI:
				//se la toll è 0.0 insoddisfatti
				//se erano al tavolo o hanno toll 0.9 soddisfatti
				break;
				
			case VAI_AL_BANCONE:
				
				//valuto la tolleranza
				
				//0.0 chiamo l'evento uscita 
				
				//altrimenti sono soddisfatti
				
				break;
			}
		}
	}
}
