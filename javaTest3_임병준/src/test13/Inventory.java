package test13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
	private String productName;	// 상품명
	private Date putDate;	// 입고일
	private Date getDate;	// 출고일
	private int putAmount;	// 입고수량
	private int getAmount;	// 출고수량
	private int inventoryAmount;	// 재고수량
	
	public Inventory() {
		super();
	}

	public Inventory(String productName, Date putDate, int putAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.putAmount = putAmount;
		this.inventoryAmount = putAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough {
		this.getAmount = getAmount;
		this.inventoryAmount -= getAmount;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return productName + (productName.equals("LG G5") ? ", \t\t" : ", \t") + sdf.format(putDate) + " 입고, " 	+ putAmount
				+ "개, " + ((getAmount != 0) ? sdf.format(new Date()) + " 출고, " : "null ")
				+ getAmount + "개, 재고 " + inventoryAmount + "개";
	}
}
