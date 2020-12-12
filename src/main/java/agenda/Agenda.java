package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    
     /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> Title = new ArrayList<>();
        for (int i=0; i<=event.size()-1; i++) {
          if (event.get(i).getTitle() == title) {
            Collections.addAll(Title,event.get(i));
          }  
        }
        return Title;
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean result = true; 
        long duree = e.getDuration().toSeconds();
        for (int i=0; i<=event.size()-1; i++) {
          if (!event.get(i).getStart().toLocalDate().isBefore(e.getStart().toLocalDate()) && !event.get(i).getStart().toLocalDate().isAfter(e.getStart().plus(duree, ChronoUnit.SECONDS).toLocalDate())){
              result = false;
          }
        }
        return result;
        
    }
}
