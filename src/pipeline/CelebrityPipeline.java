package pipeline;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import dao.CelebrityDao;
import entity.Celebrity;

public class CelebrityPipeline implements Pipeline {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"spring/applicationContext.xml");

	private CelebrityDao celebrityDao = (CelebrityDao) applicationContext
			.getBean("celebrityDao");

	public void process(ResultItems resultItems, Task task) {
		Collection<Object> coll = resultItems.getAll().values();
		for (Object obj : coll) {
			Celebrity celebrity = (Celebrity) obj;
			try {
				celebrityDao.add(celebrity);
			} catch (Exception e) {
				continue;
			}
		}
	}

}
