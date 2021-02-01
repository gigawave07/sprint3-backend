package com.sprint3.backend.controllers;

import com.sprint3.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@CrossOrigin
public class NotificationController {
    // Din start
    @Autowired
    NotificationService notificationService;
    @PostMapping("/create/{idInteraction}/{idAccount}")
    public ResponseEntity<Void> createInteraction(@PathVariable Long idInteraction, @PathVariable Long idAccount){

        this.notificationService.createNotification(idInteraction, idAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Din end
}
