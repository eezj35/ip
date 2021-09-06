package duke.task;

import duke.Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected String at;
    protected LocalDateTime localDateTime;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Returns the event's date and time
     *
     * @return The event date and time.
     */
    public String getAt() {
        assert at != null : "at variable should not be null";
        return at;
    }

    /**
     * Returns the formatted string representation of the task.
     *
     * @return String representation of task.
     */
    @Override
    public String toString() {
        assert at != null : "at variable should not be null";
        localDateTime = new Parser().parseLocalDateTime(at);
        return "[E]" + super.toString() + " (at: " + localDateTime.format(dateTimeFormatter) + ")";
    }
}
