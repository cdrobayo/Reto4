package com.usa.misiontic.Reto3.controller;


import com.usa.misiontic.Reto3.entities.DTOs.CountClient;
import com.usa.misiontic.Reto3.entities.DTOs.CountStatus;
import com.usa.misiontic.Reto3.entities.Message;
import com.usa.misiontic.Reto3.entities.Reservation;
import com.usa.misiontic.Reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody  Reservation p){
        return reservationService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")  int id){
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public CountStatus getReportReservationsStatus() {
        return reservationService.getReservationsStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationBetweenDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo) {
        return reservationService.getReservationBetweenDates(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReportClientesCaletos() {
        return reservationService.getClientesCaletos();
    }

}
