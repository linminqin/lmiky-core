package com.lmiky.jdp.json.util;

import com.lmiky.jdp.json.JsonMapper;
import com.lmiky.jdp.json.jackson.JsonMapperImpl;

/**
 * json工具类
 * @author lmiky
 * @date 2013-5-19
 */
public class JsonUtils {
	//private static JsonMapper jsonMapper = (JsonMapper)Environment.getBean(PropertiesUtils.getStringContextValue("json.jsonMapperName"));
	private static JsonMapper jsonMapper = new JsonMapperImpl();
	static {
		jsonMapper.init();
	}
	
	/**
	 * 将对象转为json字符串
	 * @author lmiky
	 * @date 2013-5-19
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception {
		return jsonMapper.toJson(object);
	}
	
	/**
	 * 将json转为对象
	 * @author lmiky
	 * @date 2013-5-19
	 * @param json
	 * @param objectClass
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromJson(String json, Class<T> objectClass) throws Exception {
		return jsonMapper.fromJson(json, objectClass);
	}
	
}
