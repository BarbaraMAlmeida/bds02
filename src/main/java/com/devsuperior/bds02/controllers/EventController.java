package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "events")
public class EventController {

    @Autowired
    private EventService service;
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable  Long id, @RequestBody EventDTO eventDTO) {
        try {
            eventDTO = service.update(id, eventDTO);
            return ResponseEntity.ok().body(eventDTO);
        }
        catch (Exception error) {
            return ResponseEntity.notFound().build();
        }

    }
}
