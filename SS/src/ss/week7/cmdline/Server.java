
package ss.week7.cmdline;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	
    	if (args.length != 2) {
    		System.out.println(USAGE);
    		System.exit(0);
    	}
    	
    	String name = args[0];
    	int port = 0;
    	ServerSocket sock = null;
    	Socket clientSock = null;
    	
    	try {
    		port = Integer.parseInt(args[1]);
    	} catch (NumberFormatException e) {
    		System.out.println(USAGE);
            System.out.println("ERROR: port " + args[2]
            		           + " is not an integer");
            System.exit(0);
    	}
    	
    	try {
    		sock = new ServerSocket(port);
    	} catch (IOException e) {
    		System.out.println("Error: could not create a serverSocket on " + port);    		
    	}
    	
    	try {
    		while (true) {
    			System.out.println("Waiting for new Client.");
    			clientSock = sock.accept();
    			System.out.println("Received new connection.");
    			System.out.println("socket" + clientSock.getInetAddress());
    			Peer server = new Peer(name, clientSock);
    			Thread clientHandler = new Thread(server);
    			clientHandler.start();
    			server.handleTerminalInput();
    			server.shutDown();
    		}
    	} catch (IOException e) {
    		System.out.println(e);
    	}
    	
    }

} // end of class Server
