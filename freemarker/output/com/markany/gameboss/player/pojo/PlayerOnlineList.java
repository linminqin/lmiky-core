package com.markany.gameboss.player.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 玩家在线清单
 * @author lmiky
 * @date 2015-05-12 11:12:01
 */
@Entity
@Table(name="t_player_online_list")
public class PlayerOnlineList extends BasePojo {
	private String playerCode;
	private String gameCode;
	private Date loginTime;
	private Date logoutTime;
	private String region;
	
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
	 * @return the gameCode
	 */
	@Column(name="gameCode")
	public String getGameCode() {
		return gameCode;
	}
	/**
	 * @param gameCode the gameCode to set
	 */
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	/**
	 * @return the loginTime
	 */
	@Column(name="loginTime")
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the logoutTime
	 */
	@Column(name="logoutTime")
	public Date getLogoutTime() {
		return logoutTime;
	}
	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	/**
	 * @return the region
	 */
	@Column(name="region")
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

}
