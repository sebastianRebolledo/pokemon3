package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Jugador;

public class SampleController {

	
	
	@FXML
	private Button btnListas;
	@FXML
	Image imagen;
	@FXML
	private Button btnLanzar;
	
	@FXML
	private Button cargarJuego;
	@FXML
	private Stage stage;
	@FXML
	private Button btnAtrapar;
	
 @FXML
 private TextField txtNickName;
 
   @FXML
   private Button btnVolver;
	
   private static Main main;
   
   private String nombre;
 
  private AtraparController atrapar;

	public SampleController() throws IOException {
		main=new Main();
		txtNickName= new TextField();
		
		atrapar= new AtraparController();
//		atrapar.leerJugadoresSerializadosDeTxt();
//		guardarNickName();


	}
	
	
	public void initalize() {

		
	
	}
 
	
	
	
	
	

	public void guardarNickName() {

//		 String nombre = JOptionPane.showInputDialog("Digita tu nombre porfavor :D");	
//		 this.nombre=nombre;
//		 Jugador nuevoJugador=new Jugador(nombre,0);
//		 main.darEntrenamiento().darJugadores().add(nuevoJugador);
		 
		
		 
		 TextInputDialog dialog = new TextInputDialog("walter");
		 dialog.setTitle("Text Input Dialog");
		 dialog.setHeaderText("Look, a Text Input Dialog");
		 dialog.setContentText("Please enter your name:");
		 
		// Traditional way to get the response value.
		 Optional<String> result = dialog.showAndWait();
		 if (result.isPresent()){
		     System.out.println("Your name: " + result.get());
		 }

		 // The Java 8 way to get the response value (with lambda expression).
		 result.ifPresent(name -> System.out.println("Your name: " + name));
		 
		 
		 
		


	}
	

	public String darNombre() {
		return nombre;
	}
	
	public Button btnDarcargar() {
		return cargarJuego;
	}
	
	public Button btnDarAtrpar() {
		return btnAtrapar;
	}
	
	
    
	
	
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
        if(event.getSource()==btnLanzar){        
        
         stage=(Stage) btnLanzar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("lanzar.fxml"));
      
         }
        else if(event.getSource()==btnAtrapar) {
    		
        	
        	
        	 stage=(Stage) btnAtrapar.getScene().getWindow(); 
        	  root = FXMLLoader.load(getClass().getResource("Atrapar.fxml"));
        	

         }
        else {
        	 stage=(Stage) btnListas.getScene().getWindow(); 
       	  root = FXMLLoader.load(getClass().getResource("ListaController.fxml"));
         }

         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }

	
	


   public TextField darTextFiel(){
	 return txtNickName;
   }
   
   
   
   
  

	

	
	

	
}
