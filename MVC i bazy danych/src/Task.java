public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;


    public Task(int id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isDone() { return done; }

    public boolean isValid() {
        if (title == null || title.trim().length() < 3) {
            return false;
        }
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
