package com.example.habit_tracker;

import com.example.habit_tracker.model.Habit;
import com.example.habit_tracker.repository.HabitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HabitTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitTrackerApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(HabitRepository habitRepository) {
        return (args) -> {
            habitRepository.save(new Habit("Exercise", "Workout 30 mins daily"));
            habitRepository.save(new Habit("Meditation", "Meditate 15 mins daily"));
            habitRepository.save(new Habit("Reading", "Read 20 pages"));
        };
    }
}
