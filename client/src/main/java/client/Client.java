package client;

import java.io.*;
import java.net.*;

public class Client {
    protected Socket connectionSocket;
    protected BufferedReader inStream;
    protected DataOutputStream outStream;

    public void start(String serverIP, int serverPort){
        try{
            connectionSocket = new Socket(serverIP, serverPort);
            inStream = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outStream = new DataOutputStream(connectionSocket.getOutputStream());
        }catch (Exception e){
            System.out.println("Errore durante l'istanza del server: "+e.getMessage());
            System.exit(1);
        }
    }

    public void send(String msg){
        try{
            outStream.writeBytes(msg);
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
            return "ERROR";
        }
    }

    public void close(){
        try{
            connectionSocket.close();
        }catch(IOException e){
            System.out.println("Errore durante la chiusura del server");
            e.printStackTrace();
        }
    }
}