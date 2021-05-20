package de.mathisneunzig.softwareengineeringvl.gruppe7.applicationservices;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Message message;

    public Server() {
        listen();
    }

    private void listen() {

        Socket client = null;

        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            ServerSocket server = new ServerSocket(8888);
            client = server.accept();
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            message = (Message) in.readObject();

            out.close();
            in.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Message getMessage()
    {
        return message;
    }


}
