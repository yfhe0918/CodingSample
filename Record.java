/**
 * The Record class creates a Record object and implements the method for
 * modifying the object
 * 
 * @author Yifan He
 * @version 1.0
 * @since 02-14-2016
 */

public class Record implements Comparable<Record> {

    private String process;
    private long deadline;
    private long duration;

    /**
     * constructor to create a new record given the name of the process,
     * deadline and duration
     * 
     * @param process
     * @param deadline
     * @param duration
     */
    Record(String process, long deadline, long duration) {
        this.process = process;
        this.deadline = deadline;
        this.duration = duration;
    }

    /**
     * constructor to create a new record from the existing record and new
     * duration
     * 
     * @param r
     * @param duration
     */
    Record(Record r, long duration) {
        this.process = r.process;
        this.deadline = r.deadline;
        this.duration = duration;
    }

    /**
     * GetDuration gets the duration of Record
     * 
     * @return the duration of Record
     */
    public long GetDuration() {
        return duration;
    }

    /**
     * toString converts the record to string
     * 
     * @return the string representation of the Record
     */
    public String toString() {
        return process + " with deadline " 
    + deadline + " and duration " + duration;
    }

    /**
     * toString converts the record to string
     * 
     * @param current_time
     *            the current time of the timeline
     * @return the string representation of the Record
     */
    public String toString(long current_time) {
        if (current_time > deadline)
            return process + " (late)";
        return process;
    }

    /**
     * compareTo compares this Record with a given Record
     * 
     * @return a negative integer, zero, or a positive integer as the deadline
     *         of this Record is less than, equal to, or greater than the
     *         specified Record.
     */
    @Override
    public int compareTo(Record o) {
        long l = this.deadline - o.deadline;
        int i = (int) l;
        return i;
    }
}
