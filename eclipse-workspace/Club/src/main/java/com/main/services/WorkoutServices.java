package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Workout;
import com.main.repositories.WorkoutRepository;

@Service
public class WorkoutServices {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	public List<Workout> getWorkouts() {
		return workoutRepository.findAll();
	}
	
	public Workout addWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}
	
	public Workout getWorkoutById(Integer id) {
		return workoutRepository.findById(id).orElse(null);
	}
	
	public Workout updateWorkout(Workout workout) {
		Workout old = this.getWorkoutById(workout.getId());
		old.setName(workout.getName());
		old.setDate(workout.getDate());
		old.setLocation(workout.getLocation());
		old.setPlaces(workout.getPlaces());
		workoutRepository.save(old);
		return old;
	}
	
	public void deleteWorkout(Integer id) {
		workoutRepository.deleteById(id);
	}

}
