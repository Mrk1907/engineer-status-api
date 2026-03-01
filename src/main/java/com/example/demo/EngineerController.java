package com.example.demo;

import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/engineers/{id}")
    public EngineerStatus updateEngineer(@PathVariable Long id, @RequestBody EngineerStatus updateData) {
        EngineerStatus existingEngineer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("指定されたIDのエンジニアが見つかりません"));

        EngineerStatus newData = new EngineerStatus(
                updateData.getName(),
                updateData.getAge(),
                updateData.getCurrentSalary(),
                updateData.getTargetSalary(),
                updateData.getTargetSkill()
        );
        newData.setId(id);
        return  repository.save(newData);
    }

    @DeleteMapping("/api/engineers/{id}")
    public String deleteEngineer(@PathVariable Long id) {
        repository.deleteById(id);
        return "ID: " + id + "のエンジニアデータをデータベースから完全に消去しました。";
    }
}