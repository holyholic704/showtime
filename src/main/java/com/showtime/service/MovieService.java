package com.showtime.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.showtime.pojo.Movie;

public interface MovieService {
	List<Movie> selectLatestMovie();

	Movie selectOneMovie(int m_id);

	List<Movie> selectAllMovie();

	List<Movie> selectMovieByCategory(@Param("categories") String categories, @Param("category") String category);

	List<Movie> selectMovieByOtherCategory();

	List<Movie> selectMovieByOtherCountry();

	List<Movie> selectMovieByDate(String m_date);

	List<Movie> selectMovieByOtherDate();
}
