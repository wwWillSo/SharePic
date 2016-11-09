package szw.ins.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity
public class Follow implements Serializable{
	private String userid ;
	private String f_userid ;
	private int statue ;		//0表示未follow，1表示已follow
	private Date createTime ;
	private Date UpdateTime ;
	
	@Id
	@ManyToOne(targetEntity=User.class, cascade=CascadeType.ALL)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Id
	@ManyToOne(targetEntity=User.class, cascade=CascadeType.ALL)
	public String getF_userid() {
		return f_userid;
	}
	public void setF_userid(String f_userid) {
		this.f_userid = f_userid;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
}
