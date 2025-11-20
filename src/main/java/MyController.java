import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
//import javafx.scene.image.Image;

public class MyController implements Initializable{
    @FXML
    public BorderPane borderPane;

    @FXML
    public TextField textFIP;
    @FXML
    public TextField textFPortNum;

    @FXML
    public Button connectToServer;

    Client clientConnection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void connectToServerMethod() throws IOException{

        String IP = textFIP.getText();
        String portStr = textFPortNum.getText();
        if(IP.isEmpty() || portStr.isEmpty()){
            System.out.println("NO port or IP");
            return;
        }

        int port;
        try{
            port = Integer.parseInt(portStr);
            if(port < 1 || port > 65535){
                System.out.println("Invalid port");
                return;
            }
        }
        catch (Exception e) {
            System.out.println("Invalid port or IP");
            return;
        }

        clientConnection = new Client(data ->{
            Platform.runLater(()->{
                textFPortNum.getText();
            });
        }
        );
        clientConnection.start();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/game.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        borderPane.getScene().setRoot(root);
    }
//    public void StopServerMethod(){
//    }




}
