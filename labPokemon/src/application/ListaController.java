package application;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import modelo.Jugador;
import modelo.Pokemon;

public class ListaController {

	@FXML
	private ListView listaNombre;
	
	@FXML
	private ListView listaPuntos;
	private static Main main= new Main();
	
	@FXML
	private ObservableList<String> dataListaNombre= FXCollections.observableArrayList();
	
	

	@FXML
	private ObservableList<String> dataListaPuntos = FXCollections.observableArrayList();
	
	@FXML
	private Button btnBuscarJugador;
	@FXML
	private Button buscarPokemon;
	
	public ListaController() {
	listaNombre=new ListView();
	listaPuntos=new ListView();
	
	
	}
	
	
	public void initialize() {
		
	}
	


	
	
	
	
	public void toShowForPoints() {
		main.darAtrapar().leerJugadoresSerializadosDeTxt();


		ArrayList<Jugador> jugadores=main.darEntrenamiento().ordenarPorPuntaje(main.darEntrenamiento().darJugadores());
		for(int i=jugadores.size()-1;i>=0;i--) {
			System.out.println("Entro a puntaje");
			dataListaPuntos.add(jugadores.get(i).darNombre()+ " " +"P:" + jugadores.get(i).darPuntaje());	
		}


		
		listaPuntos.setItems(dataListaPuntos);
		
		
	}
	
	
	
	public void toShowListForName() {
		main.darAtrapar().leerJugadoresSerializadosDeTxt();

	main.darEntrenamiento().ordenarPorNombre(main.darEntrenamiento().darJugadores());	
		for(int i=0;i<main.darEntrenamiento().darJugadores().size();i++) {
			System.out.println("Entro");
			dataListaNombre.add(main.darEntrenamiento().darJugadores().get(i).darNombre());	
		}

		
		listaNombre.setItems(dataListaNombre);
		
		
	}
	
	
	
	public void busquedaJugador() {

		 String nombreJugador="";
		
		 
		 TextInputDialog dialog = new TextInputDialog("name");
		 dialog.setTitle("Text Input Dialog");
		 dialog.setHeaderText("Look, a Text Input Dialog");
		 dialog.setContentText("Please enter name of player:");
		 
		// Traditional way to get the response value.
		
		 Optional<String> result = dialog.showAndWait();
		 if (result.isPresent()){
		     System.out.println("Your name: " + result.get());   
		 }
		 // The Java 8 way to get the response value (with lambda expression).
		 result.ifPresent(name -> System.out.println("Your name: " + name));
		 nombreJugador=result.get();
//		 txtNombre.setText(result.get());
		 ArrayList<Jugador> jugadores= main.darEntrenamiento().ordenarPorNombre(main.darEntrenamiento().darJugadores());
		 String encontro=main.darEntrenamiento().buscarJugador(jugadores, nombreJugador);
		 
		 JOptionPane.showMessageDialog(null,encontro );
	}















	public void busquedaPokemon() {

		 String nombreJugador="";
		
		 
		 TextInputDialog dialog = new TextInputDialog("name");
		 dialog.setTitle("Text Input Dialog");
		 dialog.setHeaderText("Look, a Text Input Dialog");
		 dialog.setContentText("Please enter name of Pokemon:");
		 
		// Traditional way to get the response value.
		
		 Optional<String> result = dialog.showAndWait();
		 if (result.isPresent()){
		     System.out.println("Your name: " + result.get());   
		 }
		 // The Java 8 way to get the response value (with lambda expression).
		 result.ifPresent(name -> System.out.println("Your name: " + name));
		 nombreJugador=result.get();
//		 txtNombre.setText(result.get());
		 ArrayList<Pokemon> pokemones= main.darEntrenamiento().ordenarPorNombrePokemon(main.darEntrenamiento().darPokemones());
		 String encontro=main.darEntrenamiento().buscarPokemon(pokemones, nombreJugador);
		 
		 JOptionPane.showMessageDialog(null,encontro );
	}
	
	
}
