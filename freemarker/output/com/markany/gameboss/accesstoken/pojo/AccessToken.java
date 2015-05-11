package com.markany.gameboss.accesstoken.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 令牌
 * @author lmiky
 * @date 2015-05-11 15:07:50
 */
@Entity
@Table(name="t_accesstoken")
public class AccessToken extends BasePojo {
	private String playerCode;
	private String token;
	private Date createTime;
	private String ip;
	private Integer state;
	
	/**
	 * @return the playerCode
	 */
	@Column(name="playerCode")
	public String getPlayerCode() {
		return playerCode;
	}
	/**
	 * @param playerCode the playerCode to set
	 */
	public void setPlayerCode(String playerCode) {
		this.playerCode = playerCode;
	}
	/**
	 * @return the token
	 */
	@Column(name="token")
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the createTime
	 */
	@Column(name="createTime")
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the ip
	 */
	@Column(name="ip")
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the state
	 */
	@Column(name="state")
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

}
