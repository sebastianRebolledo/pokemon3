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
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.w3c.dom.events.EventException;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Jugador;
import modelo.Pokemon;

public class LanzarController {

	static private Main main;
	
	@FXML
	private Label lblNickName;
	@FXML
	private TextField txtNombre;
	
	@FXML
	Rectangle rBandera;
	@FXML
	Image imagen;
	
  
	
	@FXML
	AnchorPane pane;
    @FXML
     Timeline timel;
	
	
	@FXML
	private Button btnCargarJuego;
 
	@FXML
	private Button guardar;
	
	@FXML
	private Stage stage;
	
	@FXML 
	private Rectangle rectangle2;
	
	@FXML
	private Label lblPuntaje;

	private SampleController sample;
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
	  
	  private Pokemon pokemon;
	  
		public void initalize() {
			
			

			txtNombre.setText(sample.darNombre());
			txtNombre.setDisable(false);
			lblPuntaje.setText("0");
			lblNickName.setText("NickName");
			asignarImagenesApokemon() ;
			

			rectangle2.setHeight(pokemon.darRadio());
			rectangle2.setWidth(pokemon.darRadio());
			


		}
	  
	
	  
	  
		public LanzarController() {
			lblNickName=new Label();
			txtNombre= new TextField();
			
//			asignarImagenesApokemon();
			try {
				sample=new SampleController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pokemon= new Pokemon("Pkachu",509.0,50.0,false,"/img/pokemon1.png");
			rectangle2= new Rectangle();
			rBandera= new Rectangle();
			URL pokemon2= getClass().getResource("/img/bandera.jpg");
			Image imagen2= new Image(pokemon2.toString(),85,85,false,true);
			rBandera.setFill(new ImagePattern(imagen2));
//			rectangle2.setX(pokemon.darPosX());
//			rectangle2.setHeight(pokemon.darRadio());
//			rectangle2.setWidth(pokemon.darRadio());
//			pokemon= new Pokemon(0,2.0,false);
//			rectangle2= new Rectangle();
//			rectangle2.setWidth(pokemon.darRadio());
			
			main= new Main();
			
			archivoPokemones() ;

			guardarJugadoresSerializables();
		

		}
	
	
public void asignarImagenesApokemon() {
	URL pbolaPokemon= getClass().getResource("/img/bola.png");
	Image bola= new Image(pbolaPokemon.toString(),34,34,false,true);
	rectangle2.setFill(new ImagePattern(bola));
	
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

	
	

	URL bandera= getClass().getResource("/img/bandera.jpg");
	Image imagenBandera= new Image(bandera.toString(),85,85,false,true);
	rBandera.setFill(new ImagePattern(imagenBandera));
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
						main.darPokemones().add(poke);
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
//							String st = br.readLine();
//							while (st != null) {
//								texto = texto + st + "\n";
//								st = br.readLine();
//							}
						} catch (Exception ex) {
//							textArea.appendText(e.toString());
						} finally {
							try {
								fr.close();
							} catch (Exception e2) {
//								textArea.appendText(e2.toString());
							}
						}
						
					}
					
					
					
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
					
					
					
//					BufferedReader buffer= new BufferedReader(fileReader);
					

					
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
							
//							String texto = textArea.getText();
//							bw.write(texto, 0, texto.length());
						} catch (Exception e1) {
//							textArea.appendText(e1.toString());
						} finally {
							try {
								bw.close();
							} catch (Exception e2) {
//								textArea.appendText(e2.toString());
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

			    	fileInStr = new FileInputStream("archivos/GuardarJuego.txt");
			        entrada = new ObjectInputStream(fileInStr);

			        jugadorsitos=(ArrayList<Jugador>) entrada.readObject();
			    
			        main.cambiarJugadores(jugadorsitos);

			        
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
		 
		 
		 
		 
		 
		 public void guardarJugadoresSerializables() {
				agregarJugadores() ;

				FileOutputStream fileOutS = null;
				ObjectOutputStream salida = null;
			ArrayList<Jugador> jugadores=null;
				try {
					fileOutS = new FileOutputStream("archivos/GuardarJuego.txt");// permite subri el archivo que esta en el disco duro
					salida = new ObjectOutputStream(fileOutS);
					
					jugadores=(ArrayList<Jugador>)main.darJugadores();
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


		 
		 
		 
		 
		 
		 public Jugador playerActual() {
			 Jugador jugador=null;
			 String nombre=txtNombre.getText();
			 for(int i=0;i<main.darJugadores().size();i++) {
				 if(main.darJugadores().get(i).darNombre().equals(nombre)) {
					jugador=main.darJugadores().get(i); 
				 }
			 }
			 return jugador;
		}
		 
		 
		 
		 
		 public void moverEnsayo(ActionEvent e) {
			 
			 if(btnPokemon1==e.getSource()) {
				 
				 for(int i=0;i<main.darPokemones().size();i++) {
					 Pokemon pok= main.darPokemones().get(i);
					 if(pok.darImagen().equals("/img/pokemonRosa.png")) {
						rectangle2.setLayoutX(pok.darPosX());
						rectangle2.setArcWidth(pok.darRadio());
						rectangle2.setHeight(pok.darRadio());
						rectangle2.setWidth(pok.darRadio());
						rectangle2.setArcHeight(pok.darRadio());
						rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								// TODO Auto-generated method stub
								Rectangle r= (Rectangle)event.getSource();
								r.setArcHeight(pok.darRadio());
								
								URL pokemon1= getClass().getResource(pok.darImagen());
								Image imagen= new Image(pokemon1.toString(),84,84,false,true);
								r.setFill(new ImagePattern(imagen));
								 SecureRandom random = new SecureRandom();
							      int dx = 1 + random.nextInt(3);
								TranslateTransition trans= new TranslateTransition();
								trans.setDuration(Duration.seconds(dx));
								trans.setToX(-400.0);
								trans.setNode(r);
								trans.play();
								
								
								trans.setOnFinished(new EventHandler<ActionEvent>() {
int puntaje=0;
									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*(-1)));
										puntaje+=5;
										Jugador jugador=playerActual();
										jugador.cambiarPuntaje(puntaje);
										lblPuntaje.setText(puntaje+"");

									}
									
								});
								
								
							}
							
						}); 
						 
						 
					 }
				 }
				 
				 
			 }else if(btnPokemon2==e.getSource()) {
				 
				 for(int i=0;i<main.darPokemones().size();i++) {
					 Pokemon pok= main.darPokemones().get(i);
					 if(pok.darImagen().equals("/img/pokemonDorado.png")) {
						rectangle2.setLayoutX(pok.darPosX());
						rectangle2.setArcWidth(pok.darRadio());
						rectangle2.setArcHeight(pok.darRadio());
						rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								// TODO Auto-generated method stub
								Rectangle r= (Rectangle)event.getSource();
								r.setArcHeight(pok.darRadio());
								
								URL pokemon1= getClass().getResource(pok.darImagen());
								Image imagen= new Image(pokemon1.toString(),84,84,false,true);
								r.setFill(new ImagePattern(imagen));
								SecureRandom random = new SecureRandom();
							      int dx = 1 + random.nextInt(3);
								TranslateTransition trans= new TranslateTransition();
								trans.setDuration(Duration.seconds(dx));
								trans.setToX(-400.0);
								trans.setNode(r);
//								System.out.println(509/3+"");
								trans.play();
								
								trans.setOnFinished(new EventHandler<ActionEvent>() {
int puntaje=0;
									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*-1));
										puntaje+=5;
										Jugador jugador=playerActual();
										jugador.cambiarPuntaje(puntaje);
										lblPuntaje.setText(puntaje+"");
									}
									
								});
							}
							
						}); 
						 
						 
					 }
				 }
				 
				 
				 
				}else if(btnPokemon3==e.getSource()) {
					 for(int i=0;i<main.darPokemones().size();i++) {
						 Pokemon pok= main.darPokemones().get(i);
						 if(pok.darImagen().equals("/img/pokemon3.png")) {
							rectangle2.setLayoutX(pok.darPosX());
							rectangle2.setArcWidth(pok.darRadio());
							rectangle2.setArcHeight(pok.darRadio());
							rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									Rectangle r= (Rectangle)event.getSource();
									r.setArcHeight(pok.darRadio());
									
									URL pokemon1= getClass().getResource(pok.darImagen());
									Image imagen= new Image(pokemon1.toString(),84,84,false,true);
									r.setFill(new ImagePattern(imagen));
									SecureRandom random = new SecureRandom();
								      int dx = 1 + random.nextInt(3);
									TranslateTransition trans= new TranslateTransition();
									trans.setDuration(Duration.seconds(dx));
									trans.setToX(-400.0);
									trans.setNode(r);
//									System.out.println(509/3+"");
									trans.play();
									
									
									trans.setOnFinished(new EventHandler<ActionEvent>() {
int puntaje=0;
										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*(-1)));
											System.out.println(509.0);
											puntaje+=5;
											Jugador jugador=playerActual();
											jugador.cambiarPuntaje(puntaje);
											lblPuntaje.setText(puntaje+"");
										}
										
									});
									
									
								}
								
							}); 
							 
							 
						 }
					 }
				}else if(btnPokemon4==e.getSource()) {
					 for(int i=0;i<main.darPokemones().size();i++) {
						 Pokemon pok= main.darPokemones().get(i);
						 if(pok.darImagen().equals("/img/pikachu.png")) {
							rectangle2.setLayoutX(pok.darPosX());
							rectangle2.setArcWidth(pok.darRadio());
							rectangle2.setArcHeight(pok.darRadio());
							rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
int puntaje=0;
								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									Rectangle r= (Rectangle)event.getSource();
									r.setArcHeight(pok.darRadio());
									
									URL pokemon1= getClass().getResource(pok.darImagen());
									Image imagen= new Image(pokemon1.toString(),84,84,false,true);
									r.setFill(new ImagePattern(imagen));
									SecureRandom random = new SecureRandom();
								      int dx = 1 + random.nextInt(3);
									TranslateTransition trans= new TranslateTransition();
									trans.setDuration(Duration.seconds(dx));
									trans.setToX(-400.0);
									trans.setNode(r);
//									System.out.println(509/3+"");
									trans.play();
									
									
									trans.setOnFinished(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*-1));
											puntaje+=5;
											Jugador jugador=playerActual();
											jugador.cambiarPuntaje(puntaje);
											lblPuntaje.setText(puntaje+"");
										}
										
									});
									
									
								}
								
							}); 
							 
							 
						 }
					 }
				}else if(btnPokemon5==e.getSource()) {
					 for(int i=0;i<main.darPokemones().size();i++) {
						 Pokemon pok= main.darPokemones().get(i);
						 if(pok.darImagen().equals("/img/pokemonDragon.jpg")) {
							 System.out.println("5");
							rectangle2.setLayoutX(pok.darPosX());
							rectangle2.setArcWidth(pok.darRadio());
							rectangle2.setArcHeight(pok.darRadio());
							rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									Rectangle r= (Rectangle)event.getSource();
									r.setArcHeight(pok.darRadio());
									
									URL pokemon1= getClass().getResource(pok.darImagen());
									Image imagen= new Image(pokemon1.toString(),84,84,false,true);
									r.setFill(new ImagePattern(imagen));
									SecureRandom random = new SecureRandom();
								      int dx = 1 + random.nextInt(3);
									TranslateTransition trans= new TranslateTransition();
									trans.setDuration(Duration.seconds(dx));
									trans.setToX(-400.0);
									trans.setNode(r);
//									System.out.println(509/3+"");
									trans.play();
									
									
									trans.setOnFinished(new EventHandler<ActionEvent>() {
int puntaje=0;
										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+400.0);
											puntaje+=5;
											Jugador jugador=playerActual();
											jugador.cambiarPuntaje(puntaje);
											lblPuntaje.setText(puntaje+"");
										}
										
									});
									
									
								}
								
							}); 
							 
							 
						 }
					 }
				}else {
					 for(int i=0;i<main.darPokemones().size();i++) {
						 Pokemon pok= main.darPokemones().get(i);
						 if(pok.darImagen().equals("/img/pokemon1.png")) {
							rectangle2.setLayoutX(pok.darPosX());
							rectangle2.setArcWidth(pok.darRadio());
							rectangle2.setArcHeight(pok.darRadio());
							rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
int puntaje=0;
								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									Rectangle r= (Rectangle)event.getSource();
									r.setArcHeight(pok.darRadio());
									
									URL pokemon1= getClass().getResource(pok.darImagen());
									Image imagen= new Image(pokemon1.toString(),84,84,false,true);
									r.setFill(new ImagePattern(imagen));
									SecureRandom random = new SecureRandom();
								      int dx = 1 + random.nextInt(3);
									TranslateTransition trans= new TranslateTransition();
									trans.setDuration(Duration.seconds(dx));
									trans.setToX(-400.0);
									trans.setNode(r);

									trans.play();
									
									
									trans.setOnFinished(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+400.0);
											puntaje+=5;
											Jugador jugador=playerActual();
											jugador.cambiarPuntaje(puntaje);
											lblPuntaje.setText(puntaje+"");
										}
										
									});
									
									
									
								}
								
							}); 
							 
							 
						 }
					 }
				}
			 
		 }
		 
		 
		 
		 
		 
		 public void moverYCambiarPokemon(ActionEvent e) {
				rectangle2.setLayoutX(pokemon.darPosX());
				rectangle2.setArcWidth(pokemon.darRadio());
				rectangle2.setArcHeight(pokemon.darRadio());
			    rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					Rectangle r= (Rectangle)arg0.getSource();
					r.setArcHeight(pokemon.darRadio());
				if(btnPokemon1==e.getSource()) {
					URL pokemon1= getClass().getResource("/img/pokemonRosa.png");
					Image imagen= new Image(pokemon1.toString(),84,84,false,true);
					r.setFill(new ImagePattern(imagen));
					SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);
					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
//					System.out.println(509/3+"");
					trans.play();
					
					
					trans.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+507.0);
							System.out.println(509.0);
						}
						
					});

			
					
					
				}
				else if(btnPokemon2==e.getSource()) {
					URL pokemon2= getClass().getResource("/img/pokemonDorado.png");
					Image imagen2= new Image(pokemon2.toString(),84,84,false,true);
					r.setFill(new ImagePattern(imagen2));	
					SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);
					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
					trans.play();
	
					
					trans.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+507.0);
							System.out.println(509.0);
						}
						
					});

		
					
				}else if(btnPokemon4==e.getSource()) {
					URL pokemon4= getClass().getResource("/img/pikachu.png");
					Image imagen4= new Image(pokemon4.toString(),84,84,false,true);
					r.setFill(new ImagePattern(imagen4));	
					SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);
					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
					trans.play();
				}else if(btnPokemon5==e.getSource()) {
					URL pokemon5= getClass().getResource("/img/pokemonDragon.jpg");
					Image imagen5= new Image(pokemon5.toString(),84,84,false,true);
                    r.setFill(new ImagePattern(imagen5));
                    SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);
					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
					trans.play();
					
					trans.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+507.0);
							System.out.println(509.0);
						}
						
					});
					
					
					
				}else if(btnPokemon6==e.getSource()) {
					URL pokemon6= getClass().getResource("/img/pokemon1.png");
					Image imagen6= new Image(pokemon6.toString(),84,84,false,true);
                    r.setFill(new ImagePattern(imagen6));
                    
                    SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);
					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
					trans.play();
					
					
					
					trans.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+507.0);
							System.out.println(509.0);
						}
						
					});
					
				}
				
				
				
				
				else {
					URL pokemon3= getClass().getResource("/img/pokemon3.png");
					Image imagen3= new Image(pokemon3.toString(),84,84,false,true);
					r.setFill(new ImagePattern(imagen3));
					SecureRandom random = new SecureRandom();
				      int dx = 1 + random.nextInt(3);

					TranslateTransition trans= new TranslateTransition();
					trans.setDuration(Duration.seconds(dx));
					trans.setToX(-507.0);
					trans.setNode(r);
					trans.play();
					
					
					trans.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+507.0);
							
						}
						
					});
					
					
				}
					
				}
				 
			});
			 
			 
		 }
		 
		 public void eligioPokemon(ActionEvent e) {
//				 moverYCambiarPokemon( e);		
				 moverEnsayo(e);
		 }
		 
		 
		 
		
		

	  
		
		
		

		
		

	  
}
