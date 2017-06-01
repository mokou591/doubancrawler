package spider;

import pipeline.CelebrityPipeline;
import processor.CelebrityProcessor;
import us.codecraft.webmagic.Spider;

public class CelebritySpider {
	public static void main(String[] args) throws Exception {
		Spider spider = Spider.create(new CelebrityProcessor());
		spider.thread(5);
		spider.addPipeline(new CelebrityPipeline());
		
//		spider.addUrl("https://movie.douban.com/subject/1292052");//单个电影
//		spider.addUrl("https://movie.douban.com/celebrity/1054521");//单个影人
		spider.addUrl("https://movie.douban.com/tag/青春");
		spider.addUrl("https://movie.douban.com/tag/文艺");
		spider.addUrl("https://movie.douban.com/tag/爱情");
		spider.addUrl("https://movie.douban.com/tag/喜剧");
		spider.addUrl("https://movie.douban.com/tag/剧情");
		spider.addUrl("https://movie.douban.com/tag/动画");
		spider.addUrl("https://movie.douban.com/tag/科幻");
		spider.addUrl("https://movie.douban.com/tag/动作");
		spider.addUrl("https://movie.douban.com/tag/经典");
		spider.addUrl("https://movie.douban.com/tag/悬疑");
		spider.start();
	}

}
