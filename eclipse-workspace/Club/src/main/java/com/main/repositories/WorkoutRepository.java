package com.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
