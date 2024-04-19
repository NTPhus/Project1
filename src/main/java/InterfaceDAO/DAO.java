package InterfaceDAO;

import java.util.ArrayList;

public interface DAO<T> {
	ArrayList<T> selectAll();
	T selectById(T t);
	int insert(T tg);
	int insertAll(ArrayList<T> list);
	int delete(T tg);
	int deleteAll(ArrayList<T> list);
	int update(T tg);
}
