package dao;

import entity.Celebrity;

public interface CelebrityDao {

	/**
	 * 向数据库添加新的影人
	 * @param celebrity
	 */
	void add(Celebrity celebrity);

}
