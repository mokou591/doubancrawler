package spider;

import pipeline.FilmPipeline;
import processor.FilmProcessor;
import us.codecraft.webmagic.Spider;

public class FilmSpider {
	public static void main(String[] args) throws Exception {
		Spider spider = Spider.create(new FilmProcessor());
		spider.thread(5);
		spider.addPipeline(new FilmPipeline());
		spider.addUrl("https://movie.douban.com/tag/青春");
		spider.addUrl("https://movie.douban.com/tag/文艺");
//		spider.addUrl("https://movie.douban.com/subject/"+i);
		spider.start();
	}

}
