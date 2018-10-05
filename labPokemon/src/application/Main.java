package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Entrenamiento;
import modelo.Jugador;
import modelo.Pokemon;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@FXML
private Stage stage;
	private static ArrayList<Jugador> jugadores;
	private static ArrayList<Pokemon> pokemones;
	private static Pokemon pokemon;
	
	private static Jugador jugador;
	
	private static Entrenamiento entrenamiento= new Entrenamiento();
	
	private static LanzarController lanzar;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
//			Scene scene = new Scene(root,580,580);
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pokemon darPokemon() {
		return pokemon;
	}
	public Entrenamiento darEntrenamiento() {
		return entrenamiento;
	}
	
	
	public ArrayList<Pokemon> darPokemones(){
		return pokemones;
	}
	
	public Jugador darJugador() {
		return jugador;
	}
	
public ArrayList<Jugador> darJugadores(){
	return jugadores;
}

public void cambiarJugadores(ArrayList<Jugador> jugadorsitos) {
	this.jugadores=jugadorsitos;
}

	public static void main(String[] args) {
		pokemones= new ArrayList<Pokemon>();
		jugadores= new ArrayList<Jugador>();
//		
//		
//		Pokemon pokemon1= new Pokemon("Rosa",509.0,50.0,false,"/img/pokemonRosa.png");
//		Pokemon pokemon2= new Pokemon("Rana",509.0,50.0,false,"/img/pokemonDorado.png");
//		Pokemon pokemon3= new Pokemon("Dragon",509.0,50.0,false,"/img/pokemon3.png");
//		
//		
//		Pokemon pokemon4= new Pokemon("Pikachu",509.0,50.0,false,"/img/pikachu.png");
//		Pokemon pokemon5= new Pokemon("Dragon rojo",509.0,50.0,false,"/img/pokemonDragon.jpg");
//		Pokemon pokemon6= new Pokemon("Sapotico",509.0,50.0,false,"/img/pokemon1.png");
//		
//		pokemones.add(pokemon1);
//		pokemones.add(pokemon2);
//		pokemones.add(pokemon3);
//		pokemones.add(pokemon4);
//		pokemones.add(pokemon5);
//		pokemones.add(pokemon6);
	
		
//		pokemon= new Pokemon("pokemon",0,5,false,"/img/pokemon1.png");
//		
//		HiloPokemon pokemon1 = new HiloPokemon(pokemon);
//		Thread hiloPokemon = new Thread(pokemon1);
//		hiloPokemon.start();
		launch(args);
	}
	
	public Stage darEstage() {
		return stage;
	}
	
	
}
