package org.example.school.services;

import org.example.school.dao.StudentEntity;
import org.example.school.dao.UserDetailsEntity;
import org.example.school.dao.sql.UserDetailsRepo;
import org.example.school.dao.sql.UserRepo;
import org.example.school.dto.StudentDto;
import org.example.school.dto.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService,UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDetailsRepo userDetailsRepo;
    @Override
    public StudentDto getUserByName(String name) {
        return null;
    }

    @Override
    public StudentEntity saveUser(StudentDto userDto) {
        StudentEntity userEntity = new StudentEntity();
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setRole(userDto.getRole());
        return userRepo.save(userEntity);

//        StudentEntity newUserEntity = userRepo.findById(userEntity.getId()).orElse(null);
//        if (newUserEntity != null) {
//            StudentDto userDto1 = new StudentDto();
//            userDto1.setUsername(newUserEntity.getUsername());
//            userDto1.setPassword(newUserEntity.getPassword());
//            userDto1.setName(newUserEntity.getName());
////            userDto1.setId(newUserEntity.getId());
//            return userDto;
//        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentEntity userEntity = userRepo.findUserEntitiesByUsername(username);

        StudentDto user = new StudentDto();
//        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());


        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return String.valueOf(user.getPassword());
            }

            @Override
            public String getUsername() {
                return user.getName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        return userDetails;
    }

    @Override
    public StudentEntity updateUser(StudentDto userDto) {
        return null;
    }


    @Override
    public UserDetailsEntity addUserDetails(UserDetailsDto userDetailsDto) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setFirstname(userDetailsDto.getFirstname());
        userDetails.setLastname(userDetailsDto.getLastname());
        userDetails.setEmail(userDetailsDto.getEmail());
        userDetails.setAge(userDetailsDto.getAge());
        userDetails.setRole(userDetailsDto.getRole());
        userDetails.setClassRightNow(userDetailsDto.getClassRightNow());
        userDetails.setClassesSubjects(userDetailsDto.getClassesSubjects());
        userDetails.setDateOfschool(userDetailsDto.getDateOfschool());
        userDetails.setGrade(userDetailsDto.getGrade());
        userDetails.setPhoto(userDetailsDto.getPhoto());

        return userDetailsRepo.save(userDetails);
    }

    @Override
    public void removeUserDetails(UserDetailsDto userDetailsDto) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setFirstname(userDetailsDto.getFirstname());
        userDetails.setLastname(userDetailsDto.getLastname());
        userDetails.setEmail(userDetailsDto.getEmail());
        userDetails.setAge(userDetailsDto.getAge());
        userDetails.setRole(userDetailsDto.getRole());
        userDetails.setClassRightNow(userDetailsDto.getClassRightNow());
        userDetails.setClassesSubjects(userDetailsDto.getClassesSubjects());
        userDetails.setDateOfschool(userDetailsDto.getDateOfschool());
        userDetails.setGrade(userDetailsDto.getGrade());
        userDetails.setPhoto(userDetailsDto.getPhoto());
        userDetailsRepo.delete(userDetails);
    }

    @Override
    public List<UserDetailsDto> getUserDetails() {
        return userDetailsRepo.findAll().stream()
                .map(userDetailsEntity -> {
                    UserDetailsDto userDetails = new UserDetailsDto();
                    userDetails.setFirstname(userDetailsEntity.getFirstname());
                    userDetails.setLastname(userDetailsEntity.getLastname());
                    userDetails.setEmail(userDetailsEntity.getEmail());
                    userDetails.setAge(userDetailsEntity.getAge());
                    userDetails.setRole(userDetailsEntity.getRole());
                    userDetails.setClassRightNow(userDetailsEntity.getClassRightNow());
                    userDetails.setClassesSubjects(userDetailsEntity.getClassesSubjects());
                    userDetails.setDateOfschool(userDetailsEntity.getDateOfschool());
                    userDetails.setGrade(userDetailsEntity.getGrade());
                    userDetails.setPhoto(userDetailsEntity.getPhoto());
                    return userDetails;
                }).collect(Collectors.toList());

    }

    @Override
    public UserDetailsEntity updateUserDetails(UserDetailsDto userDetailsDto) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setFirstname(userDetailsDto.getFirstname());
        userDetails.setLastname(userDetailsDto.getLastname());
        userDetails.setEmail(userDetailsDto.getEmail());
        userDetails.setAge(userDetailsDto.getAge());
        userDetails.setRole(userDetailsDto.getRole());
        userDetails.setClassRightNow(userDetailsDto.getClassRightNow());
        userDetails.setClassesSubjects(userDetailsDto.getClassesSubjects());
        userDetails.setDateOfschool(userDetailsDto.getDateOfschool());
        userDetails.setGrade(userDetailsDto.getGrade());
        userDetails.setPhoto(userDetailsDto.getPhoto());

        return userDetailsRepo.save(userDetails);
    }
}
