package com.example.habit_tracker.controller;

import com.example.habit_tracker.model.Habit;
import com.example.habit_tracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    // Display all habits (main page)
    @GetMapping({"/", "/habits"})
    public String getHabits(Model model) {
        List<Habit> habits = habitRepository.findAll();
        model.addAttribute("habits", habits);

        // Calculate counts and percentage for the chart and summary
        long completedCount = habits.stream().filter(Habit::isCompleted).count();
        long totalCount = habits.size();
        double progressPercentage = totalCount > 0 ? Math.round((completedCount / (double) totalCount) * 100) : 0;

        model.addAttribute("completedCount", completedCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("progressPercentage", progressPercentage);  // NEW: Pass pre-calculated percentage

        return "habits"; // Renders habits.html
    }

    // Show form to add new habit
    @GetMapping("/habit/add")
    public String showAddForm(Model model) {
        Habit newHabit = new Habit();
        newHabit.setStartDate(LocalDate.now());  // Default to today
        newHabit.setCompleted(false);  // Default to incomplete
        model.addAttribute("habit", newHabit);
        return "habit_form";
    }

    // Handle form submission to add habit
    @PostMapping("/habit/add")
    public String addHabit(@ModelAttribute Habit habit) {
        habitRepository.save(habit);
        return "redirect:/habits";
    }

    // Show form to edit existing habit
    @GetMapping("/habit/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid habit Id: " + id));
        model.addAttribute("habit", habit);
        return "habit_form";
    }

    // Handle habit edit
    @PostMapping("/habit/edit/{id}")
    public String editHabit(@PathVariable Long id, @ModelAttribute Habit habit) {
        habit.setId(id);
        habitRepository.save(habit);
        return "redirect:/habits";
    }

    // Delete habit
    @GetMapping("/habit/delete/{id}")
    public String deleteHabit(@PathVariable Long id) {
        habitRepository.deleteById(id);
        return "redirect:/habits";
    }

    // Optional: Toggle habit completion
    @PostMapping("/habit/toggle/{id}")
    public String toggleHabit(@PathVariable Long id, @RequestParam boolean completed) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid habit Id: " + id));
        habit.setCompleted(completed);
        habitRepository.save(habit);
        return "redirect:/habits";
    }
}
