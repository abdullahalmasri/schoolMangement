package org.example.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.school.dao.Role;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class StudentDto {

    private String name;

    private String username;

    private int password;

    private Role role;

    public StudentDto() {
        super();
    }

    public StudentDto(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public StudentDto(StudentDto studentDto) {
        this.username = studentDto.getUsername();
        this.password = studentDto.getPassword();
        this.name = studentDto.getName();
        this.role = studentDto.getRole();
    }

    public StudentDto updateUser(StudentDto studentDto) {
        this.username = studentDto.getUsername();
        this.password = studentDto.getPassword();
        this.name = studentDto.getName();
        this.role = studentDto.getRole();
        return this;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
