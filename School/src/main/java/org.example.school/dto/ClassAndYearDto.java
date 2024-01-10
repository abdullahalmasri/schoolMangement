package org.example.school.dto;

import org.example.school.dao.UserDetailsEntity;

public class ClassAndYearDto {
    private int id;

    private Long year;

    private String classes;

    private Long userDetailsEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Long getUserDetailsEntity() {
        return userDetailsEntity;
    }

    public void setUserDetailsEntity(Long userDetailsEntity) {
        this.userDetailsEntity = userDetailsEntity;
    }
}
