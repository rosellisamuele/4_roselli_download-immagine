package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

public class AppServer
{
    static int port = 5678;
    public static void main( String[] args )
    {
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        
        System.out.println("Il server e' aperto [porta "+port+"]");
        for(;;) {
            Server server = new Server();
            server.accept(serverSocket);
            System.out.println("Client connesso");
            SendImg send = new SendImg(server);
            send.start();
        }
    }

    public static class SendImg extends Thread{

        private Server server;

        public SendImg(Server server){
            this.server = server;
        }

        public void run(){
            try{


                File imgref = new File("../images/bluesmurfcat.jpg");
                FileInputStream fin = new FileInputStream(imgref);
                String len = ""+imgref.length();
                server.send(len);



            }catch(FileNotFoundException e){


                System.out.println("Impossibile trovare il file richiesto.");
                e.printStackTrace();


            }
            
        }


    }
}
