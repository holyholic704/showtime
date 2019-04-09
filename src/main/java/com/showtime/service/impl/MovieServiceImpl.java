package com.showtime.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showtime.dao.MovieDao;
import com.showtime.pojo.Movie;
import com.showtime.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	public List<Movie> selectLatestMovie() {
		return movieDao.selectLatestMovie();
	}

	public Movie selectOneMovie(int m_id) {
		return movieDao.selectOneMovie(m_id);
	}

	public List<Movie> selectAllMovie() {
		return movieDao.selectAllMovie();
	}

	public List<Movie> selectMovieByCategory(String categories, String category) {
		String str = "";

		if (categories.equals("m_country")) {
			str = countryType(category);
		} else {
			str = typeType(category);
		}
		return movieDao.selectMovieByCategory(categories, str);
	}

	public List<Movie> selectMovieByOtherCategory() {
		return movieDao.selectMovieByOtherCategory();
	}

	public List<Movie> selectMovieByOtherCountry() {
		return movieDao.selectMovieByOtherCountry();
	}

	public List<Movie> selectMovieByDate(String m_date) {
		return movieDao.selectMovieByDate(m_date);
	}

	public List<Movie> selectMovieByOtherDate() {
		return movieDao.selectMovieByOtherDate();
	}
	
	public static String countryType(String str) {

		switch (str) {
		case "china":
			str = "中国";
			break;
		case "usa":
			str = "美国";
			break;
		case "japan":
			str = "日本";
			break;
		case "korea":
			str = "韩国";
			break;
		}

		return str;
	}

	public static String typeType(String str) {
		switch (str) {
		case "story":
			str = "剧情";
			break;
		case "act":
			str = "动作";
			break;
		case "comedy":
			str = "喜剧";
			break;
		case "sf":
			str = "科幻";
			break;
		case "biopic":
			str = "传记";
			break;
		case "animate":
			str = "动画";
			break;
		case "horror":
			str = "恐怖";
			break;
		case "suspense":
			str = "悬疑";
			break;
		case "war":
			str = "战争";
			break;
		}
		return str;
	}

}
