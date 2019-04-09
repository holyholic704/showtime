package com.showtime.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Movie {
	private int m_id;
	private String m_name;// 电影名
	private String m_director;// 导演
	private String m_actor;// 演员
	private String m_type;// 类型
	private String m_country;// 国家
	private int m_length;// 长度
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date m_date;// 上映日期
	private String m_pic;// 图片地址
	private String m_summary;// 简介
	private MultipartFile m_file;// 上传图片

	public String toString() {
		return "Movie [m_id=" + m_id + ", m_name=" + m_name + ", m_director=" + m_director + ", m_actor=" + m_actor
				+ ", m_type=" + m_type + ", m_country=" + m_country + ", m_length=" + m_length + ", m_date=" + m_date
				+ ", m_pic=" + m_pic + ", m_summary=" + m_summary + ", m_file=" + m_file + "]";
	}

	public Movie() {
	}

	public Movie(int m_id, String m_name, String m_director, String m_actor, String m_type, String m_country,
			int m_length, Date m_date, String m_pic, String m_summary, MultipartFile m_file) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_director = m_director;
		this.m_actor = m_actor;
		this.m_type = m_type;
		this.m_country = m_country;
		this.m_length = m_length;
		this.m_date = m_date;
		this.m_pic = m_pic;
		this.m_summary = m_summary;
		this.m_file = m_file;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_director() {
		return m_director;
	}

	public void setM_director(String m_director) {
		this.m_director = m_director;
	}

	public String getM_actor() {
		return m_actor;
	}

	public void setM_actor(String m_actor) {
		this.m_actor = m_actor;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_country() {
		return m_country;
	}

	public void setM_country(String m_country) {
		this.m_country = m_country;
	}

	public int getM_length() {
		return m_length;
	}

	public void setM_length(int m_length) {
		this.m_length = m_length;
	}

	public Date getM_date() {
		return m_date;
	}

	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}

	public String getM_pic() {
		return m_pic;
	}

	public void setM_pic(String m_pic) {
		this.m_pic = m_pic;
	}

	public String getM_summary() {
		return m_summary;
	}

	public void setM_summary(String m_summary) {
		this.m_summary = m_summary;
	}

	public MultipartFile getM_file() {
		return m_file;
	}

	public void setM_file(MultipartFile m_file) {
		this.m_file = m_file;
	}

}
