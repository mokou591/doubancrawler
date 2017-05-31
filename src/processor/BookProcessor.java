package processor;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
import util.StringUtil;
import entity.Book;

public class BookProcessor implements PageProcessor {

	private Site site = Site
			.me()
			.setRetryTimes(1)
			.setSleepTime(3000)
			.addHeader(
					"User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6");

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		// 判断是否可以是可以提取出书的页面
		if (page.getRequest().getUrl().toString()
				.contains("book.douban.com/subject/")) {
			try {
				Book book = getBook(page);
				page.putField(book.getOriginalName(), book);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} else {
			// 添加书页面
			List<String> urlList = page.getHtml().links().all();
			for (String url : urlList) {
				if (url.contains("book.douban.com/subject/")
						&& url.length() <= 42) {
					page.addTargetRequest(url);
				}
			}
		}

	}

	/**
	 * 从书页面提取出书对象
	 * 
	 * @param page
	 * @return
	 */
	/**
	 * @param page
	 * @return
	 */
	private Book getBook(Page page) {
		Html html = page.getHtml();
		// 标题
		String chsName = html.$("title", "text").toString().replace("(豆瓣)", "")
				.trim();
		// 各个信息的字符串
		String infoInnerHTML = html.$("#info", "innerHTML").all().toString();
		infoInnerHTML = infoInnerHTML.replaceAll("<([^>]*)>", "")
				.replace("&nbsp;", "").replace("\n", "").trim()
				+ "end";
		// 获取各个信息
		String author = StringUtil.getBetweenString(infoInnerHTML, "作者:", "出版社:");
		String press = StringUtil.getBetweenRegex(html, "出版社:</span>", "<br");
		String originalName = StringUtil.getBetweenRegex(html, "原作名:</span>", "<br");
		originalName = originalName.equals("")?chsName:originalName;
		String translator = StringUtil.getBetweenString(infoInnerHTML, "译者:", "出版年");
		String year = StringUtil.getBetweenRegex(html, "出版年:</span>", "<br");
		String bookPage =  StringUtil.getBetweenRegex(html, "页数:</span>", "<br");
		String price =  StringUtil.getBetweenRegex(html, "定价:</span>", "<br");
		String isbn =  StringUtil.getBetweenRegex(html, "ISBN:</span>", "<br");
		// 封面地址
		String coverUrl = html.$("a.nbg", "href").get();
		// 类型
		List<String> genreList = html.$("a.tag", "text").all();
		String genre = "";
		for (String genreSingle : genreList) {
			genre += genreSingle + " / ";
		}
		genre = genre.substring(0, genre.length() - 3);
		// 目录
		Selectable sel = html.$("div[id^=dir][id$=full]", "innerHTML");
		String catalog = "";
		if (sel.get() != null) {
			catalog = sel.get().replaceAll("<([^>]*)>", "");
		}
		catalog = catalog.replace("· · · · · · (", "").replace("收起)", "");
		// 剧情简介
		String intro = html.$(".intro", "innerHTML").get()
				.replaceAll("<([^>]*)>", "");
		// 封装
		Book book = new Book();
		book.setCoverUrl(coverUrl);
		book.setChsName(chsName);
		book.setGenre(genre);
		book.setOriginalName(originalName);
		book.setIntro(intro);
		book.setAuthor(author);
		book.setPress(press);
		book.setYear(year);
		book.setTranslator(translator);
		book.setPage(bookPage);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setCatalog(catalog);
		book.setCoverUrl(coverUrl);
		return book;
	}


}
