package com.crick.apis.controllers;

import com.crick.apis.Service.MatchServiceImpl;
import com.crick.apis.entities.Match;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
@CrossOrigin("*")
public class MatchController {


    private final MatchServiceImpl matchService;

    public MatchController(MatchServiceImpl matchService) {
        this.matchService = matchService;
    }

    // get live matches
    @GetMapping("/live")
    public ResponseEntity<List<Match>> getLiveMatches(){
        return new ResponseEntity<>(this.matchService.getLiveMatches(), HttpStatus.OK);
    }

    // get all matches
    @GetMapping()
    public ResponseEntity<List<Match>> getAllMatches(){
        return new ResponseEntity<>(this.matchService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/point-table")
    public ResponseEntity<?> getPointtable(){
        return new ResponseEntity<>(this.matchService.getScoreTable(), HttpStatus.OK);
    }


}
