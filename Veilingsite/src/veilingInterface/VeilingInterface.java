package veilingInterface;

import java.sql.SQLException;

public interface VeilingInterface<T> {
	
	boolean create(Object T);
	T retrieve(String ID);
	void update(Object T);
	void delete(Object T);

}
