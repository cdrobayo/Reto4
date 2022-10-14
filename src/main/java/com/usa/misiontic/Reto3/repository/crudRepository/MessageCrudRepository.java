package com.usa.misiontic.Reto3.repository.crudRepository;

import com.usa.misiontic.Reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
