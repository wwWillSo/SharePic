package szw.ins.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@SuppressWarnings("serial")
@Entity
public class Picture implements Serializable{
	private int picid ;
	private Date publishTime ;
	private String picpath ;
	
	private User user ;
	private Set<Like> like = new HashSet<Like>() ;
	private Set<Comment> comment = new HashSet<Comment>() ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPicid() {
		return picid;
	}
	public void setPicid(int picid) {
		this.picid = picid;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userid", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(targetEntity=Like.class, cascade=CascadeType.ALL, mappedBy="pic")
	public Set<Like> getLike() {
		return like;
	}
	public void setLike(Set<Like> like) {
		this.like = like;
	}
	
	@OneToMany(targetEntity=Comment.class, cascade=CascadeType.ALL, mappedBy="pic")
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
}
