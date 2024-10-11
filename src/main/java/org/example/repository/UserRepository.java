package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.example.entity.User;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from User s order by s.id asc ", nativeQuery = true)
    List<User> getAllUsers();
}

