package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    private ChronoUnit frequency;
    
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
       
    }
    
    public boolean isInDay(LocalDate aDay) {
        int n=0;
        long f= this.frequency.getDuration().toSeconds();
        LocalDateTime start;
        boolean result = true;
        while(n>0){
           long duree = this.getDuration().toSeconds();
           start = this.getStart().plus(f,ChronoUnit.SECONDS);
           
            if (!aDay.isBefore(start.toLocalDate()) && !aDay.isAfter(this.getStart().plus(duree, ChronoUnit.SECONDS).toLocalDate())){
                result = true;
            }
            else{
                result = false;
            }
            n+=1;
        }
        
        return result;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        try {
            this.isInDay(date);
        } catch (Exception e) {
            System.out.println("Cette événement n'a pas lieu pour ce jour.");
        }
 
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;
            
    }

}
