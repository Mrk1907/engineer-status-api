package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EngineerStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private int currentSalary;
    private int targetSalary;
    private String targetSkill;

    // JPA必須の空コンストラクタ
    public EngineerStatus() {}

    public EngineerStatus(String name, int age, int currentSalary, int targetSalary, String targetSkill) {
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.targetSalary = targetSalary;
        this.targetSkill = targetSkill;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getCurrentSalary() { return currentSalary; }
    public int getTargetSalary() { return targetSalary; }
    public String getTargetSkill() { return targetSkill; }
}