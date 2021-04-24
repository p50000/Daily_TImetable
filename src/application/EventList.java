package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;

/**
 * Created by on 04.03.2018.
 */
public class EventList {
    ObservableList<happenin> events = FXCollections.observableArrayList();

    boolean add(happenin h) {
        boolean succesfullyAdded = true;
        events.add(h);
        int i = events.size() - 1;
        while (i > 0 && events.get(i).compareBeg(events.get(i - 1)) < 0) {
            happenin b = events.get(i);
            events.set(i, events.get(i - 1));
            events.set(i - 1, b);
            i--;
        }
        if (i < events.size() - 1 && i > 0) {
            if (events.get(i).compareBegEnd(events.get(i + 1)) > 0 && events.get(i - 1).compareBegEnd(events.get(i)) > 0) {
                succesfullyAdded = false;
                events.remove(i);
            }
        } else if (i < events.size() - 1) {
            if (events.get(i).compareBegEnd(events.get(i + 1)) > 0) {
                succesfullyAdded = false;
                events.remove(i);
            }
        } else if (i > 0) {
            if (events.get(i - 1).compareBegEnd(events.get(i)) > 0) {
                succesfullyAdded = false;
                events.remove(i);
            }
        }
        return succesfullyAdded;

    }



}
