package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.DTO.MessageDTO;
import com.sprint3.backend.entity.PeriodOfTime;
import com.sprint3.backend.services.PeriodOfTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/period-time")
@CrossOrigin
public class PeriodOfTimeController {
    @Autowired
    private PeriodOfTimeService periodOfTimeService;

    // ---------------------- Vinh start ----------------------------
    @GetMapping("/get-list")
    public ResponseEntity<?> getList() {
        List<PeriodOfTime> periodOfTimeList;
        periodOfTimeList = this.periodOfTimeService.findAll();
        return periodOfTimeList.size() != 0
                ? ResponseEntity.ok(periodOfTimeList) : ResponseEntity.ok(new MessageDTO("get list fail"));
    }

    @GetMapping("/find-by-date/{date}")
    public ResponseEntity<?> findByDate(@PathVariable String date){
        PeriodOfTime periodOfTime = null;
        if (date != null){
            periodOfTime = this.periodOfTimeService.findByDate(date);
        }
        return periodOfTime != null ? ResponseEntity.ok(periodOfTime): ResponseEntity.ok(new MessageDTO("get fail"));
    }
    // ---------------------- Vinh end   ----------------------------
}
