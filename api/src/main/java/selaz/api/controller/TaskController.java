package selaz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import selaz.api.dto.TaskDTO;
import selaz.api.entity.task.Task;
import selaz.api.entity.task.TaskStatus;
import selaz.api.service.TaskService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        Task newTask = taskService.createTask(taskDTO);

        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping("/updateTask/{tasId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable("tasId") Long tasId, @RequestBody TaskDTO taskDTO
    ) throws Exception {
        Task attTask = taskService.updateTask(tasId, taskDTO);

        return new ResponseEntity<>(attTask, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask/{tasId}")
    public ResponseEntity<Task> deleteTask(@PathVariable("tasId") Long tasId)  throws Exception {
        taskService.deleteTask(tasId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllTasksByStatus/{tasStatus}")
    public ResponseEntity<List<Task>> getAllTasksByStatus(@PathVariable("tasStatus") TaskStatus tasStatus) {
        List<Task> tasks = taskService.getAllTasksByStatus(tasStatus);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
