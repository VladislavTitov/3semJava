import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable{

    Thread thread;
    Socket socket;
    ServerCallback callback;

    public ClientThread(Socket socket, ServerCallback callback) {
        this.thread = new Thread(this);
        this.socket = socket;
        this.callback = callback;
        thread.start();
    }

    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            if (dataInputStream.readInt() == 1) {
                int a = dataInputStream.readInt();
                System.out.println("a: " + a);
                int b = dataInputStream.readInt();
                System.out.println("b: " + b);
                dataOutputStream.writeInt(a + b);
                dataOutputStream.flush();
            }else {

                dataOutputStream.writeInt(callback.numberOfClients());
            }

            callback.removeClient(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
