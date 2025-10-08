package com.example.habit_tracker.controller;

import com.example.habit_tracker.model.Habit;
import com.example.habit_tracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habits")
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    @GetMapping
    public String getAllHabits(Model model) {
        model.addAttribute("habits", habitRepository.findAll());
        return "habits";
    }

    @GetMapping("/new")
    public String showHabitForm(Model model) {
        model.addAttribute("habit", new Habit());
        return "habit_form";
    }

    @PostMapping
    public String saveHabit(@ModelAttribute Habit habit) {
        habitRepository.save(habit);
        return "redirect:/habits";
    }

    @GetMapping("/edit/{id}")
    public String editHabit(@PathVariable Long id, Model model) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid habit Id: " + id));
        model.addAttribute("habit", habit);
        return "habit_form";
    }

    @PostMapping("/update")
    public String updateHabit(@ModelAttribute Habit habit) {
        habitRepository.save(habit);
        return "redirect:/habits";
    }

    @GetMapping("/delete/{id}")
    public String deleteHabit(@PathVariable Long id) {
        habitRepository.deleteById(id);
        return "redirect:/habits";
    }
}
