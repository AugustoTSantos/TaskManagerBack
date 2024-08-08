package selaz.api.repository;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import selaz.api.dto.TaskDTO;
import selaz.api.entity.task.Task;
import selaz.api.entity.task.TaskStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Should return task successfully")
    void findByTasIdCase1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date createdAt = dateFormat.parse("01-01-0001");
        Date dueDate = dateFormat.parse("02-02-0002");

        TaskDTO taskDTO = new TaskDTO(
                "test1",
                "test1",
                createdAt,
                dueDate,
                TaskStatus.CONCLUIDA
        );

        createTask(taskDTO);

        Optional<Task> result = this.taskRepository.findByTasId(1L);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get a non existent task")
    void findByTasIdCase2() {
        Optional<Task> result = this.taskRepository.findByTasId(1L);

        assertThat(result.isEmpty()).isTrue();
    }

    // Auxiliary Methods
    private Task createTask(TaskDTO taskDTO) {
        Task newTask = new Task(taskDTO);
        this.entityManager.persist(newTask);
        return newTask;
    }
}