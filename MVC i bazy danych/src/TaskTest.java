import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    @Test
    void shouldCallRepositorySaveWhenTaskIsValid() {

        Task task = new Task(1, "Zadanie", "Opis zadania", false);

        taskController.addTask(task);

        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldHandleDatabaseErrorProperly() {
        Task task = new Task(1, "Zadanie", "Opis zadania", false);

        doThrow(new RuntimeException("Brak połączenia z bazą danych"))
                .when(taskRepository).save(task);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> taskController.addTask(task)
        );

        assertEquals("Brak połączenia z bazą danych", exception.getMessage());
        verify(taskRepository).save(task);
    }
}
