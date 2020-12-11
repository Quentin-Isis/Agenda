package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public List<Event> event = new ArrayList<>();
    
    public void addEvent(Event e) {
        Collections.addAll(event,e);
        
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> EinD = new ArrayList<>();
        for (int i=0; i<=event.size()-1; i++) {
          if (event.get(i).isInDay(day) == true) {
            Collections.addAll(EinD,event.get(i));
          }  
        }
        return EinD;
    }
}
