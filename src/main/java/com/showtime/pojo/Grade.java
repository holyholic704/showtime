package com.showtime.pojo;

public class Grade {
	private int id;
	private int m_id;
	private int u_id;
	private double m_grade;
	private Movie movie;

	public Grade() {
	}

	public Grade(int m_id, int u_id, double m_grade) {
		this.m_id = m_id;
		this.u_id = u_id;
		this.m_grade = m_grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public double getM_grade() {
		return m_grade;
	}

	public void setM_grade(double m_grade) {
		this.m_grade = m_grade;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
