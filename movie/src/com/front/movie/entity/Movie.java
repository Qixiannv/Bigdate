package com.front.movie.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="movie")
public class Movie {
	
	private int movie_id;
	
	private String movie_name;
	
	private String movie_summary;
	
	private String movie_pic;
	
	private int movie_type;
	
	private Date date;
	private int time;
	private int rate;
	
	
	private Set movieSet=new HashSet<MovieComment>();
	public Movie() {}
	public Movie(String movie_timename, String movie_summary, String movie_pic, int movie_type) {
		super();
		this.movie_name = movie_name;
		this.movie_summary = movie_summary;
		this.movie_pic = movie_pic;
		this.movie_type = movie_type;
	}
	
	@Id
	@GeneratedValue(generator="mid")
	@GenericGenerator(name="mid",strategy="native")
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	@Column(name="movie_name")
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	@Column(name="movie_summary")
	public String getMovie_summary() {
		return movie_summary;
	}
	public void setMovie_summary(String movie_summary) {
		this.movie_summary = movie_summary;
	}
	
	@Column(name="movie_pic")
	public String getMovie_pic() {
		return movie_pic;
	}
	public void setMovie_pic(String movie_pic) {
		this.movie_pic = movie_pic;
	}
	
	@Column(name="movie_type")
	public int getMovie_type() {
		return movie_type;
	}
	public void setMovie_type(int movie_type) {
		this.movie_type = movie_type;
	}
	@OneToMany(mappedBy="movie", targetEntity=MovieComment.class,
			cascade=CascadeType.ALL)
	public Set getMovieSet() {
		return movieSet;
	}
	public void setMovieSet(Set movieSet) {
		this.movieSet = movieSet;
	}
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="time")
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Column(name="rate")
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
