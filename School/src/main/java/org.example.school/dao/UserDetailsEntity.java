package org.example.school.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tb_user_details")
@AllArgsConstructor
@EqualsAndHashCode
public class UserDetailsEntity {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_sequence")
    @Column(name = "user_detail_id", nullable = false, unique = true)
    private long id;

    @Column(name = "first_name",length = 32,unique = true)
    private String firstname;
    @Column(name = "last_name",length = 32,unique = true)
    private String lastname;
    @Column(name = "role",length = 32)
    private Role role;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "profile_pic")
    private String photo;
    @Column(name = "age_user")
    private Long age;
    @Column(name = "grade")
    private Grade grade;
    @Column(name = "first_time_to_school")
    private long dateOfschool;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userDetailsEntity")
    private List<ClassAndYearEntity> classesSubjects;
    @Column(name = "class_now")
    private String classRightNow;


    public UserDetailsEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    public String getClassRightNow() {
        return classRightNow;
    }

    public void setClassRightNow(String classRightNow) {
        this.classRightNow = classRightNow;
    }

    public List<ClassAndYearEntity> getClassesSubjects() {
        return classesSubjects;
    }

    public void setClassesSubjects(List<ClassAndYearEntity> classesSubjects) {
        this.classesSubjects = classesSubjects;
    }

    @Override
    public String toString() {
        return "UserDetailsEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", dateOfschool=" + dateOfschool +
                ", classesSubjects=" + classesSubjects +
                ", classRightNow='" + classRightNow + '\'' +
                '}';
    }
}
