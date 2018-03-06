package com.mydayname.demo;

import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<Birthdate, Long> {

    Birthdate findById(long id);

}
