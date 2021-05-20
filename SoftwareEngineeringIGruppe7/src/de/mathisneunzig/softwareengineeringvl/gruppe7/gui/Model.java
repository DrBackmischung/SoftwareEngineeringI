package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {

    public Model() {
        support = new PropertyChangeSupport(this);
    }

    // Observable Properties
    private PropertyChangeSupport support;

    private Message message;

    public String getData(){

        return message.getText();
    }
    
    public boolean writeData(Message data)
    {
        support.firePropertyChange("message", message, data);
        message = data;
        return true;
    }

    //Observable Methods
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }


}
