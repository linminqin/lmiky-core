package com.markany.gameope.game.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 游戏版本
 * @author lmiky
 * @date 2015-05-07 09:34:50
 */
@Entity
@Table(name="t_game_version")
public class GameVersion extends BasePojo {
	private Long gameId;
	private Integer code;
	private String version;
	private Date createTime;
	private String summary;
	
	/**
	 * @return the gameId
	 */
	@Column(name="gameId")
	public Long getGameId() {
		return gameId;
	}
	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	/**
	 * @return the code
	 */
	@Column(name="code")
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the version
	 */
	@Column(name="version")
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @return the summary
	 */
	@Column(name="summary")
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
