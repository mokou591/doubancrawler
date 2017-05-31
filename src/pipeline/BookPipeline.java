package pipeline;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import dao.BookDao;
import entity.Book;

public class BookPipeline implements Pipeline {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"spring/applicationContext.xml");

	private BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
	
	public void process(ResultItems resultItems, Task task) {
		Collection<Object> coll = resultItems.getAll().values();
		for (Object obj : coll) {
			Book book = (Book) obj;
			try{
			bookDao.add(book);
			}
			catch(Exception e){
				continue;
			}
		}
	}

}
