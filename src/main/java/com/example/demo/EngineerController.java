package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EngineerController {

    private final EngineerRepository repository;

    public EngineerController(EngineerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/engineers")
    public List<EngineerStatus> getAllEngineers() {
        return repository.findAll();
    }

    @PostMapping("/api/upgrade")
    public EngineerStatus upgradeSalary(@RequestBody EngineerStatus myStatus) {
        EngineerStatus upgradedStatus = new EngineerStatus(
                myStatus.getName(),
                myStatus.getAge(),
                myStatus.getCurrentSalary() + 100,
                myStatus.getTargetSalary(),
                myStatus.getTargetSkill()
        );
        return repository.save(upgradedStatus);
    }
}