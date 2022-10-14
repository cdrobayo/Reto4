package com.usa.misiontic.Reto3.repository;


import com.usa.misiontic.Reto3.entities.Client;
import com.usa.misiontic.Reto3.entities.DTOs.CountClient;
import com.usa.misiontic.Reto3.entities.Reservation;
import com.usa.misiontic.Reto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation r){return reservationCrudRepository.save(r);}
    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }

    public List<CountClient> getClientesCaletos(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.countTotalReservationByClient();
        for(int i = 0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));

        }
        return respuesta;
    }

    public List<Reservation> getReservationsBetweenDates(Date a, Date b){
            return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

}
