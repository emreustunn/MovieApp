package com.bilgeadam.service;

import com.bilgeadam.repository.IMovieCommentRepository;
import com.bilgeadam.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements IServiceCrud<MovieComment> {

    private final IMovieCommentRepository repository;

    @Override
    public MovieComment save(MovieComment movieComment) {
        return repository.save(movieComment);
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return repository.saveAll(t);
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public void delete(MovieComment movieComment) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<MovieComment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<MovieComment> findById(long id) {
        return repository.findById(id);
    }

    public List<MovieComment> findAllByMovieId(Long movieId){
        return repository.findAllByMovieId(movieId);
    }

    public List<MovieComment> findAllByUserId(Long userId){
        return repository.findAllByUserId(userId);
    }

    public List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, String startDate, String endDate){
        LocalDate date1 = LocalDate.parse(startDate);
        LocalDate date2 = LocalDate.parse(endDate);
        return repository.findAllByMovieIdAndDateBetween(movieId,date1,date2);
    }


}
