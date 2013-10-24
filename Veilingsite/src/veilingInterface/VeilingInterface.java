package veilingInterface;

public interface VeilingInterface<T> {
	
	void create(Object T);
	T retrieve(String ID);
	void update(Object T);
	void delete(Object T);

}
