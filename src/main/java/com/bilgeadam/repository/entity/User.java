package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.entity.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
/*
    userrepository oluştur.+
    user service oluştur.+
    user controller oluştur.
    -register işlemi yapalım ve verileri teker teker alalım.
    - bu veriler name surname password ve email.

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbluser") //userda table name kullanmak zorunlu postgre sıkıntı çıkarıyor.
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surName;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    @ElementCollection
    private List<Long> favGenres;
    @ElementCollection
    private List<Long> favMovies;
    @Builder.Default //defaultta ne gelmesini istiyorsak belirtmek için
    @Enumerated(EnumType.STRING) // enumum string olarak gelsin diye
    private UserType userType=UserType.USER;
    @ElementCollection
    private List<Long> comments;
}
