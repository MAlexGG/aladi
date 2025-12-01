package com.aladi.aladi.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserves")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime reserveDate;

    @Column(nullable = false)
    private LocalDateTime returnDate; 

    @Column(nullable = false)
    private Boolean isReturned = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reserve_books", joinColumns = @JoinColumn(name = "reserve_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reserve_users", joinColumns = @JoinColumn(name = "reserve_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

}
