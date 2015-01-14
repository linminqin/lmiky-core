package com.lmiky.test.jdp.database.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import com.lmiky.jdp.database.dao.BaseDAO;
import com.lmiky.test.BaseTest;

public class DAOTest extends BaseTest {
	private BaseDAO baseDAO;
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void testDI() {
		System.out.println(baseDAO);
		System.out.println(sqlSessionTemplate);
	}
	
	/**
	 * @param dao the dao to set
	 */
	@Resource(name="baseDAO")
	public void setDao(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
