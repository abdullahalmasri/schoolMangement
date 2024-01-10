package org.example.school.services;

import org.example.school.dao.StudentEntity;
import org.example.school.dto.StudentDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    StudentDto getUserByName(String name);

    StudentEntity saveUser(StudentDto userDto);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    StudentEntity updateUser(StudentDto userDto);




}
