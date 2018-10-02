package application;

import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import modelo.Pokemon;

public class LanzarController {

	static private Main main;
	

	
	@FXML
	Rectangle rBandera;
	@FXML
	Image imagen;
	
  
	
	@FXML
	AnchorPane pane;
    @FXML
     Timeline timel;
	
	
	
	@FXML 
	private Rectangle rectangle2;

	
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
			
			asignarImagenesApokemon() ;
			

			rectangle2.setHeight(pokemon.darRadio());
			rectangle2.setWidth(pokemon.darRadio());

		}
	  
	
	  
	  
		public LanzarController() {
//			asignarImagenesApokemon();
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

									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*(-1)));
										
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

									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*-1));
										
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

										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+ (r.getTranslateX()*(-1)));
											System.out.println(509.0);
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

										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null,"La distancia recorrida es: "+400.0);
										
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
