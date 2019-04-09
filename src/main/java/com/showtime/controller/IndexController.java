package com.showtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.showtime.pojo.Grade;
import com.showtime.pojo.Movie;
import com.showtime.service.GradeService;
import com.showtime.service.MovieService;

@RestController
public class IndexController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private GradeService gradeService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();

		// 最新电影
		List<Movie> movies = movieService.selectLatestMovie();

		List<Grade> ten = gradeService.selectMostTen();

		mv.addObject("movies", movies);
		mv.addObject("ten", ten);
		mv.setViewName("forward:/index.jsp");
		return mv;
	}
}
