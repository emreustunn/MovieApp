package com.bilgeadam.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Lob //big data olanları tutmak için @Lob
    private String summary;
    private String url;
    private LocalDate premired;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> comments;
}
