package com.usa.misiontic.Reto3.repository.crudRepository;

import com.usa.misiontic.Reto3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> countTotalReservationByClient();

    // SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo;
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    // SELECT  * FROM Reservation WHERE status=variable;
    public List<Reservation> findAllByStatus(String status);


}
