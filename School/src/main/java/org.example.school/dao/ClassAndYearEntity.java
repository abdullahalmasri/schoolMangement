package org.example.school.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "tb_classes_year")
@AllArgsConstructor
@EqualsAndHashCode
public class ClassAndYearEntity {

    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_sequence")
    @Column(name = "class_year_id", nullable = false, unique = true)
    private int id;
    @Column(name = "year_class")
    private Long year;

    @Column(name = "class_name",length = 32,unique = true)
    private String classes;

    @ManyToOne
    @JoinColumn(name = "user_detail_id")
    private UserDetailsEntity userDetailsEntity;

    public ClassAndYearEntity() {
    }

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

//    public UserDetailsEntity getUserDetailsEntity() {
//        return userDetailsEntity;
//    }
////
//    public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity) {
//        this.userDetailsEntity = userDetailsEntity;
//    }

    @Override
    public String toString() {
        return "ClassAndYearEntity{" +
                "id=" + id +
                ", year=" + year +
                ", classes='" + classes + '\'' +
                '}';
    }
}
