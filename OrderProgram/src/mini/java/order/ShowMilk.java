package mini.java.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowMilk {
	
	private DrinkName decideMilk;

	private List<DrinkName> milk = new ArrayList<DrinkName>();
	DrinkSize size = new DrinkSize(4, 2);
	Order order = new Order();
	Scanner sc = new Scanner(System.in);

	public ShowMilk() {

		milk.add(new DrinkName("Milk : ", "Just Milk")); // 흰우유
		milk.add(new DrinkName("Banana Milk : ", "Banana Flavor Milk")); // 바나나우유
		milk.add(new DrinkName("Strawberry Milk : ", "Strawberry Flavor Milk")); // 딸기우유
		// MilkList의 메뉴들
	}
	
	public void showMilkList() {
		
		System.out.println("\n" + "[ ***** milk List ***** ]");
		for (int i = 0; i < milk.size(); i++) {
			DrinkName drink = milk.get(i);
			System.out.println((i + 1) + ". " + drink.getName() + drink.getWhat());
			// milk 리스트에 있는 메뉴들에게 번호 부여
		}
		System.out.println("\n" + "0. Get back menu");
		// 0번 입력시 메뉴로 돌아간다고 출력
		
		System.out.print("\n" + "Number : ");
		int drinkChoice = sc.nextInt();
		// 입력한 상품선택
		if (drinkChoice < 0 && drinkChoice > milk.size()) {
			System.out.println("\n" + "!!! Wrong number !!!");
			// 다른 번호를 입력하면 잘못된 번호라고 출력
			try {
				Thread.sleep(3000);
				// 안내창 읽을수있도록 시간지연
			} catch (Exception e) {
				e.printStackTrace();
			}
			showMilkList();
			// 리스트로 돌아가기
		}
		else if (drinkChoice == 0) {
			ShowMainMenu showMainMenu = new ShowMainMenu();
			showMainMenu.showMain();
			// 0번입력시 메인화면으로 돌아감
		}
		decideMilk = milk.get(drinkChoice-1);
		// 사용자가 선택한 숫자와 리스트의 숫자가 일치하도록 -1해줌
		System.out.println("\n" + "** | Your choice | " + decideMilk.getName() + decideMilk.getWhat() + " | **");
		//고른 음료가 창에뜨고
		System.out.println("\n" + "** | Choose Size | "
				+ "1. Big : " + size.getBig() + "$ | "
				+ "2. Small : " + size.getSmall() + "$ | **");
		System.out.print("\n" + "Number : ");
		// 사이즈를 선택하라는 창이 뜬다
		int sizeChoice = sc.nextInt();
		int decideSize = 0;
		// 결정되는 사이즈 정보를 넣을 decideSize
		if (sizeChoice == 1) {
			decideSize = size.getBig();
			// 1번을 선택하면 Big 사이즈
		}
		else if (sizeChoice == 2) {
			decideSize =  size.getSmall();
			// 2번을 선택하면 Small사이즈
		}
		else {
			System.out.println("\n" + "!!! Wrong number !!!");
			// 그외 번호를 누르면 잘못된 번호라고 출력
			try {
				Thread.sleep(3000);
				// 안내창 읽을수있도록 시간지연
				showMilkList();
				// 리스트로 돌아가기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("\n" + "** | Check | "
				+ decideMilk.getName() + decideMilk.getWhat()
				+ " | " + decideSize + "$ | **");
		System.out.println("\n" + "Put in your basket?");
		System.out.println("1. Yes 2. No");
		System.out.print("\n" + "Number : ");
		// 선택한것들 보여주고 장바구니에 담을것인지 묻기
		int howBasket = sc.nextInt();
		
		if (howBasket ==1) {
			order.addBasket(decideMilk);
			order.addPrice(decideSize);
			System.out.println("\n" + "Well done!");
			// 장바구니에 선택한 물건과 사이즈, 가격정보 대입
		}
		else if (howBasket == 2) {
			System.out.println("\n" + "Get back list");
		}
		else {
			System.out.println("\n" + "!!! Wrong number !!!");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		showMilkList();

	} // showMilkList
	
	public DrinkName getDecideSoda() {
		return decideMilk;
	}

} // class
