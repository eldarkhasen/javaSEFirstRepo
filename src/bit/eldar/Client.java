package bit.eldar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1",1789);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while(true){
                System.out.println("Insert message");
                String message = in.next();
                outputStream.writeObject(message);
                if((message = (String) inputStream.readObject())!=null){
                    System.out.println(message);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
