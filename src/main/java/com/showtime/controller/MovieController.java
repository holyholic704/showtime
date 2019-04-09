package com.showtime.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.showtime.pojo.Movie;
import com.showtime.service.GradeService;
import com.showtime.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private GradeService gradeService;

	@GetMapping("movie/{m_id}")
	public ModelAndView showOneMovie(@PathVariable int m_id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Movie movie = movieService.selectOneMovie(m_id);
		// String json = JSON.toJSONString(movie);

		Double grade = gradeService.selectMovieGrade(m_id);

		Double m_grade = null;
		Object u_id = session.getAttribute("u_id");
		if (u_id != null) {
			int uid = (int) u_id;
			m_grade = gradeService.selectMovieGradeByU_id(m_id, uid);
		}

		mv.addObject("movie", movie);
		mv.addObject("grade", grade);
		mv.addObject("myGrade", m_grade);

		mv.setViewName("movie");
		return mv;
	}

	@GetMapping("randomMovie")
	public ModelAndView randomMovie() {
		ModelAndView mv = new ModelAndView();
		List<Movie> list = movieService.selectAllMovie();
		Random random = new Random();
		int ran = random.nextInt(list.size());
		mv.addObject("movie", list.get(ran));
		mv.setViewName("login");
		return mv;
	}
}
