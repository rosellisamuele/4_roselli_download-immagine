package client;

/**
 * Hello world!
 *
 */
public class AppClient 
{
    static String serverInput;

    static String address = "localhost";
    static int port = 5678;
    public static void main( String[] args )
    {
        Client client = new Client();

        client.start(address, port);

        serverInput = client.receive();
        System.out.println(serverInput);

        client.send("Connessione riuscita");

    }
}
