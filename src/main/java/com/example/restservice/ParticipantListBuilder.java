package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParticipantListBuilder {
    public Map<String, String> buildPairs(List<String> participants) {
        Map<String, String> pairs = new HashMap<String, String>();
        for(String participant : participants) {
            pairs.put(participant, null);
        }

        for(String giver : pairs.keySet()) {
            int randIndex = (int)(Math.random() * participants.size());
            String receiver = participants.get(randIndex);
            if(pairs.get(giver) == null && !giver.equals(receiver)) {
                pairs.put(giver, receiver);
            } else if(randIndex < participants.size() - 1) {
                receiver = participants.get(randIndex + 1);
                pairs.put(giver, receiver);
            } else {
                receiver = participants.get(randIndex - 1);
                pairs.put(giver, receiver);
            }

            participants.remove(receiver);
        }

        return pairs;
    }

}