package org.example.school.dao;

import org.example.school.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

//row in database
@Entity
@Table(name = "tb_user_school")
@AllArgsConstructor
@EqualsAndHashCode
public class StudentEntity {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_sequence")
    @Column(name = "user_id_us", nullable = false, unique = true)
    private long id;
    @Column(name = "name_us",length = 32,unique = true)
    private String name;
    @Column(name = "user_name_us",length = 32,unique = true)
    private String username;
    @Column(name = "password_us")
    private int password;
    @Column(name = "role_us")
    private Role role;


    public StudentEntity() {
        super();
    }

    public StudentEntity(StudentDto studentDto) {
        this.username = studentDto.getUsername();
        this.name = studentDto.getName();
        this.password = studentDto.getPassword();
        this.role = studentDto.getRole();
    }

    public StudentEntity(StudentEntity userEntity) {
        this.setId(userEntity.getId());
        this.setName(userEntity.getName());
        this.setPassword(userEntity.getPassword());
        this.setUsername(userEntity.getUsername());
        this.setRole(userEntity.getRole());
    }


    protected StudentDto toUser() {
        StudentDto user = new StudentDto();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

