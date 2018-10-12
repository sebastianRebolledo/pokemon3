package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import modelo.Jugador;
import modelo.Pokemon;

public class ListaController {

	
	
	@FXML
	private Button btnVolver;
	
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
	


	
	//Obtiene el arraylist serializable y se lo asigna al arraylist de jugadores del main

	
	
	
	
	
	
	
	
	
	
	
	public void toShowForPoints() {
		
		main.darAtrapar().leerJugadoresSerializadosDeTxt();
		ArrayList<Jugador> jugadores=main.darEntrenamiento().ordenarPorPuntajeJugador(main.darEntrenamiento().darJugadores());
		for(int i=jugadores.size()-1;i>=0;i--) {
			System.out.println("Entro a puntaje");
			dataListaPuntos.add(jugadores.get(i).darNombre()+ " - " +"Puntaje : " + jugadores.get(i).darPuntaje());	
		}


		
		listaPuntos.setItems(dataListaPuntos);
		
		
	}
	
	
	
	
	
	
	
	public void toShowListForName() {
		
		main.darAtrapar().leerJugadoresSerializadosDeTxt();

	    main.darEntrenamiento().ordenarPorNombreJugador(main.darEntrenamiento().darJugadores());	
		for(int i=0;i<main.darEntrenamiento().darJugadores().size();i++) {
			System.out.println("Entro");
			dataListaNombre.add(main.darEntrenamiento().darJugadores().get(i).darNombre());	
		}

		
		listaNombre.setItems(dataListaNombre);
		
		
	}
	
	
	
	public void mostrarNombreJugadorController() {

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
		 ArrayList<Jugador> jugadores= main.darEntrenamiento().ordenarPorNombreJugador(main.darEntrenamiento().darJugadores());
		 String encontro=main.darEntrenamiento().buscarJugador(jugadores, nombreJugador);
		 
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Jugador");
		 alert.setHeaderText("Informacion acerca del jugador");
		 alert.setContentText(encontro);

		 alert.showAndWait();
		 
//		 JOptionPane.showMessageDialog(null,encontro );
	}







    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
          
        
        stage=(Stage) btnVolver.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
      
   
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }






	public void mostrarNombrePokemonController() {

		 String nombreJugador="";
		
		 
		 TextInputDialog dialog = new TextInputDialog("name");
		 dialog.setTitle("Text Input Dialog");
		 dialog.setHeaderText("Look, a Text Input Dialog");
		 dialog.setContentText("Please enter name of Pokemon:");
		 		
		 Optional<String> result = dialog.showAndWait();
		 if (result.isPresent()){
		     System.out.println("Your name: " + result.get());   
		 }
		 result.ifPresent(name -> System.out.println("Your name: " + name));
		 nombreJugador=result.get();

		 ArrayList<Pokemon> pokemones= main.darEntrenamiento().ordenarPorNombrePokemon(main.darEntrenamiento().darPokemones());
		 String encontro=main.darEntrenamiento().buscarPokemon(pokemones, nombreJugador);
		 
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Pokemon");
		 alert.setHeaderText("Informacion acerca del pokemon");
		 alert.setContentText("Pokemon que buscas: " + encontro);

		 alert.showAndWait();
	}
	
	
}
