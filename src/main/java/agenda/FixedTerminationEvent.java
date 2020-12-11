package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {
    
    private LocalDate end;
    private long occurrences;

    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
         this.end = terminationInclusive;
        // TODO : implémenter cette méthode
       // throw new UnsupportedOperationException("Pas encore implémenté");

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.occurrences = numberOfOccurrences;
        // TODO : implémenter cette méthode
       // throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        return this.getStart().plus(this.getDuration().toSeconds(), ChronoUnit.SECONDS).toLocalDate();
        // TODO : implémenter cette méthode
       // throw new UnsupportedOperationException("Pas encore implémenté");   
    }

    public long getNumberOfOccurrences() {
        ChronoUnit frequence = this.getFrequency();
        switch (frequence) {
            case DAYS :
                this.occurrences = ChronoUnit.DAYS.between(this.getStart().toLocalDate(), this.getTerminationDate())+1;
                break;
            case WEEKS :
                this.occurrences = ChronoUnit.WEEKS.between(this.getStart().toLocalDate(), this.getTerminationDate())+1;
                break;
            case MONTHS :
                this.occurrences = ChronoUnit.MONTHS.between(this.getStart().toLocalDate(), this.getTerminationDate())+1;
                break;
        }
        return this.occurrences;
        // TODO : implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
        
}
