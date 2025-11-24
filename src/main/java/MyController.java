import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
//import javafx.scene.image.Image;


public class MyController implements Initializable{
    @FXML
    BorderPane welcomePane;
    @FXML
    BorderPane gamePane;
    @FXML
    BorderPane resultScreen;
    @FXML
    public Button connectToServer;
    @FXML
    public Button startGameButton;
    @FXML
    TextField textFIP;
    @FXML
    TextField textFPortNum;
    @FXML
    TextField ante;
    @FXML
    TextField pairPlus;
    @FXML
    Button playHand;
    @FXML
    Button fold;
    @FXML
    TextArea Dealer;
    @FXML
    TextArea gameInfo;
    @FXML
    TextArea player;
    @FXML
    TextArea rewards;

    private int anteBet = 0;
    private int PPBet = 0;
    private int change;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    boolean connectionAttempt = true;
    Client clientConnection;

    @FXML
    public void connectToServerMethod() throws IOException{
        if(connectionAttempt){
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

            connectionAttempt = false;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/connectClient.fxml"));
            Parent root = loader.load();
            MyController controller = loader.getController();
            clientConnection = new Client(data ->{
                Platform.runLater(()->{
                    textFPortNum.getText();
                });
            }, port
            );

//            System.out.println("client Connectioned");
            controller.clientConnection = clientConnection;
            controller.clientConnection.start();
//            System.out.println("client Connectioned 2");
            controller.startGameButton.setDisable(false);
            controller.connectToServer.setText("Connected to server");
            controller.connectToServer.setDisable(true);
//            System.out.println("client Connectioned 3");
            welcomePane.getScene().setRoot(root);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/game.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        welcomePane.getScene().setRoot(root);
    }

    @FXML
    public void playHand() throws IOException{
        System.out.println("Playing Hand");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/result.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        gamePane.getScene().setRoot(root);
    }

    @FXML
    public void fold() throws IOException{
        System.out.println("Folding");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/result.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();
        gamePane.getScene().setRoot(root);
    }

    @FXML
    public void handleAnteBet() throws IOException {
        String text = ante.getText();
        try {
            int anteBet = Integer.parseInt(text);

            if (anteBet < 5 || anteBet > 25) {
                ante.setText("Ante must be 5-25.");
                return;
            }

            this.anteBet = anteBet;


            // Enable play/fold options after a valid bet is placed
            playHand.setDisable(false);
            fold.setDisable(false);

        } catch (NumberFormatException e) {
            ante.setText("5");
        }
    }

    @FXML
    public void handlePairPlusBet() throws IOException {
        String text = pairPlus.getText();
        try {
            int ppBet = Integer.parseInt(text);

            if ((ppBet < 5 || ppBet > 25) && ppBet != 0) {
                pairPlus.setText("Pair Plus bet: 0 or 5-25");
                return;
            }

            this.PPBet = ppBet;
            System.out.println("Placed Pair Plus bet: $" + ppBet);

        } catch (NumberFormatException e) {
            pairPlus.setText("Invalid PP amount. Enter a number.");
            pairPlus.setText("0");
        }
    }

    @FXML
    public void playAgain() throws IOException{
        System.out.println("Playing Again");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/game.fxml"));
        Parent root = loader.load();


        MyController controller = loader.getController();


        controller.clientConnection = this.clientConnection;


        controller.anteBet = 0;
        controller.PPBet = 0;

        if (resultScreen != null && resultScreen.getScene() != null) {
            resultScreen.getScene().setRoot(root);
            System.out.println("Back to game screen.");
        } else {
            System.err.println("FAILED SWITCH");
        }
    }


    //MENU
    @FXML
    public void resetGame() throws IOException{
        System.out.println("Resetting game");
        Dealer.setText("Dealer's Hand");
        player.setText("Player's Hand");

        gameInfo.setText("New Game Started.");
        rewards.setText("$0");

        playHand.setDisable(true);
        fold.setDisable(true);

    }


    @FXML
    public void changeDesign() throws IOException{
        this.change++;
        if(this.change > 2){
            this.change = 0;
        }
        System.out.println("Changing Design");
        if (gamePane != null && gamePane.getScene() != null) {
            // Get the current Scene's stylesheet list and clear it
            gamePane.getScene().getStylesheets().clear();

            String cssFile = String.format("/Styles/style%d.css" , this.change);
            String css = getClass().getResource(cssFile).toExternalForm();
            gamePane.getScene().getStylesheets().add(css);
        }

        // 4. Switch the scene root to display the results screen
//        gamePane.getScene().setRoot(root);
    }

    @FXML
    public void exitGame() throws IOException{
        Platform.exit();
    }
    //END OF MENU
}
