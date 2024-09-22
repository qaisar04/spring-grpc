package com.qaisar.helloworld.controller;

import com.qaisar.helloworld.client.GreetingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingClient greetingClient;

    @GetMapping("/hello")
    public ResponseEntity<String> greet(
            @RequestParam String name,
            @RequestParam List<String> hobbies
    ) {
        return ResponseEntity.ok(greetingClient.greet(name, hobbies));
    }
}
