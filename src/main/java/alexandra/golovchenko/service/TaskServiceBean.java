package alexandra.golovchenko.service;

import alexandra.golovchenko.entity.RequestEntity;
import alexandra.golovchenko.entity.TaskEntity;
import alexandra.golovchenko.entity.TaskWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class TaskServiceBean implements TaskService {
    @Autowired
    private TaskWorker taskWorker;

    public UUID addNewTask(UUID order) {
        return taskWorker.addNewTask(order);
    }

    @Nullable
    public List<TaskEntity> getTasks(RequestEntity requestEntity) {
        return taskWorker.getTasks(requestEntity);
    }
}
