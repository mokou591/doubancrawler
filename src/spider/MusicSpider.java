package spider;

import pipeline.FilmPipeline;
import processor.FilmProcessor;
import us.codecraft.webmagic.Spider;

public class MusicSpider {
	public static void main(String[] args) throws Exception {
		Spider spider = Spider.create(new FilmProcessor());
		spider.thread(5);
		spider.addPipeline(new FilmPipeline());
		spider.addUrl("https://movie.douban.com/subject/26385746");
		for(int i=20000000;i<20001000;++i){
			spider.addUrl("https://movie.douban.com/subject/"+i);
		}
		spider.start();
	}

}
