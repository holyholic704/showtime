package com.showtime.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showtime.dao.GradeDao;
import com.showtime.pojo.Grade;
import com.showtime.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeDao gradeDao;

	public Double selectMovieGrade(int m_id) {
		return gradeDao.selectMovieGrade(m_id);
	}

	public void insertMovieGrade(Grade movieGrade) {
		gradeDao.insertMovieGrade(movieGrade);
	}

	public Double selectMovieGradeByU_id(int m_id, int u_id) {
		return gradeDao.selectMovieGradeByU_id(m_id, u_id);
	}

	public void updateMovieGrade(Grade grade) {
		gradeDao.updateMovieGrade(grade);
	}

	public List<Grade> selectMostTen() {
		return gradeDao.selectMostTen();
	}

}
