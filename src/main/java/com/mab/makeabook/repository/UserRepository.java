package com.mab.makeabook.repository;

import com.mab.makeabook.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);
    List<User> findAll();
}