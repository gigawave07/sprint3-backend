package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Instruction;
import com.sprint3.backend.services.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/instruction")
@CrossOrigin
public class InstructionController {
    @Autowired
    private InstructionService instructionService;

    // -------------------- Vinh start ----------------------------

    @GetMapping("/get-instruction-list/{startDate}/{endDate}")
    public ResponseEntity<?> getInstructionList(@PathVariable String startDate, @PathVariable String endDate) {
        List<Instruction> instructionList;
        instructionList = this.instructionService.findAllByPeriod(LocalDate.parse(startDate), LocalDate.parse(endDate));
        return instructionList.size() != 0 ? ResponseEntity.ok(instructionList) : ResponseEntity.ok("get list fail");
    }

    @PostMapping("/upload-instruction")
    public ResponseEntity<?> uploadInstruction(@RequestBody Instruction instruction) {
        String uploadStatus = "upload fail";
        if (instruction.getDescription() != null && instruction.getFileName() != null) {
            this.instructionService.save(instruction);
            uploadStatus = "upload success";
        }
        return ResponseEntity.ok(uploadStatus);
    }

    @DeleteMapping("/delete-instruction/{id}")
    public ResponseEntity<?> deleteInstruction(@PathVariable Long id) {

        String uploadStatus = "delete fail";
        if (id != null) {
            this.instructionService.delete(id);
            uploadStatus = "delete success";
        }
        return ResponseEntity.ok(uploadStatus);
    }
    // -------------------- Vinh end ------------------------------
}
