package veilingInterface;

import java.sql.SQLException;

public interface VeilingInterface<T> {
	
	boolean create(Object T);
	T retrieve(String ID);
	boolean update(Object T);
	void delete(Object T);

}
