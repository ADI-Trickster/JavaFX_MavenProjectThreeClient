import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread{
    Socket socketClient;
    ObjectOutputStream out;
    ObjectInputStream in;
    private Consumer<Serializable> callback;
    int port;
    boolean running = true;
//    PokerInfo gameState;

    Client(Consumer<Serializable> call, int portNum){
        callback = call;
        port = portNum;
    }

    public void run() {
        try {
            socketClient= new Socket("127.0.0.1", port);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        }
        catch(Exception e) {
            return;
        }

        while(running) {
            try {
//                String message = in.readObject().toString();
//                callback.accept(message); //really accept(platform.runlater(....message))
//                PokerInfo obj = (PokerInfo) in.readObject();
                PokerInfo pokerInfo = (PokerInfo) in.readObject();
//                  PokerInfo pokerInfo = (PokerInfo) obj;
                    manageClientGame(pokerInfo);
            }
            catch(Exception e) {

            }
        }
        closeConnection();
    }

    public void closeConnection(){
        try {
            socketClient.close();
        }
        catch(Exception e) {
            callback.accept("Error closing connection");
            e.printStackTrace();
        }
//        Platform.exit();
    }

    public void send(PokerInfo data) {
        try {
            out.writeObject(data);
            out.flush();
            out.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageClientGame(PokerInfo pokerInfo){
          callback.accept(pokerInfo);
    }
}