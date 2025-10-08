package com.example.habit_tracker.controller;

import com.example.habit_tracker.model.Habit;
import com.example.habit_tracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitRestController {

    @Autowired
    private HabitRepository repo;

    @GetMapping
    public List<Habit> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Habit addHabit(@RequestBody Habit habit) {
        return repo.save(habit);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody Habit updatedHabit) {
        Habit habit = repo.findById(id).orElseThrow();
        habit.setName(updatedHabit.getName());
        habit.setDescription(updatedHabit.getDescription());
        habit.setCompleted(updatedHabit.isCompleted());
        return repo.save(habit);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
