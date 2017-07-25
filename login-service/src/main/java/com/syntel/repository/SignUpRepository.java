package com.syntel.repository;

import com.syntel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface SignUpRepository extends  JpaRepository <User, Long>{

}
