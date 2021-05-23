package de.mathisneunzig.softwareengineeringvl.gruppe7.applicationservices;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void send(int senderID, int recepientID, String text) {
        Socket client = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {

            System.out.println("[Client] Client connecting to server...");
            client = new Socket("127.0.0.1", 5000);
            System.out.println("[Client] Client connected to server.");
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            Message message = new Message(senderID, recepientID, text);
            out.writeObject(message);
            out.flush();
            System.out.println("[Client] Message "+text+" sent to Server.");

            out.close();
            in.close();
            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }


}
