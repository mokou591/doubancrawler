package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.selector.Html;

public class StringUtil {
	/**
	 * 获取两个正则表达式之间的值，带空检查
	 * 
	 * @param html
	 * @param left
	 * @param right
	 * @return
	 */
	public static  String getBetweenRegex(Html html, String left, String right) {
		String regex = left + "((.?){50})" + right;
		if (html.regex(regex, 1).toString() == null) {
			return "";
		} else {
			return html.regex(regex, 1).toString().trim();
		}
	}
	public static String getBetweenRegex(String infoStr, String left,
			String right) {
		Pattern pat = Pattern.compile(left+ "((.?){50})"+right);
		Matcher matcher = pat.matcher(infoStr);
		if(matcher.find()){
			return matcher.group(1);
		}else{
			return "";
		}
	}

	/**
	 * 获得字符串两个匹配值之间的值
	 * 
	 * @return
	 */
	public static  String getBetweenString(String string, String left, String right) {
		if (string.indexOf(left) > 0 && string.indexOf(right) > 0) {
			return string.substring(string.indexOf(left) + left.length(),
					string.indexOf(right)).trim();
		} else {
			return "";
		}

	}


}
