package selaz.api.dto;

import selaz.api.entity.task.Task;
import selaz.api.entity.user.User;

public record AssociationDTO(User assUseId, Task assTasId) {
}
