import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int port = 666;
        String host = "localhost";

        /*try {
            Socket socket = new Socket(host, port);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            while (true) {
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            DatagramSocket dSocket = new DatagramSocket();

            byte[] buf = new byte[]{1, 2, 3, 4, 5, 12, 127};

            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(host), port);

            dSocket.send(packet);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            Socket socket = new Socket(host, port);

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter mode: ");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            if (keyboard.nextLine().equals("calc")) {
                System.out.print("Enter first number: ");
                int a = keyboard.nextInt();
                System.out.println("You entered first number: " + a);
                System.out.print("Enter second number: ");
                int b = keyboard.nextInt();
                System.out.println("You entered first number: " + b);

                outputStream.writeInt(1);
                outputStream.writeInt(a);
                outputStream.writeInt(b);
                outputStream.flush();

                int sum = inputStream.readInt();
                System.out.println(sum);
            }else{
                outputStream.writeInt(2);
                outputStream.flush();
                int size = inputStream.readInt();
                System.out.println("Number of clients now equals: " + size);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
