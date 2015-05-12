package com.markany.gameboss.player.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 玩家消费清单
 * @author lmiky
 * @date 2015-05-12 10:11:57
 */
@Entity
@Table(name="t_player_consume_list")
public class PlayerConsumeList extends BasePojo {
	private String playerCode;
	private String gameCode;
	private Integer amount;
	private Date consumeTime;
	
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
	 * @return the amount
	 */
	@Column(name="amount")
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * @return the consumeTime
	 */
	@Column(name="consumeTime")
	public Date getConsumeTime() {
		return consumeTime;
	}
	/**
	 * @param consumeTime the consumeTime to set
	 */
	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}

}
