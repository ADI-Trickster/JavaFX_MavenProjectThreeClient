import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert;
//import javafx.scene.image.Image;

public class MyController implements Initializable{

    @FXML
    BorderPane welcomePane;

    @FXML
    BorderPane gamePane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Button connectToServer;

    @FXML
    private Button start;

    boolean connectionAttempt = true;

    @FXML
    public void connectToServerMethod() throws IOException{
        if(connectionAttempt){
            start.setDisable(false);
            connectToServer.setText("Connected to server");
            connectToServer.setDisable(true);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection Failed");
            alert.setHeaderText("Connection Failed");
            alert.setContentText("Try again");
            alert.showAndWait();
        }
//        controller.textField1.clear();
//        controller.textField2.setText("final string goes here");
//        controller.textField2.clear();
//        controller.but1.setDisable(false);
//        controller.but1.setText("button one");
    }
//    public void StopServerMethod(){
//    }
    @FXML
    public void startGame() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/game.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        welcomePane.getScene().setRoot(root);
    }

    @FXML
    public void playHand() throws IOException{
        System.out.println("Playing Hand");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/result.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        gamePane.getScene().setRoot(root);
    }

    @FXML
    public void fold() throws IOException{
        System.out.println("Folding");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/result.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        gamePane.getScene().setRoot(root);
    }

    @FXML
    public void ante() throws IOException{
        System.out.println("Ante");
    }

    @FXML
    public void pairPlus() throws IOException{
        System.out.println("Pair plus");
    }

    @FXML
    public void playAgain() throws IOException{
        System.out.println("Playing Again");
    }


    //MENU
    @FXML
    public void resetGame() throws IOException{
        System.out.println("Resetting game");
    }
    @FXML
    public void changeDesign() throws IOException{
        System.out.println("Changing Design");
    }
    @FXML
    public void exitGame() throws IOException{
        Platform.exit();
    }
    //END OF MENU
}
