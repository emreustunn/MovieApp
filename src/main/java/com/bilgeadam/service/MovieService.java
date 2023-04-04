package com.bilgeadam.service;

import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements IServiceCrud<Movie> {
    private final IMovieRepository repository;
    private final UserService userService;

    @Override
    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return repository.saveAll(t);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return repository.findById(id);
    }

    public List<Movie> findAllByRatingGreaterThan(double rate) {
        return repository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findAllByUsersGenres(Long userid) {
        Optional<User> user = userService.findById(userid);
        if (user.isPresent()) {
            List<Long> genres = user.get().getFavGenres();
            return repository.findAll().stream().filter(x -> x.getGenres().stream().anyMatch(genres::contains)).collect(Collectors.toList());
        } else {
            throw new RuntimeException("kullanıcı bulunamadı");
        }
    }

    public List<Movie> findAllByPremiredBefore(String date) {
        return repository.findAllByPremiredBefore(LocalDate.parse(date));
    }

    public Object[] searchByRating() {
        return repository.searchByRating();
    }

    public Object searchByRating(double rate) {
        return repository.searchByRating(rate);
    }

    public List<Movie> findAllByRatingIn() {
        List<Double> ratings = List.of(7.0, 8.0, 9.0);
        return repository.findAllByRatingIn(ratings);
    }

    public List<Movie> findAllByRatingIn(Double [] ratings) {
        return repository.findAllByRatingIn(Arrays.asList(ratings));
    }
    public List<Movie> findAllByNameIn(String [] movieNames){
        return repository.findAllByNameIn(movieNames);
    }
}
