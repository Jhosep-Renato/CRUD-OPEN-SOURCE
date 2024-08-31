package com.debiansenpai.crudopensource.model.repository;

import com.debiansenpai.crudopensource.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
