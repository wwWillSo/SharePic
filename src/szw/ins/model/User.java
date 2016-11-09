package szw.ins.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="[user]")
public class User implements Serializable{
	private String userid ;
	private String password ;
	private String username ;
	private String website ;
	private String note ;
	private String email ;
	private String phone ;
	private String sex ;
	private String portrait ;
	
	private Set<Message> msg = new HashSet<Message>() ;
	private Set<Picture> pics = new HashSet<Picture>() ;
	private Set<Like> like = new HashSet<Like>() ;
	private Set<Comment> comment = new HashSet<Comment>() ;
	
	@Id
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
	@OneToMany(targetEntity=Message.class, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Message> getMsg() {
		return msg;
	}
	public void setMsg(Set<Message> msg) {
		this.msg = msg;
	}
	
	@OneToMany(targetEntity=Picture.class, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Picture> getPics() {
		return pics;
	}
	public void setPics(Set<Picture> pics) {
		this.pics = pics;
	}
	
	@OneToMany(targetEntity=Like.class, cascade=CascadeType.ALL,mappedBy="user")
	public Set<Like> getLike() {
		return like;
	}
	public void setLike(Set<Like> like) {
		this.like = like;
	}
	
	@OneToMany(targetEntity=Comment.class, cascade=CascadeType.ALL, mappedBy="user")
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
}
