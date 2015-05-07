package com.markany.gameboss.gamechannel.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 游戏渠道推荐
 * @author lmiky
 * @date 2015-05-07 16:43:27
 */
@Entity
@Table(name="t_game_channel")
public class GameChannel extends BasePojo {
	private Long gameversionId;
	private Long channelId;
	private Date mapTime;
	private String summary;
	
	/**
	 * @return the gameversionId
	 */
	@Column(name="gameversionId")
	public Long getGameversionId() {
		return gameversionId;
	}
	/**
	 * @param gameversionId the gameversionId to set
	 */
	public void setGameversionId(Long gameversionId) {
		this.gameversionId = gameversionId;
	}
	/**
	 * @return the channelId
	 */
	@Column(name="channelId")
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return the mapTime
	 */
	@Column(name="mapTime")
	public Date getMapTime() {
		return mapTime;
	}
	/**
	 * @param mapTime the mapTime to set
	 */
	public void setMapTime(Date mapTime) {
		this.mapTime = mapTime;
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
