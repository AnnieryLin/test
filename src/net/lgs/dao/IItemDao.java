package net.lgs.dao;

/**
 * 实现对item_info表的增删查改
 * @author Administrator
 *
 */
public interface IItemDao {

	/**
	 * 查询整张表的proportion字段
	 * @return int[]
	 */
	int[] getProportion();
}
