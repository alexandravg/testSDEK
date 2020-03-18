package alexandra.golovchenko.controller;

import alexandra.golovchenko.entity.RequestEntity;
import alexandra.golovchenko.entity.TaskEntity;
import alexandra.golovchenko.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/late/{id}", method = RequestMethod.POST)
    public ResponseEntity<UUID> lateDelivery(@PathVariable UUID id) {
        return new ResponseEntity<>(taskService.addNewTask(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getTasks", method = RequestMethod.GET, produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<List<TaskEntity>> getTasks(@RequestBody RequestEntity requestEntity) {
        List<TaskEntity> answer = taskService.getTasks(requestEntity);
        if (answer != null && !answer.isEmpty()) {
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
