package pruebas;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Entrenamiento;
import modelo.Jugador;

class TestEntrenamiento {
	
	private Entrenamiento entrenamiento;
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	public void scenario1() {
		entrenamiento=new Entrenamiento();
	}

	
	
	
	
	
	@Test
	public void TestOrdenarPorPuntos() {
		scenario1();
			


	Jugador jugadorsito1=new Jugador("Carmen",4);
	Jugador jugadorsito4=new Jugador("Jose" , 12);
	Jugador jugadorsito2= new Jugador("Marcela",14);
	Jugador jugadorsito6= new Jugador("Andrea",22);
	Jugador jugadorsito3= new Jugador("Julian",23);
	Jugador jugador11= new Jugador("Reykon",27);
	Jugador jugador10= new Jugador(" JBalvin",30);
	Jugador jugadorsito5=new Jugador("Armando", 32);
	Jugador jugadorsito7= new Jugador("Juana",34);
	Jugador jugador8= new Jugador("Shakira",45);
	Jugador jugador13= new Jugador("Maluma",47);
	Jugador jugador12= new Jugador("Rakim",49);
	Jugador jugador9= new Jugador("Pipe bueno",50);
	Jugador jugador14= new Jugador("Bruno Mars",70);
	
	
	
	ArrayList<Jugador> jugadoresSinOrdenar2= new ArrayList<Jugador>();
	jugadoresSinOrdenar2.add(jugadorsito6);
	jugadoresSinOrdenar2.add(jugadorsito7);
	jugadoresSinOrdenar2.add(jugadorsito4);
	jugadoresSinOrdenar2.add(jugadorsito5);
	jugadoresSinOrdenar2.add(jugadorsito2);
	jugadoresSinOrdenar2.add(jugadorsito3);
	jugadoresSinOrdenar2.add(jugadorsito1);
	
	jugadoresSinOrdenar2.add(jugador8);
	jugadoresSinOrdenar2.add(jugador9);
	jugadoresSinOrdenar2.add(jugador10);
	jugadoresSinOrdenar2.add(jugador11);
	jugadoresSinOrdenar2.add(jugador12);
	jugadoresSinOrdenar2.add(jugador13);
	jugadoresSinOrdenar2.add(jugador14);
	
	
	
	ArrayList<Jugador> jugadoresOrdenados=new ArrayList<Jugador>();
	jugadoresOrdenados.add(0,jugadorsito1);
	jugadoresOrdenados.add(1,jugadorsito4);
	jugadoresOrdenados.add(2,jugadorsito2);
	jugadoresOrdenados.add(3,jugadorsito6);
	jugadoresOrdenados.add(4,jugadorsito3);
	jugadoresOrdenados.add(5,jugador11);
	jugadoresOrdenados.add(6,jugador10);
	jugadoresOrdenados.add(7,jugadorsito5);
	jugadoresOrdenados.add(8,jugadorsito7);
	jugadoresOrdenados.add(9,jugador8);
	jugadoresOrdenados.add(10,jugador13);
	jugadoresOrdenados.add(11,jugador12);
	jugadoresOrdenados.add(12,jugador9);
	jugadoresOrdenados.add(13,jugador14);
	
		ArrayList<Jugador >jugadoresActuales= entrenamiento.ordenarPorPuntaje(jugadoresSinOrdenar2);
		assertEquals(jugadoresOrdenados, jugadoresActuales);


	}
	
	
	@Test
	public void TestOrdenarPorPuntosConArreglo() {
		scenario1();
		Jugador[] jugadoresSinOrdenarArreglo= new Jugador[14];
		Jugador jugadorsito1=new Jugador("Carmen",4);
		Jugador jugadorsito4=new Jugador("Jose" , 12);
		Jugador jugadorsito2= new Jugador("Marcela",14);
		Jugador jugadorsito6= new Jugador("Andrea",22);
		Jugador jugadorsito3= new Jugador("Julian",23);
		Jugador jugador11= new Jugador("Reykon",27);
		Jugador jugador10= new Jugador(" JBalvin",30);
		Jugador jugadorsito5=new Jugador("Armando", 32);
		Jugador jugadorsito7= new Jugador("Juana",34);
		Jugador jugador8= new Jugador("Shakira",45);
		Jugador jugador13= new Jugador("Maluma",47);
		Jugador jugador12= new Jugador("Rakim",49);
		Jugador jugador9= new Jugador("Pipe bueno",50);
		Jugador jugador14= new Jugador("Bruno Mars",70);
		
		jugadoresSinOrdenarArreglo[0]=jugador14;
		jugadoresSinOrdenarArreglo[1]=jugador12;
		jugadoresSinOrdenarArreglo[2]=jugador11;
		jugadoresSinOrdenarArreglo[3]=jugadorsito1;
		jugadoresSinOrdenarArreglo[4]=jugadorsito7;
		jugadoresSinOrdenarArreglo[5]=jugador9;
		jugadoresSinOrdenarArreglo[6]=jugador10;
		jugadoresSinOrdenarArreglo[7]=jugadorsito6;
		jugadoresSinOrdenarArreglo[8]=jugadorsito4;
		jugadoresSinOrdenarArreglo[9]=jugadorsito5;
		jugadoresSinOrdenarArreglo[10]=jugador8;
		jugadoresSinOrdenarArreglo[11]=jugador13;
		jugadoresSinOrdenarArreglo[12]=jugadorsito3;
		jugadoresSinOrdenarArreglo[13]=jugadorsito2;
		
		Jugador[] jugadoresOrdenados= new Jugador[14];

		
		jugadoresOrdenados[0]=jugadorsito1;
		jugadoresOrdenados[1]=jugadorsito4;
		jugadoresOrdenados[2]=jugadorsito2;
		jugadoresOrdenados[3]=jugadorsito6;
		jugadoresOrdenados[4]=jugadorsito3;
		jugadoresOrdenados[5]=jugador11;
		jugadoresOrdenados[6]=jugador10;
		jugadoresOrdenados[7]=jugadorsito5;
		jugadoresOrdenados[8]=jugadorsito7;
		jugadoresOrdenados[9]=jugador8;
		jugadoresOrdenados[10]=jugador13;
		jugadoresOrdenados[11]=jugador12;
		jugadoresOrdenados[12]=jugador9;
		jugadoresOrdenados[13]= jugador14;
		
		
		
		Jugador[] jugadoresActualesOrdenados=entrenamiento.ordenamientoInserccionPuntos(jugadoresSinOrdenarArreglo);
	
	assertArrayEquals( jugadoresActualesOrdenados,jugadoresOrdenados);	
		
		
	}
	
	
	
	
	
	@Test
	public void TestOrdenarPorNombre() {
		
		scenario1();
		
		Jugador jugadorsito6= new Jugador("Andrea",22);
		Jugador jugadorsito5=new Jugador("Bernardo", 32);
		Jugador jugadorsito1=new Jugador("Carmen",4);
		Jugador jugadorsito2= new Jugador("Danna",14);
		Jugador jugadorsito3= new Jugador("Esteban",23);
		Jugador jugadorsito4=new Jugador("Fonseca" , 12);
		Jugador jugadorsito14= new Jugador("Gordo",26);
		Jugador jugadorsito13= new Jugador("Helena",89);
		Jugador jugadorsito12= new Jugador("Inna",48);
		Jugador jugadorsito11= new Jugador("Juana",43);
		Jugador jugadorsito10= new Jugador("Kinna",36);
		Jugador jugadorsito9= new Jugador("Liliana",76);
		Jugador jugadorsito8= new Jugador("Montesr",56);
		Jugador jugadorsito7= new Jugador("Zila",34);
		
		
		ArrayList<Jugador> jugadoresSinOrdenar2= new ArrayList<Jugador>();
		jugadoresSinOrdenar2.add(jugadorsito11);
		jugadoresSinOrdenar2.add(jugadorsito6);
		jugadoresSinOrdenar2.add(jugadorsito4);
		jugadoresSinOrdenar2.add(jugadorsito1);
		jugadoresSinOrdenar2.add(jugadorsito5);
		jugadoresSinOrdenar2.add(jugadorsito12);
		jugadoresSinOrdenar2.add(jugadorsito2);
		jugadoresSinOrdenar2.add(jugadorsito9);
		jugadoresSinOrdenar2.add(jugadorsito8);
		jugadoresSinOrdenar2.add(jugadorsito10);
		jugadoresSinOrdenar2.add(jugadorsito13);
		jugadoresSinOrdenar2.add(jugadorsito7);
		jugadoresSinOrdenar2.add(jugadorsito14);
		jugadoresSinOrdenar2.add(jugadorsito3);
	
		
		
		
		
		
		ArrayList<Jugador> jugadoresOrdenados=new ArrayList<Jugador>();
		jugadoresOrdenados.add(0,jugadorsito6);
		jugadoresOrdenados.add(1,jugadorsito5);
		jugadoresOrdenados.add(2,jugadorsito1);
		jugadoresOrdenados.add(3,jugadorsito2);
		jugadoresOrdenados.add(4,jugadorsito3);
		jugadoresOrdenados.add(5,jugadorsito4);
		jugadoresOrdenados.add(6,jugadorsito14);
		jugadoresOrdenados.add(7,jugadorsito13);
		jugadoresOrdenados.add(8,jugadorsito12);
		jugadoresOrdenados.add(9,jugadorsito11);
		jugadoresOrdenados.add(10,jugadorsito10);
		jugadoresOrdenados.add(11,jugadorsito9);
		jugadoresOrdenados.add(12,jugadorsito8);
		jugadoresOrdenados.add(13,jugadorsito7);
		
		
		ArrayList<Jugador >jugadoresActuales= entrenamiento.ordenarPorNombre(jugadoresSinOrdenar2);
		assertEquals(jugadoresOrdenados, jugadoresActuales);
		
		
	}
	
	
	
	
	@Test
	public void TestOrdenarPorNombreArreglo() {
		scenario1();
		
		Jugador[] jugadoresSinOrdenarArreglo= new Jugador[14];
		Jugador jugadorsito1=new Jugador("Andrea",4);
		Jugador jugadorsito4=new Jugador("Bruno" , 12);
		Jugador jugadorsito2= new Jugador("Carla",14);
		Jugador jugadorsito6= new Jugador("Diana",22);
		Jugador jugadorsito3= new Jugador("Erenesto",23);
		Jugador jugador11= new Jugador("Flora",27);
		Jugador jugador10= new Jugador("Hitler",30);
		Jugador jugadorsito5=new Jugador("Ignacio", 32);
		Jugador jugadorsito7= new Jugador("Juana",34);
		Jugador jugador8= new Jugador("Kilirin",45);
		Jugador jugador13= new Jugador("Liliana",47);
		Jugador jugador12= new Jugador("Man",49);
		Jugador jugador9= new Jugador("Nani",50);
		Jugador jugador14= new Jugador("Osfor",70);
		
		jugadoresSinOrdenarArreglo[0]=jugador14;
		jugadoresSinOrdenarArreglo[1]=jugador12;
		jugadoresSinOrdenarArreglo[2]=jugador11;
		jugadoresSinOrdenarArreglo[3]=jugadorsito1;
		jugadoresSinOrdenarArreglo[4]=jugadorsito7;
		jugadoresSinOrdenarArreglo[5]=jugador9;
		jugadoresSinOrdenarArreglo[6]=jugador10;
		jugadoresSinOrdenarArreglo[7]=jugadorsito6;
		jugadoresSinOrdenarArreglo[8]=jugadorsito4;
		jugadoresSinOrdenarArreglo[9]=jugadorsito5;
		jugadoresSinOrdenarArreglo[10]=jugador8;
		jugadoresSinOrdenarArreglo[11]=jugador13;
		jugadoresSinOrdenarArreglo[12]=jugadorsito3;
		jugadoresSinOrdenarArreglo[13]=jugadorsito2;
		
		
		
Jugador[] jugadoresOrdenados= new Jugador[14];

		
		jugadoresOrdenados[0]=jugadorsito1;
		jugadoresOrdenados[1]=jugadorsito4;
		jugadoresOrdenados[2]=jugadorsito2;
		jugadoresOrdenados[3]=jugadorsito6;
		jugadoresOrdenados[4]=jugadorsito3;
		jugadoresOrdenados[5]=jugador11;
		jugadoresOrdenados[6]=jugador10;
		jugadoresOrdenados[7]=jugadorsito5;
		jugadoresOrdenados[8]=jugadorsito7;
		jugadoresOrdenados[9]=jugador8;
		jugadoresOrdenados[10]=jugador13;
		jugadoresOrdenados[11]=jugador12;
		jugadoresOrdenados[12]=jugador9;
		jugadoresOrdenados[13]= jugador14;
		
		
		Jugador[] jugadoresActualesOrdenados=entrenamiento.ordenamientoInserccionNombre(jugadoresSinOrdenarArreglo);
		
		assertArrayEquals( jugadoresActualesOrdenados,jugadoresOrdenados);
		
	}
	
	
	
	
	
	
	
//	@Test
//	public void TestOrdearPorPuntajeArreglo() {
//		scenario1();
//		ArrayList<Jugador> jugadores= entrenamiento.darJugadores();
//		Jugador[] jugadoresShort= new Jugador[jugadores.size()];
//		for(int i=0;i<jugadores.size();i++) {
//			jugadoresShort[i]=jugadores.get(i);
//		}
//		
//		Jugador[] jugadoresActuales=entrenamiento.jugadoresInsercionDirecta(jugadores);
//		
//	}
//	
//	@Test
//	public void TestOrdenarPorNombre() {
//		scenario1();
//		
//		
//		ArrayList<Jugador> jugadores= entrenamiento.darJugadores();
//		
//		ArrayList<Jugador> jugadoresActuales=entrenamiento.ordenarPorNombre(jugadores);
//		
//
//	}
	
	
	
	
	
}
