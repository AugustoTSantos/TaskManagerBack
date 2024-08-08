package selaz.api.dto;

import selaz.api.entity.task.TaskStatus;

import java.util.Date;

public record TaskDTO(
        String tasTitle, String tasDescription, Date tasCreatedAt, Date tasDueDate, TaskStatus tasStatus
) {
}
