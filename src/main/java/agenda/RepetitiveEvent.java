package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    private ChronoUnit frequency;
    private List<LocalDate> listException = new LinkedList<>();
    
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
    
    @Override
    public boolean isInDay(LocalDate aDay) {
        boolean result = false;
        switch (this.getFrequency()) {
            case DAYS :
                if (this.isInDay(aDay) && aDay.isAfter(this.getStart().toLocalDate())) {
                    result = true;
                }
                break;
            case WEEKS :
                if (this.isInDay(aDay) && aDay.getDayOfWeek() == this.getStart().getDayOfWeek()) {
                    result = true;
                }
                break;
            case MONTHS :
                if (this.isInDay(aDay) && aDay.getDayOfMonth() == this.getStart().getDayOfMonth()) {
                    result = true;
                }
                break;
        }
        return result;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        if (!this.isInDay(date)) {
            listException.add(date);
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
