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
		spider.addUrl("https://book.douban.com/tag/文学");
		spider.addUrl("https://book.douban.com/tag/小说");
		spider.addUrl("https://book.douban.com/tag/童话");
		spider.addUrl("https://book.douban.com/tag/经典");
		spider.addUrl("https://book.douban.com/tag/青春");
		spider.addUrl("https://book.douban.com/tag/历史");
		spider.addUrl("https://book.douban.com/tag/心理学");
		spider.addUrl("https://book.douban.com/tag/漫画");
		spider.addUrl("https://book.douban.com/tag/经济学");
		spider.addUrl("https://book.douban.com/tag/科普");
		spider.addUrl("https://book.douban.com/tag/哲学");
		spider.start();
	}

}
