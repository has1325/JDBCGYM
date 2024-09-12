package space.jdbc.precure;

import java.util.List;

public interface PrecureDao {

	boolean insert(Precure precure);
	
	List<Precure> findAll();
	
	Precure findById(int id);
	
	boolean update(Precure precure);
	
	boolean deleteById(int id);
}
