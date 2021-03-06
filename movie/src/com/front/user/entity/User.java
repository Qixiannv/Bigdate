package com.front.user.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.front.movie.entity.MovieAndActor;
import com.front.movie.entity.MovieComment;
import com.front.movie.entity.MovieType;
import com.front.movie.entity.MovieTypeAndMovie;
import com.front.movie.entity.MovieTypeAndUser;

@Entity
@Table(name="user")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User {
	private int user_id;
	private String email;
	private String phone;
	private String username;
	private String password;
	private Date birthday;
	private String avatar;
	
	private String gender;
	private String signature;
	
	private Set userlikemovie = new HashSet<UserLikeMovie>();
	private Set type_userSet = new HashSet<MovieTypeAndUser>();
	
	
	
		
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public User(int user_id, String email, String phone, String username, String password, Date birthday, String avatar,
			String gender, String signature, Set userlikemovie, Set type_userSet) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.avatar = avatar;
		this.gender = gender;
		this.signature = signature;
		this.userlikemovie = userlikemovie;
		this.type_userSet = type_userSet;
	}




	@Id
	@GeneratedValue(generator="user_id")
	@GenericGenerator(name="user_id",strategy="native")
	public int getUser_id() {
		return user_id;
	}
	

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(name="avatar")
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="signature")
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
	
	@OneToMany(mappedBy="user", targetEntity=MovieTypeAndUser.class,fetch=FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL})
	public Set getType_userSet() {
		return type_userSet;
	}


	public void setType_userSet(Set type_userSet) {
		this.type_userSet = type_userSet;
	}
	
	@OneToMany(mappedBy="user", targetEntity=UserLikeMovie.class,fetch=FetchType.EAGER)
	@Cascade(value = {CascadeType.SAVE_UPDATE, 	CascadeType.DELETE_ORPHAN,CascadeType.ALL})
	public Set getUserlikemovie() {
		return userlikemovie;
	}
	public void setUserlikemovie(Set userlikemovie) {
		this.userlikemovie = userlikemovie;
	}
	
	
}
