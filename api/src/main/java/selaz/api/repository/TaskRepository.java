package selaz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selaz.api.entity.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
