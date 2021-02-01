package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.ThesisDTO;
import com.sprint3.backend.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thesis")
@CrossOrigin
public class ThesisController {
    @Autowired
    ThesisService thesisService;

    /**
     *Lành start
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Thesis>> getAllThesis(
            @RequestParam(name = "statement", defaultValue = "") String statement,
            @RequestParam(name = "amount", defaultValue = "") String amount,
            @RequestParam("page") int page) {
        Specification<Thesis> search = thesisService.getFilter(statement, amount);
        Page<Thesis> thesisPage;
        if (search != null) {
            thesisPage = thesisService.findThesisByCriteria(search, page);
        } else {
            thesisPage = thesisService.findAll(page);
        }
        if (thesisPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(thesisPage);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Thesis>> getThesisList() {
        List<Thesis> thesisList;
        thesisList = thesisService.findAllThesis();
        return ResponseEntity.ok(thesisList);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Thesis>> addNewThesis(@RequestBody Thesis thesis) {
        this.thesisService.createNewThesis(thesis);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<List<Thesis>> editThesis(@PathVariable Long id, @RequestBody ThesisDTO thesisDTO) {
        Thesis thesis = thesisService.findById(id);
        if (thesis == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            thesis.setStatement(thesisDTO.getStatement().trim());
            thesis.setAmount(thesisDTO.getAmount());
            thesis.setDescription(thesisDTO.getDescription().trim());
            thesisService.updateThesis(thesis);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Thesis> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(thesisService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteThesis(@PathVariable Long id) {
        MessageDTO messageDTO = this.thesisService.deleteByID(id);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    /**
     * Lành end
     */
    // Create by: Đạt
    @GetMapping("/list2")
    public ResponseEntity<?> getListThesis() {
        List<Thesis> listThesis = this.thesisService.findAllThesis();
        return new ResponseEntity<>(listThesis, HttpStatus.OK);
    }
}
