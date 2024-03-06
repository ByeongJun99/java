package test13;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {

		Map<String, Inventory> map = new HashMap<String, Inventory>();
		
		map.put("1", new Inventory("삼성 갤럭시S7", new Date(116, 2, 15), 30));
		map.put("2", new Inventory("LG G5", new Date(116, 1, 25), 20));
		map.put("3", new Inventory("애플 아이패드 Pro", new Date(115, 12, 23), 15));
		
		for (Map.Entry<String, Inventory> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		Inventory[] inv = map.values().toArray(new Inventory[0]);
		
		for (Inventory inventory : inv) {
			inventory.setGetDate(new Date());
			try {
				inventory.setGetAmount(10);
			} catch (AmountNotEnough e) {
				System.out.println("\n출고수량 부족시 ---------------------------------------------------------------");
				System.out.println("현재 재고가 부족합니다. 재고수량 확인하시기 바랍니다.");
				e.printStackTrace();
			}
		}
		
		System.out.println("\n출고 수량 10 적용시 ----------------------------------------------------------");
		for (Inventory inventory : inv) {
			System.out.println(inventory.toString());
		}
		
	}
	
}