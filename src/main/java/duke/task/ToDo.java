package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the formatted string representation of the task.
     *
     * @return String representation of task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Prints out todo task.
     */
    @Override
    public void displayTask() {
        System.out.println("        " + toString());
    }
}
