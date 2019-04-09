package com.showtime.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showtime.pojo.Grade;
import com.showtime.service.GradeService;

@RestController
public class GradeController {
	@Autowired
	private GradeService gradeService;

	@PostMapping("/addGrade")
	public String addGrade(String m_grade, String m_id, HttpSession session) {
		int first = Integer.parseInt(m_id);
		int u_id = (int) session.getAttribute("u_id");
		double second = Double.parseDouble(m_grade);
		Grade grade = new Grade(first, u_id, second);
		gradeService.insertMovieGrade(grade);
		double newGrade = gradeService.selectMovieGrade(first);
		return newGrade + "";
	}

	@PutMapping("/updateGrade")
	public String updateGrade(String m_grade, String m_id, HttpSession session) {
		int u_id = (int) session.getAttribute("u_id");
		int first = Integer.parseInt(m_id);
		double second = Double.parseDouble(m_grade);
		Grade grade = new Grade(first, u_id, second);
		gradeService.updateMovieGrade(grade);
		double newGrade = gradeService.selectMovieGrade(first);
		return newGrade + "";
	}
}
