package com.example.habit_tracker.repository;

import com.example.habit_tracker.model.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {
}
