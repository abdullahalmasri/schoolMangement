package org.example.school.dto;

import org.example.school.dao.ClassAndYearEntity;
import org.example.school.dao.Grade;
import org.example.school.dao.Role;

import java.util.List;

public class UserDetailsDto {
    private String firstname;

    private String lastname;

    private Role role;

    private String email;

    private String photo;

    private Long age;

    private Grade grade;

    private long dateOfschool;

    private List<ClassAndYearDto> classesSubjects;

    private String classRightNow;

    public UserDetailsDto() {
    }

    public UserDetailsDto(String firstname, String lastname, Role role, String email, String photo, Long age, Grade grade, long dateOfschool, List<ClassAndYearDto> classesSubjects, String classRightNow) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.email = email;
        this.photo = photo;
        this.age = age;
        this.grade = grade;
        this.dateOfschool = dateOfschool;
        this.classesSubjects = classesSubjects;
        this.classRightNow = classRightNow;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public long getDateOfschool() {
        return dateOfschool;
    }

    public void setDateOfschool(long dateOfschool) {
        this.dateOfschool = dateOfschool;
    }

    public List<ClassAndYearDto> getClassesSubjects() {
        return classesSubjects;
    }

    public void setClassesSubjects(List<ClassAndYearDto> classesSubjects) {
        this.classesSubjects = classesSubjects;
    }

    public String getClassRightNow() {
        return classRightNow;
    }

    public void setClassRightNow(String classRightNow) {
        this.classRightNow = classRightNow;
    }
}
