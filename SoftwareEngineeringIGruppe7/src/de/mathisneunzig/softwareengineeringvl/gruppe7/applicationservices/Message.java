package de.mathisneunzig.softwareengineeringvl.gruppe7.applicationservices;

public class Message {
    private int senderID;
    private int recipientID;
    private String text;

    public Message(int senderID, int recipientID, String text) {
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.text = text;
    }

    public int getSenderID() {
        return senderID;
    }

    public String getText() {
        return text;
    }


}
