package dao;

import entity.Film;

public interface FilmDao {

	/**
	 * 向数据库添加新的电影
	 * @param film
	 */
	void add(Film film);

}
