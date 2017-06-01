package processor;

import java.util.List;

import entity.Celebrity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
import util.StringUtil;

public class CelebrityProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		String urlstr = page.getRequest().getUrl().toString();
		// 根据页面判断爬取任务
		if (urlstr.contains("movie.douban.com/celebrity/")) {
			// 是可以提取出影人的页面，提取影人
			try {
				Celebrity celebrity = getCelebrity(page);
				page.putField(celebrity.getAllName(), celebrity);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} else if (urlstr.contains("movie.douban.com/subject/")
				&& urlstr.length() < 44) {// 是电影地址， 添加影人网页地址
			List<String> urlList = page.getHtml().links().all();
			for (String url : urlList) {
				if (url.contains("movie.douban.com/celebrity/")) {
					page.addTargetRequest(url);
				}
			}
		} else {// 是电影搜索页面，添加电影地址
			List<String> urlList = page.getHtml().links().all();
			for (String url : urlList) {
				if (url.contains("movie.douban.com/subject/")) {
					page.addTargetRequest(url);
				}
			}
		}

	}

	/**
	 * 从影人页面提取出影人对象
	 * 
	 * @param page
	 * @return
	 */
	private Celebrity getCelebrity(Page page) {
		Html html = page.getHtml();
		// 所有名字，中文在前
		String allName = html.$("#headline a.nbg", "title").toString().trim();
		// 海报地址
		String coverUrl = html.$("#headline a.nbg", "href").toString();
		// imdb编号
		String imdbnum = html.$("#headline a[href^=http://www.imdb.com/name]",
				"text").toString();
		// 剧情简介
		String intro = html.$("#intro div.bd .all", "innerHTML").toString();
		// 各个信息
		String infoStr = html.$("#headline ul", "innerHTML").toString()
				.replaceAll("<([^>]*)>", "");
		String gender = StringUtil.getBetweenRegex(infoStr, "性别:", "\n").trim();
		String birthdate = StringUtil.getBetweenRegex(infoStr, "出生日期:", "\n")
				.trim();
		String birthplace = StringUtil.getBetweenRegex(infoStr, "出生地:", "\n")
				.trim();
		String work = StringUtil.getBetweenRegex(infoStr, "职业:", "\n").trim();
		// 封装
		Celebrity celebrity = new Celebrity();
		celebrity.setAllName(allName);
		celebrity.setCoverUrl(coverUrl);
		celebrity.setImdbnum(imdbnum);
		celebrity.setIntro(intro);
		celebrity.setGender(gender);
		celebrity.setBirthdate(birthdate);
		celebrity.setBirthplace(birthplace);
		celebrity.setWork(work);
		return celebrity;
	}

}
