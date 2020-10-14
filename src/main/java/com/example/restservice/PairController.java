package com.example.restservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@RestController
public class PairController {

    private ParticipantListBuilder participantListBuilder;
    private Map<String, String> pairs;

    PairController(ParticipantListBuilder participantListBuilder) {
        this.participantListBuilder = participantListBuilder;
    }

    @GetMapping("/pair/{name}")
    public String getPair(@PathVariable String name) {
        return "Your pair is: " + pairs.get(name);
    }

    @PostMapping("/pairs")
    public Map<String, String> createPairs(@RequestBody Map<String, String> participants) {
        System.out.println("Executing Post.");
        pairs = participantListBuilder.buildPairs(participants);
        return pairs;
    }
}
