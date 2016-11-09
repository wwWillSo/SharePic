package szw.ins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Comment implements Serializable{
	private int id ;
	private String note ;
	
	private Picture pic ;
	private User user ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@ManyToOne(targetEntity=Picture.class)
	@JoinColumn(name="picid", nullable=false)
	public Picture getPic() {
		return pic;
	}
	public void setPic(Picture pic) {
		this.pic = pic;
	}
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userid",nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
