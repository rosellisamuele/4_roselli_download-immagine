package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    protected Socket clientSocket;
    protected BufferedReader inStream;
    protected DataOutputStream outStream;
    protected int clientID;
    
    protected static int clientNumber = 0;

    public void accept(ServerSocket serverSocket){
        try{
            clientSocket = serverSocket.accept();
            inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outStream = new DataOutputStream(clientSocket.getOutputStream());            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void send(String message){
        try{
            outStream.writeBytes(message);
        }catch(IOException e){
            System.out.println("Errore durante l'invio del messaggio al client");
            e.printStackTrace();
        }
    }

    public String receive(){
        try{
            return inStream.readLine();
        }catch(IOException e){
            e.printStackTrace();
            return "ERRORE";
        }
    }

    public void closeClientSocket(){
        try{
            clientSocket.close();
        }catch(IOException e){
            System.out.println("Impossibile terminare la connessione");
            e.printStackTrace();
        }
    }
}