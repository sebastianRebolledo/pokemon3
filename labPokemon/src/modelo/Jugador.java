package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable,Comparable{

	private String nombre;
	private int puntaje;
	

	public Jugador(String nombre, int puntaje) {
		this.nombre=nombre;
		this.puntaje=puntaje;
		
	}
	

	
	public String darNombre() {
		return nombre;
	}
	
	public int darPuntaje() {
		return puntaje;
	}
	
	public void cambiarNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void cambiarPuntaje(int puntaje) {
		this.puntaje=puntaje;
	}
	
	
	public int compareTo(Jugador j) {
	if(this.darNombre().equalsIgnoreCase(j.nombre)) {
		return 0;
	}else if(this.darNombre().compareTo(j.darNombre()) > 0) {
		return 1;
	}else{
		return -1;
	}
	}
	
	

	public int compareToNombre(Object arg0) {
		return compareToNombre(arg0);
		
	}
	
	public int compareToPuntaje(int pPuntaje) {
//		  if (puntaje < pPuntaje) {
//                return -1;
//            }
//            if (puntaje > pPuntaje) {
//                return 1;
//            }
//            return 0;
		return compareTo(pPuntaje);
        }
	
	
	
	
public int compareToPuntos(Jugador j) {
	
	if(puntaje==j.darPuntaje()) {
		return 0;
	}else if(puntaje>j.darPuntaje()) {
		return 1;
	}else {
		return -1;
	}
	
}



@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}




	
	

	
	
	
}
