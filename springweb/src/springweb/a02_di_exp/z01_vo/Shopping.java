package springweb.a02_di_exp.z01_vo;

import java.util.ArrayList;

public class Shopping {
	private String shopName;
	private ArrayList<ShoppingProduct> plist;
	public Shopping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shopping(String shopName) {
		super();
		this.shopName = shopName;
	}
	public void shoppingList(){
		System.out.println(shopName + "에서 구매한 물건 list");
		int cnt=1;
		for(ShoppingProduct prod : plist){
			System.out.println(cnt+++" - "+prod.getName());
		}
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ArrayList<ShoppingProduct> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<ShoppingProduct> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "Shopping [shopName=" + shopName + ", plist=" + plist + "]";
	}
	
	
}
