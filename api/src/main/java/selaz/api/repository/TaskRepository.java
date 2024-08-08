package selaz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selaz.api.entity.task.Task;
import selaz.api.entity.task.TaskStatus;


import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTasId(Long tasId);
    List<Task> findAllByTasStatus(TaskStatus tasStatus);
}
