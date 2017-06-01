package spider;

import pipeline.BookPipeline;
import processor.BookProcessor;
import us.codecraft.webmagic.Spider;

public class BookSpider {
	public static void main(String[] args) throws Exception {
		Spider spider = Spider.create(new BookProcessor());
		spider.thread(5);
		spider.addPipeline(new BookPipeline());
		//可附参数start=
//		spider.addUrl("https://book.douban.com/subject/20392524/");
		spider.addUrl("https://book.douban.com/tag/文艺");
		spider.addUrl("https://book.douban.com/tag/设计");
		spider.addUrl("https://book.douban.com/tag/悬疑");
		spider.addUrl("https://book.douban.com/tag/言情");
		spider.start();
	}

}
