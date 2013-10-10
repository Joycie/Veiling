package veilingInterface;

public interface VeilingInterface<T> {
	
	void Create(Object T);
	T Retrieve(String ID);
	void Update(Object T);
	void Delete(Object T);

}
