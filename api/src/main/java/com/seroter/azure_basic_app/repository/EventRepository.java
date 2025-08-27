package com.seroter.azure_basic_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seroter.azure_basic_app.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
