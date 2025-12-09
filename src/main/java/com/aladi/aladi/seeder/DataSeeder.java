package com.aladi.aladi.seeder;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.entity.Editorial;
import com.aladi.aladi.entity.Genre;
import com.aladi.aladi.entity.User;
import com.aladi.aladi.repository.BookRepository;
import com.aladi.aladi.repository.EditorialRepository;
import com.aladi.aladi.repository.GenreRepository;
import com.aladi.aladi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final EditorialRepository editorialRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0) {
            User user = new User();
            user.setName("Martha");
            user.setLastname("López");
            user.setEmail("martha@mail.com");
            user.setPassword("martha123");
            user.setDni("98765432B");
            user.setRole("USER");
            userRepository.save(user);
        }

        if(editorialRepository.count() == 0) {
            Editorial editorial = new Editorial();
            editorial.setName("planeta");
            editorialRepository.save(editorial);
        }

        if(genreRepository.count() == 0) {
            Genre pedagogy = new Genre();
            pedagogy.setName("pedagogía");
            Genre psychology = new Genre();
            psychology.setName("psicología");
            genreRepository.saveAll(List.of(pedagogy, psychology));
        }

        if(bookRepository.count() == 0) {
            Book book = new Book();
            book.setTitle("Enseñar a Transgredir");
            book.setAuthor("bell hooks");
            book.setIsbn("9788412281842");
            book.setGenres(Set.of(
                genreRepository.findByName("pedagogía"),
                genreRepository.findByName("psicología")
            ));
            book.setEditorial(editorialRepository.findByName("planeta"));
            bookRepository.save(book);
        }   
        
    }

}
