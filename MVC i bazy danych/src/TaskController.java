import java.util.List;

public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    public boolean addTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            return false;
        }
        repository.save(task);
        return true;
    }

    public List<Task> loadTasks() {
        return repository.findAll();
    }
}
