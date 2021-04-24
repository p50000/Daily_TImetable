package application;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.ObservableList;

@XmlRootElement(name = "events")
class EventListWrapper {

    private List <happenin> events;

    @XmlElement(name = "event")
    public ObservableList <happenin> getEvents() {
        return (ObservableList<happenin>) events;
    }

    public void setEvents(List<happenin> events) {
        this.events = events;
    }
}
