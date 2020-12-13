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
        if (listException.contains(aDay)) {
            return false;
        }
        LocalDateTime debutPresumee = this.getStart();
        LocalDateTime finPresumee = debutPresumee.plus(this.getDuration());
        while (aDay.isAfter(finPresumee.toLocalDate()) && aDay.plus(1, frequency).isAfter(debutPresumee.toLocalDate())) {
            switch (this.frequency) {
            case DAYS :
                debutPresumee = debutPresumee.plus(1, ChronoUnit.DAYS);
                finPresumee = debutPresumee.plus(this.getDuration());
                break;
            case WEEKS :
               debutPresumee = debutPresumee.plus(1, ChronoUnit.WEEKS);
                finPresumee = debutPresumee.plus(this.getDuration());
                
                break;
            case MONTHS :
                debutPresumee = debutPresumee.plus(1, ChronoUnit.MONTHS);
                finPresumee = debutPresumee.plus(this.getDuration());
                break;
            }
        }
        if(aDay.isEqual(debutPresumee.toLocalDate()) || aDay.isEqual(finPresumee.toLocalDate())){
            return true;
        }
        else if (aDay.isBefore(finPresumee.toLocalDate()) && aDay.isAfter(debutPresumee.toLocalDate())) {
            return true;
        }
        return false;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        listException.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;
            
    }

}
