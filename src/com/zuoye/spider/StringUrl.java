package com.zuoye.spider;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Title: 在指定的URL上添加参数并改变参数 需求： 改变url,给定一个paramName和paramValue，若paramName存在，
 * 则改变paramName对应的oldvalue,否则就添加一个paramName与paramValue的键值对
 * 前提是给定的参数，paramName和paramValue均不为空，为空直接返回原url
 */
public class StringUrl {
	/**
	 * MethodsTitle:传入的URL中参数的处理
	 *
	 * 
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	
	public static String getStockCompanyInfoUrl(String code){
		String url = "http://xinsanban.eastmoney.com/F10/CompanyInfo/Introduction/"+code+".html";
		return url;
	}
	
	public static String getStockCompanyListUrl(String page,String pageSize){
		String url = "http://xinsanban.eastmoney.com/api/QuoteCenter/GPGS/GetGPGS?level=1&page="+page+"&pagesize="+pageSize+"&sortType=ChangePercent&sortRule=-1";
		return url;
	}
	public static String inputURL(String url, String paramName,
			String paramValue) {
		// 参数和参数名为空的话就返回原来的URL
		if (StringUtils.isBlank(paramValue) || StringUtils.isBlank(paramName)) {
			return url;
		}
		// 先很据# ? 将URL拆分成一个String数组
		String a = "";
		String b = "";
		String c = "";

		String[] abcArray = url.split("[?]");
		a = abcArray[0];
		if (abcArray.length > 1) {
			String bc = abcArray[1];
			String[] bcArray = bc.split("#");
			b = bcArray[0];
			if (bcArray.length > 0) {
				c = bcArray[1];
			}
		}
		if (StringUtils.isBlank(b)) {
			return url;
		}

		// 用&拆p, p1=1&p2=2 ，{p1=1,p2=2}
		String[] bArray = b.split("&");
		String newb = "";
		boolean found = false;
		for (int i = 0; i < bArray.length; i++) {
			String bi = bArray[i];
			if (StringUtils.isBlank(bi))
				continue;
			String key = "";
			String value = "";

			String[] biArray = bi.split("="); // {p1,1}
			key = biArray[0];
			if (biArray.length > 1)
				value = biArray[1];

			if (key.equals(paramName)) {
				found = true;
				if (StringUtils.isNotBlank(paramValue)) {
					newb = newb + "&" + key + "=" + paramValue;
				} else {
					continue;
				}
			} else {
				newb = newb + "&" + key + "=" + value;
			}
		}
		// 如果没找到，加上
		if (!found && StringUtils.isNotBlank(paramValue)) {
			newb = newb + "&" + paramName + "=" + paramValue;
		}
		if (StringUtils.isNotBlank(newb))
			a = a + "?" + newb;
		if (StringUtils.isNotBlank(c))
			a = a + "#" + c;
		return a;
	}

	/**
	 * MethodsTitle: 从url地址中根据key获取value
	 * 
	 * @param paramName
	 * @return
	 */
	public static String getURLParamValue(String url, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			return null;
		}
		// ? #拆开，先把?拆开 a?b#c ->{a,b,c}
		String b = "";
		String[] abcArray = url.split("[?]");
		if (abcArray.length > 1) {
			String bc = abcArray[1];
			String[] bcArray = bc.split("#");
			b = bcArray[0];
		}
		if (StringUtils.isBlank(b)) {
			return null;
		}

		// 用&拆p, p1=1&p2=2 ，{p1=1,p2=2}
		String[] bArray = b.split("&");
		for (int i = 0; i < bArray.length; i++) {
			String bi = bArray[i];
			if (StringUtils.isBlank(bi))
				continue;
			String key = "";
			String value = "";
			String[] biArray = bi.split("="); // {p1,1}
			key = biArray[0];
			if (biArray.length > 1)
				value = biArray[1];
			if (key.equals(paramName)) {
				return value;
			}
		}
		return null;
	}

	/**
	 * MethodsTitle: 根据长度拆分字符串，返回一个List
	 * 
	 * @param txt
	 * @param len
	 * @return
	 */
	public static List<String> splitTxtByLen(String txt, int len) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isBlank(txt))
			return list;
		if (len == 0)
			return list;
		// txt="一二三四五六七八久十二二三四五六七八久十三二三四五六七八久十四二三四五六七八久十五二三四五六七八久十";
		String remain = txt;
		String put = "";
		for (int i = 0; i < 1 + (txt.length() / 10); i++) {
			if (remain.length() <= len) {
				list.add(remain);
				break;
			}
			put = txt.substring(i * len, (i + 1) * len);
			remain = txt.substring((i + 1) * len, txt.length());
			list.add(put);
		}
		return list;
	}

	public static String replaceAccessToken(String url, String name,
			String accessToken) {
		if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
			int index = url.indexOf(name + "=");
			if (index != -1) {
				StringBuilder sb = new StringBuilder();
				sb.append(url.substring(0, index)).append(name + "=")
						.append(accessToken);
				int idx = url.indexOf("&", index);
				if (idx != -1) {
					sb.append(url.substring(idx));
				}
				url = sb.toString();
			}

		}
		return url;
	}

	public static String replaceAccessTokenReg(String url, String name,
			String accessToken) {
		if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
			url = url.replaceAll("(" + name + "=[^&]*)", name + "="
					+ accessToken);
		}
		return url;
	}

	// 测试模块
	public static void main(String[] arg0) {
		String txt = "http://xinsanban.eastmoney.com/api/QuoteCenter/GPGS/GetGPGS?level=1&page=2&pagesize=50&sortType=ChangePercent&sortRule=-1";
		int len = 10;
		List<?> list = splitTxtByLen(txt, len);
		/* String result = inputURL(txt,"page","4"); */
		
		String result2 = StringUrl.replaceAccessToken(txt, "page", "4");
		System.out.println(list + "\n" + result2);
	}
}
