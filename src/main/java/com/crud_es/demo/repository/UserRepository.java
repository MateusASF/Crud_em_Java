package com.crud_es.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.crud_es.demo.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long> {

}
