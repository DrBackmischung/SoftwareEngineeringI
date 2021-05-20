package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MessageListener implements PropertyChangeListener {

    private Controller controller;

    public MessageListener(Controller controller) {
        this.controller = controller;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        controller.setViewLabel(((Message)evt.getNewValue()).getText());
    }

 
}