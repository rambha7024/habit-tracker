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
    CommandLineRunner initDB(HabitRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Habit("Exercise", "Workout 30 mins daily"));
                repo.save(new Habit("Meditation", "Meditate 15 mins daily"));
            }
        };
    }
}
