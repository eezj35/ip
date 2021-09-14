package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    private Ui ui = new Ui();
    private static final int ERROR_UNKNOWN = 5;

    public Parser() {}

    /**
     * Checks if input is a done command.
     *
     * @param input User command.
     * @return Whether input is a done command.
     */
    public boolean isDoneCmd(String input) {
        return input.length() >= 4 && input.substring(0, 4).equals("done");
    }

    /**
     * Checks if input is a valid todo command.
     *
     * @param input User command.
     * @return Whether input is a valid todo command.
     */
    public boolean isValidTodo(String input) {
        return input.length() >= 4 && input.substring(0, 4).equals("todo");
    }

    /**
     * Retrieves description of todo command
     *
     * @param input User command.
     * @return Todo description.
     */
    public String getTodoDescription(String input) {
        return input.substring(5);
    }

    /**
     * Checks if input is a valid deadline command.
     *
     * @param input User command.
     * @return Whether input is a valid deadline command.
     */
    public boolean isValidDeadline(String input) {
        return input.length() >= 8 && input.substring(0, 8).equals("deadline");
    }

    /**
     * Retrieves description of deadline command
     *
     * @param input User command.
     * @return Deadline description.
     */
    public String getDeadlineDescription(String input) {
        return input.substring(9, input.indexOf("/") - 1);
    }

    /**
     * Checks if input is a valid event command.
     *
     * @param input User command.
     * @return Whether input is a valid event command.
     */
    public boolean isValidEvent(String input) {
        return input.length() >= 5 && input.substring(0, 5).equals("event");
    }

    /**
     * Retrieves description of event command
     *
     * @param input User command.
     * @return Event description.
     */
    public String getEventDescription(String input) {
        return input.substring(6, input.indexOf("/") - 1);
    }

    /**
     * Checks if input is a delete command.
     *
     * @param input User command.
     * @return Whether input is a delete command.
     */
    public boolean isDeleteCmd(String input) {
        return input.length() >= 6 && input.substring(0, 6).equals("delete");
    }

    public boolean isViewCmd(String input) {
        return input.length() >= 4 && input.substring(0,4).equals("view");
    }

    /**
     * Returns the time associated with the deadline or event task.
     *
     * @param input User command.
     * @return The deadline or event time of the task.
     */
    public String getTaskTime(String input){
        return input.substring(input.indexOf("/") + 4);
    }

    /**
     * Returns the index of the task to be deleted.
     *
     * @param input User command.
     * @return The delete index.
     */
    public int getDeleteIdx(String input) {
        return Integer.parseInt(input.substring(7)) - 1;
    }

    public int getDoneIdx(String input) {
        return Integer.parseInt(input.substring(5)) - 1;
    }

    public String getDateTime(String input) {
        return input.substring(5);
    }

    /**
     * Checks whether a done or delete command has a valid index.
     *
     * @param taskNum The index of the task to be marked as done or to be deleted.
     * @param size The size of the list.
     * @return Whether index is valid.
     */
    public boolean hasValidIdx(int taskNum, int size) {
        return taskNum < size && taskNum >= 0;
    }

    /**
     * Parses the event/deadline time of an input.
     *
     * @param time The event time/deadline.
     * @return A LocalDateTime object holding the time information.
     */
    public LocalDateTime parseLocalDateTime(String time) throws DateTimeParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        if (time.substring(0, 1).matches("[0-9]+")) {
            DateTimeFormatter anotherDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(time, anotherDtf);
        } else {
            return LocalDateTime.parse(time, dtf);
        }
    }


    public boolean isFindCmd(String input) {
        return input.length() >= 4 && input.substring(0, 4).equals("find");
    }
}