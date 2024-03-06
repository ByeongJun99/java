package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodsTest {

	public static void main(String[] args) {

		BufferedReader br = null;
		Goods goods = new Goods();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("다음 항목의 값을 입력하시오.");
		System.out.print("상품명 : ");
		try {
			String name = br.readLine();
			goods.setName(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("가격 : ");
		try {
			int price = Integer.parseInt(br.readLine());
			goods.setPrice(price);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		System.out.print("수량 : ");
		try {
			int quantity = Integer.parseInt(br.readLine());
			goods.setQuantity(quantity);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n입력된 결과는 다음과 같습니다.");
		System.out.println(goods.toString());
		System.out.println("총 구매 가격 : " + goods.getPrice()*goods.getQuantity() + " 원");
	}

}
