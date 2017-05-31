package dao;

import entity.Music;

public interface MusicDao {

	/**
	 * 向数据库添加新的音乐
	 * @param music
	 */
	void add(Music music);
}
