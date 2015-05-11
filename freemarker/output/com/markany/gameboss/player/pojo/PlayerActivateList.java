package com.markany.gameboss.player.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 玩家激活清单
 * @author lmiky
 * @date 2015-05-11 17:42:58
 */
@Entity
@Table(name="t_player_activate_list")
public class PlayerActivateList extends BasePojo {
	private String playerCode;
	private String gameCode;
	private Date activateTime;
	
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

}
