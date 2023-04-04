package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;
    private final MovieCommentService movieCommentService;

    @GetMapping("/findall")
    public ModelAndView getMoviePage(Long userId) {
        User user;
        if (userId == null) {
            user = new User();
        } else {
            user = userService.findById(userId).get();
        }


        List<Movie> movieList = movieService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movies", movieList);
        modelAndView.addObject("genreservice", genreService);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("movies");
        return modelAndView;
    }

    @GetMapping("/findbyid/{id}/")                          //required false zorunluluğu kaldırır.
    public ModelAndView getMovieById(@PathVariable Long id,@RequestParam(required = false) Long userId) {
        //localhost:8085/movie/findbyid/1
        ModelAndView modelAndView = new ModelAndView();
        User user;
        if (userId == null) {
            modelAndView.addObject("user",null);
        } else {
            user=userService.findById(userId).get();
            modelAndView.addObject("user",user);

        }
        Optional<Movie> movie = movieService.findById(id);
        modelAndView.addObject("movie", movie);
        modelAndView.addObject("genreservice", genreService);
        modelAndView.addObject("userservice", userService);
        modelAndView.addObject("commentservice", movieCommentService);
        modelAndView.setViewName("moviesDetail");

        return modelAndView;
    }


}
