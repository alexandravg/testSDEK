package alexandra.golovchenko.service;

import alexandra.golovchenko.entity.RequestEntity;
import alexandra.golovchenko.entity.TaskEntity;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    UUID addNewTask(UUID order);
    List<TaskEntity> getTasks(RequestEntity requestEntity);
}
