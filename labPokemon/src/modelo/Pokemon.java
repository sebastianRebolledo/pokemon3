package modelo;

public class Pokemon {

private String nombre;
private String imagen;
private double radio;
private double posX;
private boolean esAtrapado;

	public Pokemon(String nombre,double posX, double radio,boolean esAtrapado,String imagen) {
		this.posX=posX;
		this.radio=radio;
		this.esAtrapado=esAtrapado;
		this.nombre=nombre;
		this.imagen=imagen;
	}
	
	
	public String darNombre() {
		return nombre;
	}
	
	
	public double darPosX() {
		return posX;
	}
	
	public boolean esAtrapado() {
		return esAtrapado;
	}
	public void cambiarAtrapado(boolean esAtrapado) {
		this.esAtrapado=esAtrapado;
	}
	
	
	public String darImagen() {
		return imagen;
	}
	
	public void cambiarImagen(String imagen) {
		this.imagen=imagen;
	}
	
	public double darRadio() {
		return radio;
	}
	public void cambiarRadio(double radio) {
		this.radio+=radio;
	}
	public void cambiarPosX(double posX) {
		this.posX=posX;
	}
	
	

}
