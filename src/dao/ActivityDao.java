package dao;

import entity.Activity;

public interface ActivityDao {

	/**
	 * 向数据库添加新的活动
	 * @param activity
	 * @return 
	 */
	Integer add(Activity activity);
}
