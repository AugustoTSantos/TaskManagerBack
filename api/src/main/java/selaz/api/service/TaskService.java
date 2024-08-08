package selaz.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import selaz.api.dto.TaskDTO;
import selaz.api.entity.task.Task;
import selaz.api.entity.task.TaskStatus;
import selaz.api.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //Crud Start
    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }

    // Auxiliary Method
    public void saveTask(Task task){
        this.taskRepository.save(task);
    }

    public Task createTask(TaskDTO taskDTO){
        Task newTask = new Task(taskDTO);

        this.saveTask(newTask);

        return newTask;
    }

    // Auxiliary Method
    public Task getTaskById(Long tasId) throws Exception{
        return this.taskRepository.findByTasId(tasId).orElseThrow(() -> new Exception("Task não encontrada"));
    }

    public Task updateTask(Long tasId, TaskDTO taskDTO) throws Exception{
        Task task = this.getTaskById(tasId);

        task.setTasTitle(taskDTO.tasTitle());
        task.setTasDescription(taskDTO.tasDescription());
        task.setTasCreatedAt(taskDTO.tasCreatedAt());
        task.setTasDueDate(taskDTO.tasDueDate());
        task.setTasStatus(taskDTO.tasStatus());

        return this.taskRepository.save(task);
    }

    public void deleteTask(Long tasId) throws Exception{
        Task task = this.getTaskById(tasId);

        this.taskRepository.delete(task);
    }
    //Crud End

    public List<Task> getAllTasksByStatus(TaskStatus tasStatus) {
        return this.taskRepository.findAllByTasStatus(tasStatus);
    }


}
