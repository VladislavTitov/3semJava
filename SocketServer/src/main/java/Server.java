import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server implements ServerCallback{
    private static ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
    private void waitSockets(){
        int port = 666;
        /*try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while(true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...");
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/



        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true){
                Socket socket = serverSocket.accept();
                clients.add(new ClientThread(socket, Server.this));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized int numberOfClients() {
        return clients.size();
    }

    public void removeClient(ClientThread client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.waitSockets();
    }
}
