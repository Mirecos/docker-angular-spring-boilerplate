package com.seroter.azure_basic_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.seroter.azure_basic_app.models.Event;
import com.seroter.azure_basic_app.repository.EventRepository;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

	@Autowired
	private EventRepository eventRepository;

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