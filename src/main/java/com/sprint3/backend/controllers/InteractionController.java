package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.services.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/interaction")
@CrossOrigin
public class InteractionController {
    // Din
    @Autowired
    InteractionService interactionService;
    @PostMapping("/create/{content}/{title}/{idAccount}")
    public ResponseEntity<Void> createInteraction(@PathVariable String content,@PathVariable String title,
                                                  @PathVariable Long idAccount){
        this.interactionService.createInteraction(content, title, idAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping({"/findAll/{idAccount}/{pageable}","/findAll/{idAccount}/{pageable}/{search}"})
    public ResponseEntity<Page<Interaction>> findAll(@PathVariable Long idAccount, @PathVariable int pageable,
                                                               @PathVariable Optional<String> search){
        return new ResponseEntity<>(this.interactionService.getAll(pageable, idAccount, search),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idInteraction}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long idInteraction){
        this.interactionService.deleteById(idInteraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{idInteraction}")
    public ResponseEntity<Interaction> findById(@PathVariable Long idInteraction){
        return new ResponseEntity<>(this.interactionService.searchById(idInteraction),HttpStatus.OK);
    }
    // Din End
}
