package com.sprint3.backend.controllers;

import com.sprint3.backend.services.PeriodOfTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/period-time")
@CrossOrigin
public class PeriodOfTimeController {
    @Autowired
    private PeriodOfTimeService periodOfTimeService;
    // ---------------------- Vinh start ----------------------------
//    @PostMapping("/add-new-period-time")
//    public Re
    // ---------------------- Vinh end   ----------------------------
}
