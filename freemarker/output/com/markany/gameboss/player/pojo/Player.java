package com.markany.gameboss.player.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 玩家
 * @author lmiky
 * @date 2015-05-11 16:54:18
 */
@Entity
@Table(name="t_player")
public class Player extends BasePojo {
	private String code;
	private Long region;
	private Integer operator;
	private Date activateTime;
	private Date lastActiveTime;
	
	/**
	 * @return the code
	 */
	@Column(name="code")
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the region
	 */
	@Column(name="region")
	public Long getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Long region) {
		this.region = region;
	}
	/**
	 * @return the operator
	 */
	@Column(name="operator")
	public Integer getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	/**
	 * @return the activateTime
	 */
	@Column(name="activateTime")
	public Date getActivateTime() {
		return activateTime;
	}
	/**
	 * @param activateTime the activateTime to set
	 */
	public void setActivateTime(Date activateTime) {
		this.activateTime = activateTime;
	}
	/**
	 * @return the lastActiveTime
	 */
	@Column(name="lastActiveTime")
	public Date getLastActiveTime() {
		return lastActiveTime;
	}
	/**
	 * @param lastActiveTime the lastActiveTime to set
	 */
	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

}
