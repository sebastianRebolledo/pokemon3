package application;

import java.io.IOException;
import java.net.URL;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Jugador;

public class SampleController {

	@FXML
	Image imagen;
	@FXML
	private Button btnLanzar;
	
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
		guardarNickName();


	}
	
	
	public void initalize() {


	
	}
 
	public void guardarNickNameAtrapar() {

	}
	
	public void guardarNickName() {

		 String nombre = JOptionPane.showInputDialog("Digita tu nombre porfavor :D");	
		 this.nombre=nombre;
		 Jugador nuevoJugador=new Jugador(nombre,0);
		 main.darEntrenamiento().darJugadores().add(nuevoJugador);
//		 main.darJugadores().add(nuevoJugador);
//		 atrapar.guardarJugadoresSerializables();
//		 atrapar.modificarNombreTxt(nombre);
//		 atrapar.darNombretxt().setText(nombre);
//		 atrapar.asignarNickName(nombre);

	}
	

	public String darNombre() {
		return nombre;
	}
	
	
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
        if(event.getSource()==btnLanzar){        
        
         stage=(Stage) btnLanzar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("lanzar.fxml"));
//        guardarNickName();
         }
        else if(event.getSource()==btnAtrapar){
    		
        	 stage=(Stage) btnAtrapar.getScene().getWindow(); 
        	  root = FXMLLoader.load(getClass().getResource("Atrapar.fxml"));
//        	  guardarNickName();

         }
 
        else{
          stage=(Stage) btnVolver.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
          
         }
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }



   public TextField darTextFiel(){
	 return txtNickName;
   }
  
	
	
	

	
	

	
}
