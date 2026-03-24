package tech.buildrun.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ApiController {


    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping (path = "/tasks")
    ResponseEntity<String> ListTasks() throws Exception {

        String json = objectMapper.writeValueAsString(tasks);
        return ResponseEntity.ok(json);

    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<Void> createTask(@RequestBody String task) {
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (path = "/tasks")
    public ResponseEntity<Void>createTasks(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }



}
