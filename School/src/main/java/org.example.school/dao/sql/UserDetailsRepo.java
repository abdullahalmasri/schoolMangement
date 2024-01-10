package org.example.school.dao.sql;

import org.example.school.dao.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity,Long> {
}
