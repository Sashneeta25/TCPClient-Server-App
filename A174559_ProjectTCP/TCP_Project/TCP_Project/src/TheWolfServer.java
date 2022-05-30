import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TheWolfServer {
     public static void main(String[] args) throws IOException {
    	
    	//TCP component
    	ServerSocket serverSocket = null;
    	Socket clientSocket = null;
    	int port = 8081;
            	
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for connection...");
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.toString() + " :Could not listen on port: " + port);
            System.exit(1);
        }
        
        
        try {
            clientSocket = serverSocket.accept();
            System.out.println("TCP Session established.");
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.toString() + " :Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
        String inputLine, outputLine;
        RedRidingHoodProtocol nis = new RedRidingHoodProtocol();

       outputLine = nis.processInput(null);
       out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
             outputLine = nis.processInput(inputLine);
             out.println(outputLine);
             if (outputLine.equalsIgnoreCase("BYE RED RIDING HOOD!"))
                break;
			 
        }
        
        //End connection
        out.flush();
        out.close();
        in.close();
        if (!clientSocket.isClosed())
        	clientSocket.close();
        if (!serverSocket.isClosed())
        	serverSocket.close();
        
        System.out.println("TCP session closed.");
    }
    
}
