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

            client = new Socket("127.0.0.1", 8888);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            Message message = new Message(senderID, recepientID, text);
            out.writeObject(message);
            out.flush();

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
