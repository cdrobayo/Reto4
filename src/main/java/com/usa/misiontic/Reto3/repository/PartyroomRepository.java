package com.usa.misiontic.Reto3.repository;

import com.usa.misiontic.Reto3.entities.Partyroom;
import com.usa.misiontic.Reto3.repository.crudRepository.PartyroomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PartyroomRepository {
    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    public List<Partyroom> getAll(){
        return (List<Partyroom>) partyroomCrudRepository.findAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomCrudRepository.findById(id);
    }
    public Partyroom save(Partyroom p){
        return partyroomCrudRepository.save(p);
    }
    public void delete(Partyroom p){
        partyroomCrudRepository.delete(p);
    }

}
