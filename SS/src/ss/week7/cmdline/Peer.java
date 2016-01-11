package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Peer for a simple client-server application.
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	BufferedReader input;
    	try {
    		input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    		while (true) {
    			String line = input.readLine();
    			out.write(line);
    			out.flush();
    		}
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	BufferedWriter output;
    	Boolean doorgaan = true;
    	try {
    		output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    		while (doorgaan) {
    			String line = in.readLine();
    			if (line.equals("exit")) {
    				doorgaan = false;
    				shutDown();
    			} else {
    				output.write(line);
    				output.flush();
    			}
    		}
    	} catch (IOException e) {
    		System.err.println(e);
    	}
    }

    /**
     * Closes the connection, the sockets will be terminated.
     */
    public void shutDown() {
    	try {
    		sock.getInputStream().close();
    		sock.getOutputStream().close();
    		sock.close();
    	} catch (IOException e) {
    		System.err.println(e);
    	}
    }

    /**  returns name of the peer object. */
    public String getName() {
        return name;
    }

    /** read a line from the default input. */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
