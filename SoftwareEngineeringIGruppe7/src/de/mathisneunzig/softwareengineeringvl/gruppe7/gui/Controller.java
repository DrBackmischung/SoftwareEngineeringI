package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

public class Controller {
    private boolean receiving = false;
    private Server server;
    private Model model;
    private Form view;
    private MessageListener listener;

    public Controller() {
        model = new Model();
    }

    public void startApplication() {
        view = new Form(this);
        view.setVisible(true);
        listener = new MessageListener(this);
    }
    
    public void receiveMessage() {
        receiving = true;
        try {
            server = new Server();
            model.addPropertyChangeListener(listener);
            model.writeData(server.getMessage());
            receiving = false;
            model.removePropertyChangeListener(listener);
        } catch (Exception er) {
            receiving = false;
        }
    }
    
    public boolean sendMessage(String message) {
        try {
            if(!receiving) {
                Client client = new Client();
                client.send(43, 62, message);
            }
            else
            {
                return false;
            }

            return true;

        } catch (Exception er) {
            return false;
        }
    }

    public void setViewLabel(String text)
    {
        view.setMyLabel(text);
    }


}
