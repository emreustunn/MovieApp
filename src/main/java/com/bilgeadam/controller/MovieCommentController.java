package com.bilgeadam.controller;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;

    @PostMapping("/save")
    public ModelAndView save(MovieCommentCreateRequestDto dto){
        movieCommentService.save(IUserMapper.INSTANCE.toMovieComment(dto));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/movie/findbyid/"+dto.getMovieId()+"?userId="+dto.getUserId());
        return modelAndView;

    }
}
