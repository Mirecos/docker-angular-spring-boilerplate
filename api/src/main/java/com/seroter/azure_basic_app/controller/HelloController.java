package com.seroter.azure_basic_app.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.seroter.azure_basic_app.models.Event;
import com.seroter.azure_basic_app.models.User;
import com.seroter.azure_basic_app.repository.EventRepository;
import com.seroter.azure_basic_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
		Optional<User> userOpt = userRepository.findAll().stream()
			.filter(u -> u.getEmail().equals(loginRequest.getEmail()))
			.findFirst();
		if (userOpt.isPresent()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(loginRequest.getPassword(), userOpt.get().getPassword())) {
				// Return user info without password
				User user = userOpt.get();
				user.setPassword(null);
				return ResponseEntity.ok(user);
			}
		}
		return ResponseEntity.status(401).body("Invalid email or password");
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// List all events
	@GetMapping("/list")
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	// Create a new event
	@PostMapping("/add")
	public Event createEvent(@RequestBody Event event) {
		// Optionally set the date if not provided
		if (event.getDate() == null) {
			event.setDate(LocalDateTime.now());
		}
		return eventRepository.save(event);
	}

}