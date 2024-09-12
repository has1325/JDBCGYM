package space.jdbc.precure;

import java.sql.Date;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		
		Scanner rs = new Scanner(System.in);
		PrecureDao precureDao = new JdbcPrecureDao();
		
		Precure precure = new Precure();
		
		precure.setId(15);
		precure.setName("큐어 화이트");
		precure.setAge(15);
		precure.setColor("분홍");
		precure.setType("꿈");
		precure.setBirth(Date.valueOf("2025-10-31"));
		precure.setItem("하트풀 코뮨");
		precure.setComments("大いなる夢の力");
		
//		precureDao.insert(precure);
		
//		List<Precure> precureDaos = precureDao.findAll();
//		
//		for (Precure precure2 : precureDaos) {
//			System.out.println(precure2);
//		}
		
//		System.out.println(precureDao.findById(4));
		
		precureDao.update(precure);
		
//		precureDao.deleteById(rs.nextInt());
		

	}

}
