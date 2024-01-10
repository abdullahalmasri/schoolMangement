package org.example.school.services;

import org.example.school.dao.UserDetailsEntity;
import org.example.school.dto.UserDetailsDto;

import java.util.List;

public interface UserDetailsService {

    UserDetailsEntity addUserDetails(UserDetailsDto userDetailsDto);

    void removeUserDetails(UserDetailsDto userDetailsDto);

    List<UserDetailsDto> getUserDetails();

    UserDetailsEntity updateUserDetails(UserDetailsDto userDetailsDto);
}
