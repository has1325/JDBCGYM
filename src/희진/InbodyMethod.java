package 희진;

import Gym.Logic.Common.Input;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class InbodyMethod {

	private static JDBCInbodyDao iDao = new JDBCInbodyDao();
	int number = Input.intScan();
	Scanner scanner = new Scanner(System.in);

	static void insertInbody() {
		Inbody inbody = new Inbody();
		System.out.println("인바디 정보를 입력해주세요.");
		
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		inbody.setM_date(currentTimestamp);
		System.out.println(currentTimestamp);

		System.out.println("몸무게를 입력하세요");
		double weight = Input.doubleScan();
		inbody.setWeight(weight);

		System.out.println("키를 입력하세요");
		double height = Input.doubleScan();
		inbody.setHeight(height);

		System.out.println("지방량을 입력하세요");
		double fat = Input.doubleScan();
		inbody.setFat(fat);

		System.out.println("근육량을 입력하세요");
		double muscle = Input.doubleScan();
		inbody.setMuscle(muscle);

		System.out.println("신체나이를 입력하세요");
		int body_age = Input.intScan();
		inbody.setBody_age(body_age);

		System.out.println("신체점수를 입력하세요");
		int body_score = Input.intScan();
		inbody.setBody_score(body_score);

		System.out.println("회원번호를 입력하세요");
		int member_num = Input.intScan();
		inbody.setMember_num(member_num);

		if (iDao.insert(inbody)) {
	        System.out.println("인바디 정보가 성공적으로 추가되었습니다.");
	    } else {
	        System.out.println("인바디 추가에 실패하였습니다.");
	    }
	}

	static void findByInbodyNum() {
		System.out.println("찾으실 인바디 번호를 입력하세요.: ");
		int inbodyNum = Input.intScan();

		Inbody inbody2 = iDao.findBybodynum(inbodyNum);

		if (inbody2 != null) {
			System.out.println("Inbody_num :" 
						+ inbody2.getInbody_Num() + "M_date :" 
						+ inbody2.getM_date() + "Weight :"
						+ inbody2.getWeight() + "Height :" 
						+ inbody2.getHeight() + "Fat :" 
						+ inbody2.getFat() + "Muscle :"
						+ inbody2.getMuscle() + "Body_age :" 
						+ inbody2.getBody_age() + "Body_score :"
						+ inbody2.getBody_score() + "Member_num :" 
						+ inbody2.getMember_num() + "Member_num :");
			System.out.println("해당 회원의 인바디 정보를 검색하였습니다.");
		} else {
			System.out.println("인바디 정보를 검색하지 못하였습니다.");
		}
	}

	static void findAllInbody() {
		System.out.println("전체 회원의 인바디 정보를 검색합니다.");
		List<Inbody> inbodys = iDao.findAll();
		for (Inbody inbody : inbodys) {
			System.out.println(inbody);
		}
	}

	static void deleteInbody() {
		System.out.println("삭제할 인바디 번호를 입력하세요: ");
		int inbodyNum = Input.intScan();//

		if (iDao.deleteBybodynum(inbodyNum)) {
			System.out.println("성공적으로 삭제되었습니다");
		} else {
			System.out.println("인바디 정보 삭제에 실패하였습니다.");
		}
	}
}