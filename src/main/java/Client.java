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

    Client(Consumer<Serializable> call, int portNum){
        callback = call;
        port = portNum;
    }

    public void run() {
        try {
            socketClient= new Socket("127.0.0.1", port);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        }
        catch(Exception e) {}

        while(true) {
            try {
                String message = in.readObject().toString();
                callback.accept(message); //really accept(platform.runlater(....message))
            }
            catch(Exception e) {}
        }
    }

    public void send(String data) {
        try {
            out.writeObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}