package modelo;

import java.util.ArrayList;

import Comparador.ComparadorNombre;



public class Entrenamiento {

	
	private ArrayList<Jugador> jugadores;
	
	private ArrayList<Pokemon> pokemones;
	
	public Entrenamiento() {
		jugadores= new ArrayList<Jugador>();
		pokemones=new ArrayList<Pokemon>();
//		addNewPlayers();
	}
	
	
	public void cambiarJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores=jugadores;
	}
	
	
	public ArrayList<Jugador> darJugadores(){
		return jugadores;
	}
	
	public ArrayList<Pokemon> darPokemones(){
		return pokemones;
	}
	
	public void cambiarPokemones(ArrayList<Pokemon> pokemones) {
		this.pokemones=pokemones;
	}
	
	public void addNewPlayers() {
		
		Jugador jugadorsito1=new Jugador("Carmen",4);
		Jugador jugadorsito2= new Jugador("Marcela",14);
		Jugador jugadorsito3= new Jugador("Julian",23);
		Jugador jugadorsito4=new Jugador("Jose" , 12);
		Jugador jugadorsito5=new Jugador("Armando", 32);
		Jugador jugadorsito6= new Jugador("Andrea",22);
		Jugador jugadorsito7= new Jugador("Juana",34);
		jugadores.add(jugadorsito7);
		jugadores.add(jugadorsito6);
		jugadores.add(jugadorsito5);
		jugadores.add(jugadorsito4);
		jugadores.add(jugadorsito3);
		jugadores.add(jugadorsito2);
		jugadores.add(jugadorsito1);
	}
	
	
	
	
	public void ordenarPorPuntaje() {
		
		
		for(int i=0;i<jugadores.size();i++) {
			Jugador porInserta=(Jugador)jugadores.get(i);
			boolean termino=false;
			
			for(int j=i;j>0&&!termino;j--) {
				Jugador actual=(Jugador)jugadores.get(j-1);
				if(actual.compareToPuntos(porInserta)>0) {
					jugadores.set(j, actual);
					jugadores.set(j-1, porInserta);
					
					
				}else {
					termino=true;
				}
			}
		
		}
		
		
	}
	
	
	
	public ArrayList<Jugador> ordenarPorPuntaje(ArrayList<Jugador> jugadores) {

		for(int i=0;i<jugadores.size();i++) {
			Jugador porInserta=(Jugador)jugadores.get(i);
			boolean termino=false;
			
			for(int j=i;j>0&&!termino;j--) {
				Jugador actual=(Jugador)jugadores.get(j-1);
				if(actual.compareToPuntos(porInserta)>0) {
					jugadores.set(j, actual);
					jugadores.set(j-1, porInserta);
					
					
				}else {
					termino=true;
				}
			}
		
		}
		for (int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).darNombre()+ ""+jugadores.get(i)+ "\n" );
		}
		
		return jugadores;
	}
	
	
	
	
	
public void ordenarPorNombre1(ArrayList<Jugador> jugadores) {
	
	for(int i=0;i<jugadores.size();i++) {
		Jugador porInserta=(Jugador)jugadores.get(i);
		boolean termino=false;
		
		for(int j=i;j>0&&!termino;j--) {
			Jugador actual=(Jugador)jugadores.get(j-1);
			ComparadorNombre comNom= new ComparadorNombre();		
			if(comNom.compare(actual,porInserta)>0) {
				jugadores.set(j, actual);
				jugadores.set(j-1, porInserta);
				
				
			}else {
				termino=true;
			}
		}
	}
	
	
	
	
	
}



public ArrayList<Jugador> ordenarPorNombre(ArrayList<Jugador> jugadores) {
	
	for(int i=0;i<jugadores.size();i++) {
		Jugador porInserta=(Jugador)jugadores.get(i);
		boolean termino=false;
		
		for(int j=i;j>0&&!termino;j--) {
			Jugador actual=(Jugador)jugadores.get(j-1);
			ComparadorNombre comNom= new ComparadorNombre();		
			if(comNom.compare(actual,porInserta)>0) {
				jugadores.set(j, actual);
				jugadores.set(j-1, porInserta);
				
				
			}else {
				termino=true;
			}
		}
	}	
	return jugadores;
}




public void cambiarPuntajeAJugadorNuevo(Jugador jugador,int puntaje) {
	
	for(int i=0;i<jugadores.size();i++) {
		ComparadorNombre comNom= new ComparadorNombre();
		if(comNom.compare(jugador, jugadores.get(i))==0) {
			jugadores.get(i).cambiarPuntaje(puntaje);
		}
	}
	
}





//INSERCCION
	public Jugador[] ordenarPorPuntosInserccion(ArrayList<Jugador> jugadores){
		Jugador[] jugadoresResultado= new Jugador[jugadores.size()];
		
		for(int i=0;i<jugadores.size();i++) {
			jugadoresResultado[i]=jugadores.get(i);
		}
		
		
	    int p, j;
	    Jugador aux;
	    for (p = 1; p < jugadoresResultado.length; p++){ // desde el segundo elemento hasta
	              aux = jugadoresResultado[p]; // el final, guardamos el elemento y
	              j = p - 1; // empezamos a comprobar con el anterior
	              while ((j >= 0) && (aux.compareTo(jugadoresResultado[j])<0)){ // mientras queden posiciones y el
	                                                                    // valor de aux sea menor que los
	                             jugadoresResultado[j + 1] = jugadoresResultado[j];       // de la izquierda, se desplaza a
	                             j--;                   // la derecha
	              }
	              jugadoresResultado[j + 1] = aux; // colocamos aux en su sitio
	    }
	    return jugadoresResultado;
	}


	
	
	//INSERCCION
		public Jugador[] ordenarPorPuntosInserccionArreglo(Jugador[] jugadores){
			Jugador[] jugadoresResultado= new Jugador[jugadores.length];
			
			for(int i=0;i<jugadores.length;i++) {
				jugadoresResultado[i]=jugadores[i];
			}
			
			
		    int p, j;
		    Jugador aux;
		    for (p = 1; p < jugadoresResultado.length; p++){ // desde el segundo elemento hasta
		              aux = jugadoresResultado[p]; // el final, guardamos el elemento y
		              j = p - 1; // empezamos a comprobar con el anterior
		              while ((j >= 0) && (aux.compareTo(jugadoresResultado[j])<0)){ // mientras queden posiciones y el
		                                                                    // valor de aux sea menor que los
		                             jugadoresResultado[j + 1] = jugadoresResultado[j];       // de la izquierda, se desplaza a
		                             j--;                   // la derecha
		              }
		              jugadoresResultado[j + 1] = aux; // colocamos aux en su sitio
		    }
		    return jugadoresResultado;
		}
	
	
	
	
	
	
	
	
	
	public Jugador[] ordenarPorNombreInserccion(ArrayList<Jugador> jugadores) {
		
		
		Jugador[] jugadoresResultado= new Jugador[jugadores.size()];
		
		for(int i=0;i<jugadores.size();i++) {
			jugadoresResultado[i]=jugadores.get(i);
		}
		
		
	    int p, j;
	    Jugador aux;
	    for (p = 1; p < jugadoresResultado.length; p++){ // desde el segundo elemento hasta
	              aux = jugadoresResultado[p]; // el final, guardamos el elemento y
	              j = p - 1; // empezamos a comprobar con el anterior
	              ComparadorNombre comNom= new ComparadorNombre();
	              while ((j >= 0) && (comNom.compare(aux, jugadoresResultado[j])<0)){ // mientras queden posiciones y el
	                                                                    // valor de aux sea menor que los
	                             jugadoresResultado[j + 1] = jugadoresResultado[j];       // de la izquierda, se desplaza a
	                             j--;                   // la derecha
	              }
	              jugadoresResultado[j + 1] = aux; // colocamos aux en su sitio
	    }
	    return jugadoresResultado;
		
	}
	
	
	
	
	
	
	
	
	//INSERCCION
		public Jugador[] ordenamientoInserccionPuntos( Jugador[] jugadores){
		    int p, j;
		    Jugador aux;
		    for (p = 1; p < jugadores.length; p++){ // desde el segundo elemento hasta
		              aux = jugadores[p]; // el final, guardamos el elemento y
		              j = p - 1; // empezamos a comprobar con el anterior
		              while ((j >= 0) && (aux.compareToPuntos(jugadores[j])<0)){ // mientras queden posiciones y el
		                                                                    // valor de aux sea menor que los
		                             jugadores[j + 1] = jugadores[j];       // de la izquierda, se desplaza a
		                             j--;                   // la derecha
		              }
		              jugadores[j + 1] = aux; // colocamos aux en su sitio
		    }
		    return jugadores;
		}
		
	
		
		
		//INSERCCION
				public Jugador[] ordenamientoInserccionNombre( Jugador[] jugadores){
				    int p, j;
				    Jugador aux;
				    for (p = 1; p < jugadores.length; p++){ // desde el segundo elemento hasta
				              aux = jugadores[p]; // el final, guardamos el elemento y
				              j = p - 1; // empezamos a comprobar con el anterior
				              ComparadorNombre conM=new ComparadorNombre();
				              while ((j >= 0) && (conM.compare(aux, jugadores[j])<0)){ // mientras queden posiciones y el
				                                                                    // valor de aux sea menor que los
				                             jugadores[j + 1] = jugadores[j];       // de la izquierda, se desplaza a
				                             j--;                   // la derecha
				              }
				              jugadores[j + 1] = aux; // colocamos aux en su sitio
				    }
				    return jugadores;
				}
	
	
	
	
	
	
	
}
