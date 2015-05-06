package com.lmiky.jdp.module.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 功能
 * @author lmiky
 * @date 2015-05-06 22:20:53
 */
@Entity
@Table(name="t_function")
public class Function extends BasePojo {
	private String name;
	private Long moduleId;
	private String authorityCode;
	private Integer sort;
	
	/**
	 * @return the name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the moduleId
	 */
	@Column(name="moduleId")
	public Long getModuleId() {
		return moduleId;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * @return the authorityCode
	 */
	@Column(name="authorityCode")
	public String getAuthorityCode() {
		return authorityCode;
	}
	/**
	 * @param authorityCode the authorityCode to set
	 */
	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}
	/**
	 * @return the sort
	 */
	@Column(name="sort")
	public Integer getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
