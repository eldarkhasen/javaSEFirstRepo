package bit.eldar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(1789);
            System.out.println("WAITING CLIENT");
            Socket socket = server.accept();
            System.out.println("CLIENT CONNECTED");
            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            String message = "";
            while((message = (String) inputStream.readObject())!=null){
                System.out.println(message);
                if(message.toLowerCase().equals("hello")){
                    outputStream.writeObject("HI FROM SERVER!!!");
                }else{
                    outputStream.writeObject(null);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
