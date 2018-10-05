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
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Comparador.ComparadorNombre;
import Excepciones.ExcepcionTextoVacio;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
	
	private SampleController sample;
	private static Main main;
	
	@FXML
	private ListView lista1;
	
	@FXML
	private ListView lista2;
	
	@FXML
	private ObservableList<String> dataLista = FXCollections.observableArrayList();
	
	
	
	@FXML
	private ObservableList<String> dataLista2 = FXCollections.observableArrayList();
	@FXML
	private Button btnCargarJuego;
	
	
	
	@FXML
	private Button guardar;
	@FXML
	private Stage stage;
	@FXML
	private String nombre;
	@FXML
	   private Button btnPokemon1;
	   
	   @FXML
	   private Button btnPokemon2;
	   
	  @FXML
	  private Button btnPokemon3;
	  
	  @FXML
	  private Button btnPokemon4;
	  
	  @FXML
	  private Button btnPokemon5;
	  @FXML
	  private Button btnPokemon6;
	  
	 
	  @FXML
	  private Button btnVolver;
	
		
	
	@FXML
	private Circle pokemonC;
	
	@FXML 
	private Rectangle rectangle2;
	
	@FXML
	private Label lblNickName;
	@FXML
	private AnchorPane anchor;
	
	@FXML
	private Label lblPuntaje;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private Pane pane;
	
	
	
	public AtraparController() throws IOException  {
		lblNickName=new Label();
		txtNombre= new TextField();
		

		main=new Main();

archivoPokemones() ;

guardarJugadoresSerializables();


	}
	
	
public void initialize() throws IOException {
	sample=new SampleController();

	txtNombre.setText(sample.darNombre());
	txtNombre.setDisable(false);
	lblPuntaje.setText("0");
	lblNickName.setText("NickName");

	URL bandera= getClass().getResource("/img/bandera.jpg");
	Image imagenBandera= new Image(bandera.toString(),85,85,false,true);
	rectangle2.setFill(new ImagePattern(imagenBandera));
	//
	
	URL pbolaPokemon= getClass().getResource("/img/bola.png");
	Image bola= new Image(pbolaPokemon.toString(),34,34,false,true);
	pokemonC.setFill(new ImagePattern(bola));
	 
	URL pokemon1= getClass().getResource("/img/pokemonRosa.png");
	Image imagen= new Image(pokemon1.toString(),85,85,false,true);
	btnPokemon1.setGraphic(new ImageView(imagen));

	
	
	
	URL pokemon2= getClass().getResource("/img/pokemonDorado.png");
	Image imagen2= new Image(pokemon2.toString(),85,85,false,true);
	btnPokemon2.setGraphic(new ImageView(imagen2));


	
	URL pokemon3= getClass().getResource("/img/pokemon3.png");
	Image imagen3= new Image(pokemon3.toString(),84,84,false,true);
	btnPokemon3.setGraphic(new ImageView(imagen3));
	

	URL pokemon4= getClass().getResource("/img/pikachu.png");
	Image imagen4= new Image(pokemon4.toString(),84,84,false,true);
	btnPokemon4.setGraphic(new ImageView(imagen4));

	URL pokemon5= getClass().getResource("/img/pokemonDragon.jpg");
	Image imagen5= new Image(pokemon5.toString(),84,84,false,true);
	btnPokemon5.setGraphic(new ImageView(imagen5));

	URL pokemon6= getClass().getResource("/img/pokemon1.png");
	Image imagen6= new Image(pokemon6.toString(),84,84,false,true);
	btnPokemon6.setGraphic(new ImageView(imagen6));

	
	
	
	
}
	


public TextField darNombretxt() {
	return txtNombre;
}



public void modificarNombreTxt(String nombre) {
	txtNombre.setText(nombre);
}



public void agregarPersona() throws IOException {
	
	String nombre=txtNombre.getText();

	
	int puntaje=Integer.parseInt(lblPuntaje.getText());
	Jugador jugador= new Jugador(nombre,puntaje);
	main.darEntrenamiento().darJugadores().add(jugador);

	for(int i=0;i<main.darEntrenamiento().darJugadores().size();i++) {
		System.out.println(main.darEntrenamiento().darJugadores().get(i).darNombre() +""+ main.darJugadores().get(i).darPuntaje());

	}
	guardarJugadoresSerializables();

}

public void agregarJugadores() {
	Jugador jugadorsito1=new Jugador("Carmen",4);
	Jugador jugadorsito2= new Jugador("Marcela",14);
	Jugador jugadorsito3= new Jugador("Julian",23);
	Jugador jugadorsito4=new Jugador("Jose" , 12);
	Jugador jugadorsito5=new Jugador("Armando", 32);
	Jugador jugadorsito6= new Jugador("Andrea",22);
	Jugador jugadorsito7= new Jugador("Juana",34);
	
	main.darJugadores().add(jugadorsito1);
	main.darJugadores().add(jugadorsito2);
	main.darJugadores().add(jugadorsito3);
	main.darJugadores().add(jugadorsito4);
	main.darJugadores().add(jugadorsito5);
	main.darJugadores().add(jugadorsito6);
	main.darJugadores().add(jugadorsito7);
	
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



public void cargarJuegoDeMiComputadora(ActionEvent e) {
	if(e.getSource()==btnCargarJuego) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		
		
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
					txtNombre.setText(nombreJugador);
					lblPuntaje.setText(puntaje+"");
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




//Este metodo transforma los jugadores escritos o tranformado de forma binaira
//a un texto con sus atributos
public void escribirEnTextoLosJugadoresYPuntajes() throws IOException {
	File file = new File("archivos/GuardarJuego.txt") ;
	FileReader fileReader= new FileReader(file);
	
	File fileSalida= new File("archivos/Jugadores.txt");
	FileWriter file2= new FileWriter(fileSalida);
	
//	BufferedReader buffer= new BufferedReader(fileReader);
	
 PrintWriter fileResul = new PrintWriter(file2);
	 
	 try {
		 
		        
				for(int i=0;i<main.darJugadores().size();i++) {
					int puntaje=(int) main.darJugadores().get(i).darPuntaje();
					String nombre=(String)main.darJugadores().get(i).darNombre();
					fileResul.println(nombre+";"+puntaje+";");
					
				}
				fileResul.flush();
				
				 fileResul.close();    
				      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	 
	 
}









public void guardarArchivoEnComputadora(ActionEvent e) throws IOException {
	
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
				bw.write(nombre+";"+puntaje);
				
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







//Obtiene el arraylist serializable y se lo asigna al arraylist de jugadores del main
public void leerJugadoresSerializadosDeTxt() {
	
    FileInputStream fileInStr = null;
    ObjectInputStream entrada = null;

  ArrayList<Jugador> jugadorsitos;
    try {

    	fileInStr = new FileInputStream("archivos/GuardarJuego.txt");
        entrada = new ObjectInputStream(fileInStr);

        jugadorsitos=(ArrayList<Jugador>) entrada.readObject();
        main.darEntrenamiento().cambiarJugadores(jugadorsitos);
//        main.cambiarJugadores(jugadorsitos);

        
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

//ESTE METODO GUARDA LOS JUGADORES Y LOS TRANSFORMA DE FORMA BINARIA A UN TEXTO

public void guardarJugadoresSerializables() {
	agregarJugadores() ;

	FileOutputStream fileOutS = null;
	ObjectOutputStream salida = null;
ArrayList<Jugador> jugadores=null;
	try {
		fileOutS = new FileOutputStream("archivos/GuardarJuego.txt");// permite subri el archivo que esta en el disco duro
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














public Label darLabel() {
	return lblNickName;
}

public void modificarLabel(String mensaje) {
	lblNickName.setText(mensaje);
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

public void impirmir() {
	
}

public void asignarNickName(String name) {
	lblNickName.setText(name);
	
}



public Jugador playerActual() {
	 Jugador jugador=null;
	 String nombre=txtNombre.getText();
	 
	 boolean estaJugador=false;
	 for(int i=0;i<main.darEntrenamiento().darJugadores().size()&&!false;i++) {
		 if(main.darEntrenamiento().darJugadores().get(i).equals(nombre)) {
			 jugador=main.darEntrenamiento().darJugadores().get(i);
			 estaJugador=true;
		 }
		
	 }
	 

	 return jugador;
}


public void cambiarPuntajeAJugadorNuevo(Jugador jugador,int puntaje) {
	
	for(int i=0;i<main.darEntrenamiento().darJugadores().size();i++) {
		ComparadorNombre comNom= new ComparadorNombre();
		if(comNom.compare(jugador, main.darEntrenamiento().darJugadores().get(i))==0) {
			main.darEntrenamiento().darJugadores().get(i).cambiarPuntaje(puntaje);
		}
	}
	
}




public void guardarMiJuego() {
	
	 String nombre=txtNombre.getText();
	 int puntajeTotal=Integer.parseInt(lblPuntaje.getText());
	Jugador nuevoJugador=new Jugador(nombre,puntajeTotal);
	main.darEntrenamiento().darJugadores().add(nuevoJugador);
}

public void moverEnsayo(ActionEvent e) {
	
	 if(btnPokemon1==e.getSource()) {
		
		 
		btnPokemon2.setDisable(true);
		btnPokemon3.setDisable(true);
		btnPokemon4.setDisable(true);
		btnPokemon5.setDisable(true);
		btnPokemon6.setDisable(true);
		 for(int i=0;i<main.darEntrenamiento().darPokemones().size();i++) {
			 Pokemon pok= main.darEntrenamiento().darPokemones().get(i);
			 if(pok.darImagen().equals("/img/pokemonRosa.png")) {

				URL pokemon1= getClass().getResource("/img/pokemonRosa.png");
				Image poke= new Image(pokemon1.toString(),34,34,false,true);
				pokemonC.setFill(new ImagePattern(poke));
				
				 Timeline tml = new Timeline();
			      tml.setCycleCount(Timeline.INDEFINITE);
			      SecureRandom random = new SecureRandom();
			      
			      int dx = 1000 + random.nextInt(2000);
			      
			      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
			       new KeyValue (pokemonC.translateXProperty(), -550));
			      tml.getKeyFrames().add(movePlane);
			      tml.play();
			      
			      
			      pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
			    	  int puntaje=0; 
					@Override
					public void handle(MouseEvent event) {
						
						// TODO Auto-generated method stub
						if(pokemonC.getTranslateX()>=-400) {
							URL pokemon1= getClass().getResource("/img/bola.png");
							Image poke= new Image(pokemon1.toString(),34,34,false,true);
							pokemonC.setFill(new ImagePattern(poke));
							pok.cambiarAtrapado(true);
							
							
//                           Circle c= (Circle)event.getSource();
				
							
							
							
							
							if(pok.esAtrapado()==true) {
								try {
//									c.setFill(new ImagePattern(poke));
									long a=1000;
									long b =100;
									Thread hilo = new Thread();
									hilo.sleep(a);	
									URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
									Image pok2= new Image(pokemon2.toString(),34,34,false,true);
									pokemonC.setFill(new ImagePattern(pok2));
									hilo.sleep(b);
//									pokemonC.setLayoutY(400);
								
									
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
							
//							tml.stop();
							
							
						

							puntaje+=5;
							lblPuntaje.setText(puntaje+"");
							Jugador jugador=playerActual();
							if(jugador!=null) {
								main.darEntrenamiento().cambiarPuntajeAJugadorNuevo(jugador, puntaje);
//							cambiarPuntajeAJugadorNuevo(jugador, puntaje);
							}
							
							

						      
						
							

						}

					}
			    	  
				});
			      

			      
				
				 
			 }
		 }
		 
		 
	 }else if(btnPokemon2==e.getSource()) {
		 
		 
		 btnPokemon1.setDisable(true);
			btnPokemon3.setDisable(true);
			btnPokemon4.setDisable(true);
			btnPokemon5.setDisable(true);
			btnPokemon6.setDisable(true);
		 
		 for(int i=0;i<main.darPokemones().size();i++) {
			 Pokemon pok= main.darPokemones().get(i);
			
			 if(pok.darImagen().equals("/img/pokemonDorado.png")) {
				 System.out.println(pok.darRadio());
				 URL pokemon1= getClass().getResource("/img/pokemonDorado.png");
					Image poke= new Image(pokemon1.toString(),34,34,false,true);
					pokemonC.setFill(new ImagePattern(poke));
					 SecureRandom random = new SecureRandom();
				      int dx = 1000 + random.nextInt(2000);
					 Timeline tml = new Timeline();
				      tml.setCycleCount(Timeline.INDEFINITE);
				      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
				      new KeyValue (pokemonC.translateXProperty(), -500));
				      tml.getKeyFrames().add(movePlane);
				      tml.play();

				pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
					int puntaje=0; 
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						if(pokemonC.getTranslateX()>=-400) {
							URL pokemon1= getClass().getResource("/img/bola.png");
							Image poke= new Image(pokemon1.toString(),34,34,false,true);
//							pokemonC.setFill(new ImagePattern(poke));
							
							
							if(pok.esAtrapado()==true) {
								try {
//									c.setFill(new ImagePattern(poke));
									long a=1000;
									long b =100;
									Thread hilo = new Thread();
									hilo.sleep(a);	
									URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
									Image pok2= new Image(pokemon2.toString(),34,34,false,true);
									pokemonC.setFill(new ImagePattern(pok2));
									hilo.sleep(b);
//									pokemonC.setLayoutY(400);
								
									
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
//							tml.stop();
//							Circle c= (Circle)event.getSource();
//							c.setFill(new ImagePattern(poke));

							puntaje+=5;
							lblPuntaje.setText(puntaje+"");
							Jugador jugador=playerActual();
							jugador.cambiarPuntaje(puntaje);
												}
					
						
					}
					
				}); 
				 
				 
			 }
		 }
		 
		 
		 
		}else if(btnPokemon3==e.getSource()) {
			
			
			btnPokemon2.setDisable(true);
			btnPokemon1.setDisable(true);
			btnPokemon4.setDisable(true);
			btnPokemon5.setDisable(true);
			btnPokemon6.setDisable(true);
			
			
			 for(int i=0;i<main.darPokemones().size();i++) {
				 Pokemon pok= main.darPokemones().get(i);
				 if(pok.darImagen().equals("/img/pokemon3.png")) {
					 System.out.println(pok.darRadio());
					 URL pokemon1= getClass().getResource("/img/pokemon3.png");
						Image poke= new Image(pokemon1.toString(),34,34,false,true);
						pokemonC.setFill(new ImagePattern(poke));
						
						
						
						 SecureRandom random = new SecureRandom();
					      int dx = 1000 + random.nextInt(2000);
						
						
						 Timeline tml = new Timeline();
					      tml.setCycleCount(Timeline.INDEFINITE);
					      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
					       new KeyValue (pokemonC.translateXProperty(), -500));
					      tml.getKeyFrames().add(movePlane);
					      tml.play();

					pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
						int puntaje=0;
						@Override
						public void handle(MouseEvent event) {
						
							if(pokemonC.getTranslateX()>=-400) {
//								URL pokemon1= getClass().getResource("/img/bola.png");
//								Image poke= new Image(pokemon1.toString(),34,34,false,true);
//								pokemonC.setFill(new ImagePattern(poke));
								
								if(pok.esAtrapado()==true) {
									try {
//										c.setFill(new ImagePattern(poke));
										long a=1000;
										long b =100;
										Thread hilo = new Thread();
										hilo.sleep(a);	
										URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
										Image pok2= new Image(pokemon2.toString(),34,34,false,true);
										pokemonC.setFill(new ImagePattern(pok2));
										hilo.sleep(b);
//										pokemonC.setLayoutY(400);
									
										
									} catch (Exception e2) {
										// TODO: handle exception
									}
								}
								puntaje+=5;
								lblPuntaje.setText(puntaje+"");
								Jugador jugador=playerActual();
								
								jugador.cambiarPuntaje(puntaje);
//								tml.stop();
//								Circle c= (Circle)event.getSource();
//								c.setFill(new ImagePattern(poke));
								
							}
							
						
							
					
							
						}
						
					}); 
					 
					 
				 }
			 }
		}else if(btnPokemon4==e.getSource()) {
			
			
			
			btnPokemon2.setDisable(true);
			btnPokemon3.setDisable(true);
			btnPokemon1.setDisable(true);
			btnPokemon5.setDisable(true);
			btnPokemon6.setDisable(true);
			
			
			
			
			 for(int i=0;i<main.darPokemones().size();i++) {
				 Pokemon pok= main.darPokemones().get(i);
				 if(pok.darImagen().equals("/img/pikachu.png")) {
					 URL pokemon1= getClass().getResource("/img/pikachu.png");
						Image poke= new Image(pokemon1.toString(),34,34,false,true);
						pokemonC.setFill(new ImagePattern(poke));
						
						
						
						 SecureRandom random = new SecureRandom();
					      int dx = 1000 + random.nextInt(2000);
						
						
						 Timeline tml = new Timeline();
					      tml.setCycleCount(Timeline.INDEFINITE);
					      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
					       new KeyValue (pokemonC.translateXProperty(), -500));
					      tml.getKeyFrames().add(movePlane);
					      tml.play();
//					rectangle2.setLayoutX(pok.darPosX());
//					rectangle2.setArcWidth(pok.darRadio());
//					rectangle2.setArcHeight(pok.darRadio());
					pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
int puntaje=0;
						@Override
						public void handle(MouseEvent event) {
							
							
							
							
							
							if(pokemonC.getTranslateX()>=-400) {
//								URL pokemon1= getClass().getResource("/img/bola.png");
//								Image poke= new Image(pokemon1.toString(),34,34,false,true);
//								pokemonC.setFill(new ImagePattern(poke));
								
								if(pok.esAtrapado()==true) {
									try {
//										c.setFill(new ImagePattern(poke));
										long a=1000;
										long b =100;
										Thread hilo = new Thread();
										hilo.sleep(a);	
										URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
										Image pok2= new Image(pokemon2.toString(),34,34,false,true);
										pokemonC.setFill(new ImagePattern(pok2));
										hilo.sleep(b);
//										pokemonC.setLayoutY(400);
									
										
									} catch (Exception e2) {
										// TODO: handle exception
									}
								}
								puntaje+=5;
								lblPuntaje.setText(puntaje+"");
								Jugador jugador=playerActual();
								jugador.cambiarPuntaje(puntaje);
//								tml.stop();
//								Circle c= (Circle)event.getSource();
//								c.setFill(new ImagePattern(poke));
								
							}
							
							
							
							
//							URL pokemon1= getClass().getResource("/img/bola.png");
//							Image poke= new Image(pokemon1.toString(),34,34,false,true);
//							pokemonC.setFill(new ImagePattern(poke));
							
//							tml.stop();
//							Circle c= (Circle)event.getSource();
//							c.setFill(new ImagePattern(poke));
							
							
						}
						
					}); 
					 
					 
				 }
			 }
		}else if(btnPokemon5==e.getSource()) {
			
			
			btnPokemon2.setDisable(true);
			btnPokemon3.setDisable(true);
			btnPokemon4.setDisable(true);
			btnPokemon1.setDisable(true);
			btnPokemon6.setDisable(true);
			
			
			
			 for(int i=0;i<main.darPokemones().size();i++) {
				 Pokemon pok= main.darPokemones().get(i);
				 if(pok.darImagen().equals("/img/pokemonDragon.jpg")) {

					 URL pokemon1= getClass().getResource("/img/pokemonDragon.jpg");
						Image poke= new Image(pokemon1.toString(),34,34,false,true);
						pokemonC.setFill(new ImagePattern(poke));
						
						
						
						 SecureRandom random = new SecureRandom();
					      int dx = 1000 + random.nextInt(2000);
						
						
						
						 Timeline tml = new Timeline();
					      tml.setCycleCount(Timeline.INDEFINITE);
					      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
					       new KeyValue (pokemonC.translateXProperty(), -500));
					      tml.getKeyFrames().add(movePlane);
					      tml.play();
		
					 pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
int puntaje=0;
							@Override
							public void handle(MouseEvent event) {
								
								
								
								
								if(pokemonC.getTranslateX()>=-400) {
//									URL pokemon1= getClass().getResource("/img/bola.png");
//									Image poke= new Image(pokemon1.toString(),34,34,false,true);
//									pokemonC.setFill(new ImagePattern(poke));
									
									if(pok.esAtrapado()==true) {
										try {
//											c.setFill(new ImagePattern(poke));
											long a=1000;
											long b =100;
											Thread hilo = new Thread();
											hilo.sleep(a);	
											URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
											Image pok2= new Image(pokemon2.toString(),34,34,false,true);
											pokemonC.setFill(new ImagePattern(pok2));
											hilo.sleep(b);
//											pokemonC.setLayoutY(400);
										
											
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									puntaje+=5;
									lblPuntaje.setText(puntaje+"");
									Jugador jugador=playerActual();
									jugador.cambiarPuntaje(puntaje);
//									tml.stop();
//									Circle c= (Circle)event.getSource();
//									c.setFill(new ImagePattern(poke));
									
								}
								
								
								
//								URL pokemon1= getClass().getResource("/img/bola.png");
//								Image poke= new Image(pokemon1.toString(),34,34,false,true);
////								pokemonC.setFill(new ImagePattern(poke));
//								
//								tml.stop();
//								Circle c= (Circle)event.getSource();
//								c.setFill(new ImagePattern(poke));
//								
							}
							
						});
					 
				 }
			 }
		}else {
			 for(int i=0;i<main.darPokemones().size();i++) {
				 btnPokemon2.setDisable(true);
					btnPokemon3.setDisable(true);
					btnPokemon4.setDisable(true);
					btnPokemon5.setDisable(true);
					btnPokemon1.setDisable(true);
				 Pokemon pok= main.darPokemones().get(i);
				 if(pok.darImagen().equals("/img/pokemon1.png")) {
//					rectangle2.setLayoutX(pok.darPosX());
//					rectangle2.setArcWidth(pok.darRadio());
//					rectangle2.setArcHeight(pok.darRadio());
					 URL pokemon1= getClass().getResource("/img/pokemon1.png");
						Image poke= new Image(pokemon1.toString(),34,34,false,true);
						pokemonC.setFill(new ImagePattern(poke));
						
						 SecureRandom random = new SecureRandom();
					      int dx = 1000 + random.nextInt(4000);
						
						
						 Timeline tml = new Timeline();
					      tml.setCycleCount(Timeline.INDEFINITE);
					      KeyFrame movePlane = new KeyFrame(Duration.millis(dx),
					       new KeyValue (pokemonC.translateXProperty(), -500));
					      tml.getKeyFrames().add(movePlane);
					      tml.play();
		
					 pokemonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
int puntaje=0;
							@Override
							public void handle(MouseEvent event) {
								
								
								
								
								if(pokemonC.getTranslateX()>=-400) {
//									URL pokemon1= getClass().getResource("/img/bola.png");
//									Image poke= new Image(pokemon1.toString(),34,34,false,true);
//									pokemonC.setFill(new ImagePattern(poke));
									
									if(pok.esAtrapado()==true) {
										try {
//											c.setFill(new ImagePattern(poke));
											long a=1000;
											long b =100;
											Thread hilo = new Thread();
											hilo.sleep(a);	
											URL pokemon2= getClass().getResource("/img/pokemonRosa.png");
											Image pok2= new Image(pokemon2.toString(),34,34,false,true);
											pokemonC.setFill(new ImagePattern(pok2));
											hilo.sleep(b);
//											pokemonC.setLayoutY(400);
										
											
										} catch (Exception e2) {
											// TODO: handle exception
										}
									}
									puntaje+=5;
									lblPuntaje.setText(puntaje+"");
									Jugador jugador=playerActual();
									jugador.cambiarPuntaje(puntaje);
//									tml.stop();
//									Circle c= (Circle)event.getSource();
//									c.setFill(new ImagePattern(poke));
									
								}
								
								
								
								
								
//								URL pokemon1= getClass().getResource("/img/bola.png");
//								Image poke= new Image(pokemon1.toString(),34,34,false,true);
////								pokemonC.setFill(new ImagePattern(poke));
//								
//								tml.stop();
//								Circle c= (Circle)event.getSource();
//								c.setFill(new ImagePattern(poke));
								
							}
							
						});
					 
				 }
			 }
		}
	 
	
	 
}



//public void ordenarInsercion() {
//	String mensaje = "";
//	ArrayList<Jugador>players=(ArrayList<Jugador>)main.darJugadores();
//	for (int i = 1; i <players.size(); i++) {
//		
//		for (int j = i; j>0 && players.get(j-1).compareToPuntaje(players.get(j).darPuntaje())>0; j--) {
//			Jugador temp = players.get(i);
//			players.add(j,players.get(j-1));
//			players.add(j-1, temp);
//		}
//		
//	}
//	for (int i = 0; i <players.size(); i++) {			
//			mensaje+= players.get(i).darNombre()+" "+players.get(i).darPuntaje()+"\n";
//			}
//
//	JOptionPane.showMessageDialog(null,mensaje);
//	
//}

//public String buscarJugadorBinaria() {
//	
//	String puntaje1= JOptionPane.showInputDialog("Digite el puntaje que busca");
//	int puntaje=Integer.parseInt(puntaje1);
//
//	ordenarInsercion();
//	
//	int inicio=0;
//	int fin= main.darJugadores().size()-1;
//	int posicion;
//	
//	
//	
//	while (inicio<=fin) {
//		posicion=(inicio+fin)/2;
//		if (main.darJugadores().get(posicion).darPuntaje()==puntaje) {
//			return main.darJugadores().get(posicion).darNombre();
//			
//		}else if(main.darJugadores().get(posicion).darPuntaje()<puntaje) {
//				inicio= posicion+1;
//			}else {
//				fin = posicion-1;
//			}
//		}
//	
//			return "No encontrado";		
//	}

	





//public void buscarPuntajeJugadorBinario() {
//	boolean encontro=false;
//	String nombre= JOptionPane.showInputDialog("Digite el el nombre que busca");
//	
//System.out.println(nombre);
//	
//	int inicio=0;
//	int fin= main.darJugadores().size()-1;
//	int posicion;
//	
////	ordenarInsercion();
//	
//	while (inicio<=fin&&!encontro) {
//		posicion=(inicio+fin)/2;
//		if (main.darJugadores().get(posicion).darNombre().equalsIgnoreCase(nombre)) {
//			System.out.println("Entro");
//			String nombreJugador=main.darJugadores().get(posicion).darNombre();
//			JOptionPane.showMessageDialog(null,"Nombre Jugador" +nombreJugador +""+"Puntaje"+main.darJugadores().get(posicion).darPuntaje());
//			encontro=true;
//		}else if(main.darJugadores().get(posicion).darNombre().length()<nombre.length()) {
//				inicio= posicion+1;
//			}else {
//				fin = posicion-1;
//			}
//		}
//	
//	JOptionPane.showMessageDialog(null,"El jugador que buscas no se encontro");
//
//}




public void ordernarPorNombre() {
	
	agregarJugadores();
	for(int i=0;i<main.darJugadores().size();i++) {
		Jugador porInserta=(Jugador)main.darJugadores().get(i);
		boolean termino=false;
		
		for(int j=i;j>0&&!termino;j--) {
			Jugador actual=(Jugador)main.darJugadores().get(j-1);
			if(actual.compareTo(porInserta)>0) {
				main.darJugadores().set(j, actual);
				main.darJugadores().set(j-1, porInserta);
				
				
			}else {
				termino=true;
			}
		}
	}
//	String mensaje="";
//	for(int i=0;i<main.darJugadores().size();i++) {
//		mensaje+=main.darJugadores().get(i).darNombre()+"\n";
//	}
//	JOptionPane.showMessageDialog(null,mensaje);
	
	
	
}


public void ordenarPorPuntaje() {
	agregarJugadores();
	for(int i=0;i<main.darJugadores().size();i++) {
		Jugador porInserta=(Jugador)main.darJugadores().get(i);
		boolean termino=false;
		
		for(int j=i;j>0&&!termino;j--) {
			Jugador actual=(Jugador)main.darJugadores().get(j-1);
			if(actual.compareToPuntos(porInserta)>0) {
				main.darJugadores().set(j, actual);
				main.darJugadores().set(j-1, porInserta);
				
				
			}else {
				termino=true;
			}
		}
	}
	
	
	
	
//	String mensaje="";
//	for(int i=0;i<main.darJugadores().size();i++) {
//		mensaje+=main.darJugadores().get(i).darNombre()+"" + main.darJugadores().get(i).darPuntaje()+"\n";
//	}
//	JOptionPane.showMessageDialog(null,mensaje);
	
}




public void mostrarListaPorNombre() {
	ordernarPorNombre();
	
	for(int i=0;i<main.darJugadores().size();i++) {
		System.out.println("Entro");
		dataLista.add(main.darJugadores().get(i).darNombre());	
	}


	
	lista1.setItems(dataLista);
	
	
}



public void mostrarListaPorPuntaje() {
	ordenarPorPuntaje();
//	System.out.println("Entro a puntaje1");

	for(int i=0;i<main.darJugadores().size();i++) {
		System.out.println("Entro a puntaje");
		dataLista2.add(main.darJugadores().get(i).darNombre()+ " " +"P:" + main.darJugadores().get(i).darPuntaje());	
	}


	
	lista2.setItems(dataLista2);
	
	
}







	
}

