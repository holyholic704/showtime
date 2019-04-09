package com.showtime.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.showtime.dao.GradeDao;
import com.showtime.dao.MovieDao;
import com.showtime.pojo.Grade;
import com.showtime.pojo.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class BaseTest {

	@Autowired
	private MovieDao movieDao;
	@Autowired
	private GradeDao gradeDao;

	@Test
	public void test() {
		List<Grade> list = gradeDao.selectMostTen();
		Movie movie = movieDao.selectOneMovie(1);
		list.forEach((l) -> {
			System.out.println(l);
		});
		String json = JSON.toJSONString(movie);
		System.out.println("\n*\n" + movie);
		System.out.println("\n*\n" + json);
	}

}
