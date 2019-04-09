package com.showtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.showtime.pojo.Movie;
import com.showtime.service.MovieService;
import com.showtime.util.Page;

@RestController
@RequestMapping("movieIndex")
public class MovieIndexController {
	@Autowired
	private MovieService movieService;

	@GetMapping("index")
	public ModelAndView showMovie(Page page) {
		PageHelper.offsetPage(page.getStart(), 10);

		ModelAndView mv = new ModelAndView();
		List<Movie> movies = movieService.selectAllMovie();

		int total = (int) new PageInfo<>(movies).getTotal();
		page.caculateLast(total);

		mv.addObject("movies", movies);
		mv.setViewName("MovieIndex");
		return mv;
	}

	@GetMapping("{categories}/{category}")
	public ModelAndView showMovieByCountry(@PathVariable String categories, @PathVariable String category, Page page) {
		ModelAndView mv = new ModelAndView();
		List<Movie> movies = null;

		PageHelper.offsetPage(page.getStart(), 10);

		if (categories.equals("m_date")) {
			movies = movieService.selectMovieByDate(category);
			if (category.equals("other")) {
				movies = movieService.selectMovieByOtherDate();
			}
		} else if (categories.equals("m_country")) {
			movies = movieService.selectMovieByCategory(categories, category);
			if (category.equals("other")) {
				movies = movieService.selectMovieByOtherCountry();
			}
		} else {
			movies = movieService.selectMovieByCategory(categories, category);
			if (category.equals("other")) {
				movies = movieService.selectMovieByOtherCategory();
			}
		}

		int total = (int) new PageInfo<>(movies).getTotal();
		page.caculateLast(total);

		mv.addObject("movies", movies);
		mv.setViewName("MovieIndex");
		return mv;
	}
}
