package application;

import java.util.Scanner;

public class probar {

	private static String nombre;
	public static void main (String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("escriba el nombre 1");
		String q1 = teclado.nextLine();
		nombre = q1;
		System.out.println("Ingrese el nombre 2: ");
		String q2 = teclado.nextLine();
		
		System.out.println(compararNombres(q2));
		
	}
	
	public static String darNOmbre() {
		return nombre;
	}
	public static int compararNombres(String n) {
		return nombre.compareTo(n);
	}
}
