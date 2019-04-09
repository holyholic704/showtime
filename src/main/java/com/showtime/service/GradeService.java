package com.showtime.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.showtime.pojo.Grade;

public interface GradeService {
	// 查询电影评分
	Double selectMovieGrade(int m_id);

	// 上传电影评分
	void insertMovieGrade(Grade grade);

	// 查询用户对电影的评分
	Double selectMovieGradeByU_id(@Param("m_id") int mid, @Param("u_id") int u_id);

	// 查询用户所有评分过的电影

	// 修改用户的评分
	void updateMovieGrade(Grade grade);

	// 选择分数最高的十部电影
	List<Grade> selectMostTen();
}
