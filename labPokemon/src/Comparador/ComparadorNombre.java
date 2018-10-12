package Comparador;
import java.util.Comparator;

import modelo.Jugador;
import modelo.Pokemon;
public class ComparadorNombre implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return (int)o1.darNombre().compareTo(o2.darNombre());
	}

	

}
