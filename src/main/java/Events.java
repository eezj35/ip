public class Events extends Task{
    protected String at;

    public Events(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public void displayTask() {
        System.out.println("        " + toString());
    }
}
