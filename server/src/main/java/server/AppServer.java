package server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer
{
    static int port = 6789;

    /* 
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
            try{
                Server server = new Server();
                server.accept(serverSocket);
                System.out.println("Client connesso");
                SendImg send = new SendImg(server);
                send.start();
            }catch(Exception e){}
            
        }
    }
    */

    public static void main(String[] args){
        try{
            ServerSocket serverSocket;
            try{
                serverSocket = new ServerSocket(port);
            }catch (IOException e) {
                e.printStackTrace();
                return;
            }

            System.out.println("Connessione accettata.");
            
            for(;;){
                Server server = new Server();
                server.accept(serverSocket);
                SendImg img = new SendImg(server);
                img.start();
            }


            





            
        }
    }


    public static class SendImg extends Thread{

        private Server server;
        protected static File file;

        public SendImg(Server server){
            this.server = server;
        }

        @Override
        public void run(){
            try{
                FileInputStream reader = new FileInputStream("./images/bluesmurfcat.jpg");
            }catch(IOException e){}

            byte[] buffer = new byte[1024];
            int readLen;
            while((readLen = reader.read(buffer)) > 0){
                writer.write(buffer, 0, readLen);
            }
            


            /* 
            try{


                System.out.println("Immagine trovata!");
                String len = String.valueOf(file.length());
                server.send(len);


                byte[] bytes = fin.readAllBytes();
                server.send(bytes);
                



            }catch(FileNotFoundException e){


                System.out.println("Impossibile trovare il file richiesto.");
                e.printStackTrace();


            }
            */
        }


    }
}
