package dao;

import entity.Book;

public interface BookDao {

	/**
	 * 向数据库添加新的书
	 * @param book
	 */
	void add(Book book);
}
