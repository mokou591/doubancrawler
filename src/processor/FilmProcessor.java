package processor;

import java.util.List;

import entity.Film;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class FilmProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(1).setSleepTime(3000);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		// 判断是否可以是可以提取出影人的页面
		if (page.getRequest().getUrl().toString()
				.contains("movie.douban.com/subject/")) {
			try {
				Film film = getFilm(page);
				page.putField(film.getOriginalName(), film);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} else {
			// 添加电影页面
			List<String> urlList = page.getHtml().links().all();
			for (String url : urlList) {
				if (url.contains("movie.douban.com/subject/")) {
					System.out.println(url);
					page.addTargetRequest(url);
				}
			}
		}

	}

	/**
	 * 从电影页面提取出电影对象
	 * 
	 * @param page
	 * @return
	 */
	private Film getFilm(Page page) {
		Html html = page.getHtml();
		// 标题
		String chsName = html.$("title", "text").toString()
				.replace("(豆瓣)", "").trim();
		String originalName = html.$("#mainpic img", "alt").toString();
		// 海报地址
		String posterUrl = html.$("#mainpic img", "src").toString();
		// 导演 编剧
		List<String> tempList = html.$("#info *", "text").all();
		String tempInfo = "";
		for (String temp : tempList) {
			tempInfo += temp.replace("/", "").replace(":", "").trim() + " ";
		}
		String director = tempInfo.substring(tempInfo.indexOf("导演") + 2,
				tempInfo.indexOf("编剧")).trim();
		String writer = tempInfo.substring(tempInfo.indexOf("编剧") + 2,
				tempInfo.indexOf("主演")).trim();
		// 类型
		List<String> genreList = html.$("#info span[property=v:genre]", "text")
				.all();
		String genre = "";
		for (String genreSingle : genreList) {
			genre += genreSingle + " ";
		}
		// 制片地区 语言
		String tempInnerHTML = html.$("#info", "innerHTML").toString()
				.replace("\n", "");
		tempInnerHTML = tempInnerHTML.substring(
				tempInnerHTML.indexOf("制片国家/地区:"),
				tempInnerHTML.indexOf("上映日期:"));
		String region = tempInnerHTML.substring(
				tempInnerHTML.indexOf("制片国家/地区:</span> ")
						+ "制片国家/地区:</span> ".length(),
				tempInnerHTML.indexOf("<br"));
		String language = tempInnerHTML.substring(
				tempInnerHTML.indexOf("语言:</span> ") + "语言:</span> ".length(),
				tempInnerHTML.lastIndexOf("<br"));
		// 年份
		Integer year = Integer.parseInt(html.$("span.year", "text").toString()
				.replaceAll("[()]", ""));
		// 片长
		Integer length = Integer.parseInt(html.$(
				"#info span[property=v:runtime]", "content").toString());
		// imdb
		String imdbnum = html.$("#info a[href^=http://www.imdb.com/title]",
				"text").toString();
		// 演员
		List<String> actorList = html.$("#info span.actor a", "text").all();
		String actor = "";
		for (String actorStr : actorList) {
			actor += actorStr + " / ";
		}
		if (actorList.size() > 0)
			actor = actor.substring(0, actor.length() - 3);
		// 剧情简介
		String intro = html.$("#link-report span[property=v:summary]", "text")
				.toString();
		// 封装
		Film film = new Film();
		film.setActor(actor);
		film.setChsName(chsName);
		film.setDirector(director);
		film.setWriter(writer);
		film.setGenre(genre);
		film.setOriginalName(originalName);
		film.setIntro(intro);
		film.setLanguage(language);
		film.setYear(year);
		film.setLength(length);
		film.setPosterUrl(posterUrl);
		film.setRegion(region);
		film.setImdbnum(imdbnum);
		return film;
	}

}
