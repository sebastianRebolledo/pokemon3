package Comparador;

import java.util.Comparator;

import modelo.Pokemon;

public class ComparadorNombrePokemon implements Comparator<Pokemon>{

	@Override
	public int compare(Pokemon p1, Pokemon p2) {
		// TODO Auto-generated method stub
		return (int)p1.darNombre().compareTo(p2.darNombre());
	}

}
