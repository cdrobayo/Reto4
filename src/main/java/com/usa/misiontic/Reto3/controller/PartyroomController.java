package com.usa.misiontic.Reto3.controller;


import com.usa.misiontic.Reto3.entities.Partyroom;
import com.usa.misiontic.Reto3.service.PartyroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Partyroom")
public class PartyroomController {

    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> getAll(){
        return partyroomService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody  Partyroom p){
        return partyroomService.save(p);
    }
}
