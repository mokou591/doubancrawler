package pipeline;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import dao.FilmDao;
import entity.Film;

public class ActivityPipeline implements Pipeline {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"spring/applicationContext.xml");

	private FilmDao filmDao = (FilmDao) applicationContext.getBean("filmDao");
	
	public void process(ResultItems resultItems, Task task) {
		Collection<Object> coll = resultItems.getAll().values();
		for (Object obj : coll) {
			Film film = (Film) obj;
			try{
			filmDao.add(film);
			}
			catch(Exception e){
				continue;
			}
		}
	}

}
