package com.driverbuddy.driverbuddy.controllers;

import com.driverbuddy.driverbuddy.entities.Entry;
import com.driverbuddy.driverbuddy.entities.Month;
import com.driverbuddy.driverbuddy.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
@CrossOrigin(origins = "*")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("")
    public ResponseEntity<List<Entry>> getAllEntries(
            @RequestParam(required = false, name = "month") Integer month,
            @RequestParam(required = false, name = "year") Integer year
    ) {
        if (month != null) {
            return ResponseEntity.ok(this.entryService.getAllWithMonth(year, month));
        }
        return ResponseEntity.ok(this.entryService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry){
        return ResponseEntity.ok(this.entryService.save(entry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable Integer id) {
        entryService.delete(id);
        return ResponseEntity.ok(id);
    }
}
