package space.jdbc.Card;

import java.util.List;

public interface CardDao {

	boolean insert(Card card);
	List<Card> findAll();
	Card findById(String CardNumber);
	
	boolean update(Card card);
	boolean deleteById(String CardNumber);
}
