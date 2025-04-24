package com.prueba.tecnicantt.Repository;

import com.prueba.tecnicantt.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Query(value =
            "SELECT u.id,u.firstname,u.lastname,u.phone,u.birthdate,u.role_id,u.identitynumber,u.address " +
                    "FROM users u " +
                    "WHERE u.role_id = :roleId and u.status_id=1 order by u.id desc",
            nativeQuery = true)
    List<Map> findByRoleId(@Param("roleId") Integer roleId);
}
