package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.entities.Workout;
import com.main.services.WorkoutServices;

@Controller
public class WorkoutController {
	
	@Autowired
	WorkoutServices workoutServices;
	
	@GetMapping("/workouts")
	public String workout(Model model) {
		model.addAttribute("workouts", workoutServices.getWorkouts());
		return "workouts";
	}
	
	@GetMapping("/newWorkout")
	public String newWorkout(Model model) {
		model.addAttribute("workout", new Workout());
		return "workout_new";
	}
	
	@PostMapping("/newWorkout")
	public String saveWorkout(@ModelAttribute Workout workout, Model model) {
		workoutServices.addWorkout(workout);
		return "redirect:/workouts";
	}
	
	@GetMapping("/updateWorkout")
	public String showWorkout(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("workout", workoutServices.getWorkoutById(id));
		return "workout_update";
	}
	
	@PostMapping("/updateWorkout")
	public String updateWorkout(@ModelAttribute Workout workout, Model model) {
		workoutServices.updateWorkout(workout);
		return "redirect:/workouts";
	}
	
	@GetMapping("/deleteWorkout")
	public String deleteWorkout(@RequestParam("id") Integer id) {
		workoutServices.deleteWorkout(id);
		return "redirect:/workout";
	}

}
