package com.lmiky.jdp.util;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.lmiky.jdp.json.util.JsonUtils;

/**
 * IP地址工具类
 * @author lmiky
 * @date 2015年5月11日 下午2:18:09
 */
public class IPUtils {
	private static final String API_URL_TB = "http://ip.taobao.com/service/getIpInfo.php";
	private static final String API_URL_SINA = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";
	private static final String RESULT_CHARSET = "UTF-8";
	// 参数名
	public static final String PARAMNAME_COUNTRY = "country";
	public static final String PARAMNAME_PROVINCE = "province";
	public static final String PARAMNAME_CITY = "city";

	public static Map<String, String> location(String ip) throws Exception {
		return sinaLocation(ip);
	}

	/**
	 * 淘宝
	 * @author lmiky
	 * @date 2015年5月11日 下午2:26:21
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> tbLocation(String ip) throws Exception {
		Map<String, String> ret = new HashMap<String, String>();
		// 请求
		String json = HttpUtils.get(API_URL_TB + "?ip=" + ip);
		// 解析数据，数据格式为
		// {"code":0,"data":{"country":"\u4e2d\u56fd","country_id":"CN","area":"\u534e\u4e1c","area_id":"300000","region":"\u798f\u5efa\u7701","region_id":"350000","city":"\u53a6\u95e8\u5e02","city_id":"350200","county":"","county_id":"-1","isp":"\u7535\u4fe1","isp_id":"100017","ip":"218.5.76.173"}}
		Map<String, Object> map = JsonUtils.fromJson(json, Map.class);
		Map<String, Object> dataMap = (Map<String, Object>) map.get("data");
		// 国家
		String country = dataMap.get("country").toString();
		country = URLDecoder.decode(country, RESULT_CHARSET);
		ret.put(PARAMNAME_COUNTRY, country);
		// 省份
		String province = dataMap.get("region").toString();
		province = URLDecoder.decode(province, RESULT_CHARSET);
		ret.put(PARAMNAME_PROVINCE, buildProvinceName(province));
		// 地市
		String city = dataMap.get("city").toString();
		city = URLDecoder.decode(city, RESULT_CHARSET);
		ret.put(PARAMNAME_CITY, buildCityName(city));

		return ret;
	}

	/**
	 * 新浪
	 * @author lmiky
	 * @date 2015年5月11日 下午2:29:17
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> sinaLocation(String ip) throws Exception {
		Map<String, String> ret = new HashMap<String, String>();
		// 请求
		String json = HttpUtils.get(API_URL_SINA + "&ip=" + ip);
		Map<String, Object> map = JsonUtils.fromJson(json, Map.class);
		map = JsonUtils.fromJson(json, Map.class);
		// 国家
		String country = map.get("country").toString();
		country = URLDecoder.decode(country, RESULT_CHARSET);
		ret.put(PARAMNAME_COUNTRY, country);
		// 省份
		String province = map.get("province").toString();
		province = URLDecoder.decode(province, RESULT_CHARSET);
		ret.put(PARAMNAME_PROVINCE, buildProvinceName(province));
		// 地市
		String city = map.get("city").toString();
		city = URLDecoder.decode(city, RESULT_CHARSET);
		ret.put(PARAMNAME_CITY, buildCityName(city));
		
		return ret;
	}

	/**
	 * 构建省名
	 * @author lmiky
	 * @date 2015年5月11日 下午2:44:34
	 * @param provinceName
	 * @return
	 */
	private static String buildProvinceName(String provinceName) {
		if (!provinceName.endsWith("省")) {
			provinceName += "省";
		}
		return provinceName;
	}

	/**
	 * 构建市名
	 * @author lmiky
	 * @date 2015年5月11日 下午2:45:02
	 * @param cityName
	 * @return
	 */
	private static String buildCityName(String cityName) {
		if (!cityName.endsWith("市")) {
			cityName += "市";
		}
		return cityName;
	}

	public static void main(String[] args) throws Exception {
		String[] ips = {"218.5.76.173", "58.22.96.121", "218.86.126.226", "61.131.4.164", "121.34.145.197"};
		for(String ip : ips) {
			Map<String, String> map = IPUtils.location(ip);
			System.out.print(map.get(PARAMNAME_COUNTRY) + " ");
			System.out.print(map.get(PARAMNAME_PROVINCE) + " ");
			System.out.println(map.get(PARAMNAME_CITY));
		}
	}

}
