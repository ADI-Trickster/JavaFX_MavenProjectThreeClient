import java.io.IOException;
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
    BorderPane borderPane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Button connectToServer;

    @FXML
    private Button start;


    @FXML
    public void connectToServerMethod() throws IOException{
        //
        if c
        start.setDisable(false);



//        controller.textField1.clear();
//        controller.textField2.setText("final string goes here");
//        controller.textField2.clear();
//        controller.but1.setDisable(false);
//        controller.but1.setText("button one");


    }
//    public void StopServerMethod(){
//    }

    public void startGame() throws IOException{
        //
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/game.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();


        borderPane.getScene().setRoot(root);
    }


}
