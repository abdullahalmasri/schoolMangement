package org.example.school.dao.sql;

import org.example.school.dao.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<StudentEntity,Long> {
    StudentEntity findUserEntitiesByUsername(String name);
    StudentEntity findByUsernameAndPassword(String username, int password);


}
