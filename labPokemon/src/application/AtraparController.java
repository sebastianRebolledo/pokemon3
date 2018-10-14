package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Comparador.ComparadorNombre;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Jugador;
import modelo.Pokemon;

public class AtraparController {

	@FXML
	Timeline timel;
	
	

	private static Main main;
	
	@FXML
	private Button btnCargarJuego;
	
	
	@FXML
	private ListView lista1;
	
	@FXML
	private ListView lista2;
	
	@FXML
	private KeyFrame movePlane;
	
	
	@FXML
	private Label lblPoke;
	

	

	
	@FXML
	private Button guardar;
	@FXML
	private Stage stage;

	  
	 @FXML
	 private Timeline tml;
	  @FXML
	  private Button btnVolver;
	
		
	
	@FXML
	private Circle pokemonC;
	
	@FXML 
	private Rectangle rectangle2;
	
	@FXML
	private Label lblPuntaje;
	
	@FXML
	private TextField txtNombre;
	

	
	
	
	public AtraparController() throws IOException  {
		
		txtNombre= new TextField();
		  pokemonC= new Circle();
	
		 SecureRandom random = new SecureRandom();
	     
	      int dx = 1000 + random.nextInt(2000);
	      
	    movePlane = new KeyFrame(Duration.millis(dx),
	       new KeyValue (pokemonC.translateXProperty(), -550));
		main=new Main();
		
archivoPokemones() ;
leerJugadoresSerializadosDeTxt();
	}
	
	
   public void initialize() {


	guardarNickName() ;
		
	choosePokemon() ;	
	
	lblPuntaje.setText("0");

	URL bandera= getClass().getResource("/img/bandera.jpg");
	Image imagenBandera= new Image(bandera.toString(),85,85,false,true);
	rectangle2.setFill(new ImagePattern(imagenBandera));

}
	



public void archivoPokemones() {
	
	File file= new File("archivos/pokemones.txt");
	try {
		FileReader fileReader= new FileReader(file);
		BufferedReader buffer= new BufferedReader(fileReader);
		String line="";
		
		while((line = buffer.readLine()) != null){ //Se leen las lineas hasta el final del documento
			System.out.println(line);
			String[] data= line.split(";");
			String nombrePokemon=data[0];
			double posicion=Double.parseDouble(data[1]);
			double radio=Double.parseDouble(data[2]);
			boolean esAtrapado=Boolean.parseBoolean(data[3]);
			
			String imagen=data[4];
			Pokemon poke= new Pokemon(nombrePokemon,posicion,radio,esAtrapado, imagen);
			main.darEntrenamiento().darPokemones().add(poke);
//			main.darPokemones().add(poke);
		}
		buffer.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
}







public void guardarNickName() {

	
	 TextInputDialog dialog = new TextInputDialog("name");
	 dialog.setTitle("Text Input Dialog");
	 dialog.setHeaderText("Look, a Text Input Dialog");
	 dialog.setContentText("Please enter your name:");
	 
	// Traditional way to get the response value.
	
	 Optional<String> result = dialog.showAndWait();
//	 if (result.isPresent()){
//	     System.out.println("Your name: " + result.get());   
//	 }
	 // The Java 8 way to get the response value (with lambda expression).
//	 result.ifPresent(name -> System.out.println("Your name: " + name));
	 txtNombre.setText(result.get());
}





public void choosePokemon() {
	List<String> choices = new ArrayList<>();
	choices.add("Bulbasaur");
	choices.add("Ivysaur");
	choices.add("Charmander");
	choices.add("Charmeleon");

	ChoiceDialog<String> dialog = new ChoiceDialog<>("Pokemones", choices);
	dialog.setTitle("Choice Dialog");
	dialog.setHeaderText("Look, a Choice Dialog");
	dialog.setContentText("Choose your Pokemon:");

	Optional<String> result = dialog.showAndWait();
	String nameElegido=result.get();
	lblPoke.setText(nameElegido);
	Pokemon encontrado=buscarPokemon(nameElegido);
	String rutaImagen=encontrado.darImagen();
	URL pokemon1= getClass().getResource(rutaImagen);
	Image poke= new Image(pokemon1.toString(),34,34,false,true);
	pokemonC.setFill(new ImagePattern(poke));
	
	tml = new Timeline();
      tml.setCycleCount(Timeline.INDEFINITE);
      SecureRandom random = new SecureRandom();
      
      int dx = 1000 + random.nextInt(2000);
      
     movePlane = new KeyFrame(Duration.millis(dx),
       new KeyValue (pokemonC.translateXProperty(), -550));
      tml.getKeyFrames().add(movePlane);
      tml.play();
      
      
  
      
//	
//	if (result.isPresent()){
//	    System.out.println("Your choice: " + result.get());
//	}

//	result.ifPresent(letter -> System.out.println("Your choice: " + letter));
	
	
}







	
public String nombreDelpokemon(String name) {
	return name;
}
	





public void cargarJuegoDeMiComputadora(ActionEvent e) {
	if(e.getSource()==btnCargarJuego) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(main.darEstage());
		
		
		if(file!=null){
			FileReader fr = null;
			BufferedReader br = null;
			String texto = "";
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				
				while((texto = br.readLine()) != null){ //Se leen las lineas hasta el final del documento
					System.out.println(texto);
					String[] data= texto.split(";");
					String nombreJugador=data[0];
					int puntaje=Integer.parseInt(data[1]);
					String pokemon=data[2];
					txtNombre.setText(nombreJugador);
					lblPuntaje.setText(puntaje+"");
					lblPoke.setText(pokemon);

					String nameElegido=nombreDelpokemon(pokemon);
					Pokemon encontrado=buscarPokemon(nameElegido);
					String rutaImagen=encontrado.darImagen();
					URL pokemon1= getClass().getResource(rutaImagen);
					Image poke= new Image(pokemon1.toString(),34,34,false,true);
					pokemonC.setFill(new ImagePattern(poke));
					
					
					
				}
				
				br.close();
//				String st = br.readLine();
//				while (st != null) {
//					texto = texto + st + "\n";
//					st = br.readLine();
//				}
			} catch (Exception ex) {
//				textArea.appendText(e.toString());
			} finally {
				try {
					fr.close();
				} catch (Exception e2) {
//					textArea.appendText(e2.toString());
				}
			}
			
		}
		
		
		
	}
	
}











public void leerJugadoresSerializadosDeTxt() {
	
    FileInputStream fileInStr = null;
    ObjectInputStream entrada = null;

  ArrayList<Jugador> jugadorsitos;
  
    try {

    	fileInStr = new FileInputStream("archivos/nuevo.dat");
        entrada = new ObjectInputStream(fileInStr);

        jugadorsitos=(ArrayList<Jugador>) entrada.readObject();
        main.darEntrenamiento().cambiarJugadores(jugadorsitos);
      
        
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage()+"excep1");
    } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage()+"excep2");
    } catch (IOException e) {
        System.out.println(e.getMessage()+"exce3");
    } finally {
        try {
            if (fileInStr != null) {
            	fileInStr.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage()+"excep4");
        }
    }
	
	
}










public void guardarArchivoEnComputadora(ActionEvent e) throws IOException {
	guardarJugadoresSerializables();
	
	
	if (e.getSource()==guardar) {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialFileName("Puntaje");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setSelectedExtensionFilter(extFilter);
		File file = fileChooser.showSaveDialog(main.darEstage());
	
//		BufferedReader buffer= new BufferedReader(fileReader);
	
		
		if(file!=null){
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				// EL segundo parametro es un boolean
				// En true escribe al final
				// En false escribe al inicio
				fw = new FileWriter(file, false);
				bw = new BufferedWriter(fw);
				String nombre=txtNombre.getText();
				String puntaje=lblPuntaje.getText();
				String pokemon=lblPoke.getText();
				
				bw.write(nombre+";"+puntaje+";"+pokemon);
				
//				String texto = textArea.getText();
//				bw.write(texto, 0, texto.length());
			} catch (Exception e1) {
//				textArea.appendText(e1.toString());
			} finally {
				try {
					bw.close();
				} catch (Exception e2) {
//					textArea.appendText(e2.toString());
				}
			}
		}
	}
	
	
	
}




//ESTE METODO GUARDA LOS JUGADORES Y LOS TRANSFORMA DE FORMA BINARIA A UN TEXTO

public void guardarJugadoresSerializables() {
//	agregarJugadores() ;

	String nombre=txtNombre.getText();
	int puntaje= Integer.parseInt(lblPuntaje.getText());
	Jugador j= new Jugador(nombre,puntaje);
	main.darEntrenamiento().darJugadores().add(j);
	
	FileOutputStream fileOutS = null;
	ObjectOutputStream salida = null;
ArrayList<Jugador> jugadores=null;
	try {
		fileOutS = new FileOutputStream("archivos/nuevo.dat");// permite subri el archivo que esta en el disco duro
		salida = new ObjectOutputStream(fileOutS);
		
		jugadores=(ArrayList<Jugador>)main.darEntrenamiento().darJugadores();
		salida.writeObject(jugadores);
		
	} catch (FileNotFoundException e) {
		
		System.out.println(e.getMessage());
	}catch(IOException e) {
		System.out.println(e.getMessage());
	
	}finally{
		try {
			if (jugadores != null)
				fileOutS.close();
			if (salida != null)
				salida.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}














public void comenzarJuegoCargado(String name) {
	
	
	String nameElegido=nombreDelpokemon(name);
	Pokemon encontrado=buscarPokemon(nameElegido);
	String rutaImagen=encontrado.darImagen();
	URL pokemon1= getClass().getResource(rutaImagen);
	Image poke= new Image(pokemon1.toString(),34,34,false,true);
	pokemonC.setFill(new ImagePattern(poke));
	
	tml = new Timeline();
      tml.setCycleCount(Timeline.INDEFINITE);
      SecureRandom random = new SecureRandom();
      
      int dx = 1000 + random.nextInt(2000);
      
     movePlane = new KeyFrame(Duration.millis(dx),
       new KeyValue (pokemonC.translateXProperty(), -550));
      tml.getKeyFrames().add(movePlane);
      tml.play();
	
	
	
}










public Pokemon buscarPokemon(String name) {
	Pokemon encontrado=main.darEntrenamiento().buscarPokemonChoice(main.darEntrenamiento().darPokemones(), name);
return encontrado;
}





public void moverBola() {
	
	
	pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
		int puntaje=0;
		@Override
		public void handle(MouseEvent event) {
		
			// TODO Auto-generated method stub
			if(pokemonC.getTranslateX()>=-400) {
				puntaje+=5;
				lblPuntaje.setText(puntaje+"");
				 
				   SecureRandom random = new SecureRandom();
				      
				      int dx = 100000 + random.nextInt(200000000);
				      
				      movePlane.getTime().add(Duration.millis(dx));
				   
				      
		
				
			      
			}
			
		}
		
	});

	
	
}










@FXML
public void handleButtonAction(ActionEvent event) throws IOException{
    Stage stage ; 
    Parent root ;
    
          
     stage=(Stage) btnVolver.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

    
    Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
     
   }





////Este metodo transforma los jugadores escritos o tranformado de forma binaira
////a un texto con sus atributos
//public void escribirEnTextoLosJugadoresYPuntajes() throws IOException {
//	File file = new File("archivos/GuardarJuego.txt") ;
//	FileReader fileReader= new FileReader(file);
//	
//	File fileSalida= new File("archivos/Jugadores.txt");
//	FileWriter file2= new FileWriter(fileSalida);
//	
////	BufferedReader buffer= new BufferedReader(fileReader);
//	
// PrintWriter fileResul = new PrintWriter(file2);
//	 
//	 try {
//				for(int i=0;i<main.darJugadores().size();i++) {
//					int puntaje=(int) main.darJugadores().get(i).darPuntaje();
//					String nombre=(String)main.darJugadores().get(i).darNombre();
//					fileResul.println(nombre+";"+puntaje+";");
//					
//				}
//				fileResul.flush();
//				
//				 fileResul.close();    
//				      
//	} catch (Exception e) {
//		// TODO: handle exception
//		System.out.println(e);
//	}
//	
//	 
//	 
//}












//public void moverEnsayo(ActionEvent e) {
//	
//	 if(btnPokemon1==e.getSource()) {
//	
//		 for(int i=0;i<main.darEntrenamiento().darPokemones().size();i++) {
//			 Pokemon pok= main.darEntrenamiento().darPokemones().get(i);
//			 if(pok.darImagen().equals("/img/pokemonRosa.png")) {
//
//				URL pokemon1= getClass().getResource("/img/pokemonRosa.png");
//				Image poke= new Image(pokemon1.toString(),34,34,false,true);
//				pokemonC.setFill(new ImagePattern(poke));
//				
//				 Timeline tml = new Timeline();
//			      tml.setCycleCount(Timeline.INDEFINITE);
//			      SecureRandom random = new SecureRandom();
//			      
//			      int dx = 1000 + random.nextInt(2000);
//			      
//			      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
//			       new KeyValue (pokemonC.translateXProperty(), -550));
//			      tml.getKeyFrames().add(movePlane);
//			      tml.play();
//			      
//			      
//			      pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			    	  int puntaje=0; 
//					@Override
//					public void handle(MouseEvent event) {
//						
//						// TODO Auto-generated method stub
//						if(pokemonC.getTranslateX()>=-400) {
//							URL pokemon1= getClass().getResource("/img/bola.png");
//							Image poke= new Image(pokemon1.toString(),34,34,false,true);
//							pokemonC.setFill(new ImagePattern(poke));
//							pok.cambiarAtrapado(true);
//							
//							
////                           Circle c= (Circle)event.getSource();
//				
//							
//							
//							
//							
//							if(pok.esAtrapado()==true) {
//								try {
////									c.setFill(new ImagePattern(poke));
//									long a=1000;
//									long b =100;
//									Thread hilo = new Thread();
//									hilo.sleep(a);	
//									URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
//									Image pok2= new Image(pokemon2.toString(),34,34,false,true);
//									pokemonC.setFill(new ImagePattern(pok2));
//									hilo.sleep(b);
////									pokemonC.setLayoutY(400);
//								
//									
//								} catch (Exception e2) {
//									// TODO: handle exception
//								}
//							}
//							
////							tml.stop();
//							
//							
//						
//
//							puntaje+=5;
//							lblPuntaje.setText(puntaje+"");
//							Jugador jugador=playerActual();
//							if(jugador!=null) {
//								main.darEntrenamiento().cambiarPuntajeAJugadorNuevo(jugador, puntaje);
////							cambiarPuntajeAJugadorNuevo(jugador, puntaje);
//							}
//							
//							
//
//						      
//						
//							
//
//						}
//
//					}
//			    	  
//				});
//			      
//
//			      
//				
//			 }
//		 }
//	 } 
//}















	
}

