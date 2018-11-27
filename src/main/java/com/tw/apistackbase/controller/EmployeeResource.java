package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = "/employees")
    public ResponseEntity<String> getAll() {

        return ResponseEntity.ok("Hello:");
    }
}
