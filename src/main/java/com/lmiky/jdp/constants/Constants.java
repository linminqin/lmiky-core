package com.lmiky.jdp.constants;

import com.lmiky.jdp.util.PropertiesUtils;

/**
 * 常量
 * @author lmiky
 * @date 2013-4-16
 */
public class Constants {
	// ****************************************properties文件key****************************************//
	// 配置文件
	public static final String PROPERTIES_KEY_CONTEXT_FILE = "config/context";
	public static final String PROPERTIES_KEY_OPERATENAME_FILE = "config/operateName";
	public static final String PROPERTIES_KEY_CODE_MSG_FILE = "config/codeMsg";

	// 格式
	public static final String CONTEXT_KEY_FORMAT_DATE = "format.date"; // 日期
	public static final String CONTEXT_KEY_FORMAT_DATETIME = "format.dateTime"; // 日期时间
	public static final String CONTEXT_KEY_FORMAT_TIME = "format.time"; // 时间
	//日期格式值
	public static final String CONTEXT_KEY_FORMAT_DATE_VALUE = PropertiesUtils.getStringContextValue(CONTEXT_KEY_FORMAT_DATE); // 日期
	public static final String CONTEXT_KEY_FORMAT_DATETIME_VALUE = PropertiesUtils.getStringContextValue(CONTEXT_KEY_FORMAT_DATETIME); // 日期时间
	public static final String CONTEXT_KEY_FORMAT_TIME_VALUE = PropertiesUtils.getStringContextValue(CONTEXT_KEY_FORMAT_TIME);  // 时间

	// 分页
	public static final String CONTEXT_KEY_PAGE_PAGESIZE = "page.pageSize";
	
	//文件上传路径
	//临时目录
	public static final String SYSTEM_FILE_UPLOAD_PATH_TEMP = "system.file.upload.path.temp";
	public static final String SYSTEM_FILE_PATH = "system.file.path";
}