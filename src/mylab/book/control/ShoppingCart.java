package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	// 장바구니에 출판물 추가
	public void addItem(Publication publication) {
		items.add(publication);
		System.out.println(publication.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}

	// 장바구니에서 출판물 제거
	public void removeItem(Publication publication) {
		items.remove(publication);
		System.out.println(publication.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
	}

	// 전체 가격 합계
	public int getTotalPrice() {
		int total = 0;
		for (Publication p : items) {
			total += p.getPrice();
		}
		return total;
	}

	// 출판물 타입별로 차등 할인율을 적용
	public int getDiscountedPrice() {
		double total = 0;
		for (Publication p : items) {
			if (p instanceof Magazine) {
				total += p.getPrice() * 0.9;
			} else if (p instanceof Novel) {
				total += p.getPrice() * 0.85;
			} else if (p instanceof ReferenceBook) {
				total += p.getPrice() * 0.8;
			} else {
				total += p.getPrice();
			}
		}
		return (int) total;
	}

	// 장바구니 내용 출력
	public void printCart() {
		System.out.println("====== 장바구니 내용 ======");
		for (int i = 0; i < items.size(); i++) {
			Publication p = items.get(i);
			System.out.println((i + 1) + ". " + p.getTitle() + " - " + String.format("%,d", p.getPrice()) + "원");
		}
		System.out.println("총 가격: " + String.format("%,d", getTotalPrice()) + "원");
		System.out.println("할인 적용 가격: " + getDiscountedPrice() + "원");
	}

	// 장바구니 통계 출력
	public void printCartStatistics() {
		int magazineCount = 0, novelCount = 0, referenceCount = 0;
		for (Publication p : items) {
			if (p instanceof Magazine) {
				magazineCount++;
			} else if (p instanceof Novel) {
				novelCount++;
			} else if (p instanceof ReferenceBook) {
				referenceCount++;
			}
		}
		System.out.println("====== 장바구니 통계 ======");
		System.out.println("잡지: " + magazineCount + "권");
		System.out.println("소설: " + novelCount + "권");
		System.out.println("참고서: " + referenceCount + "권");
		System.out.println("총 출판물: " + items.size() + "권");
	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Publication p1 = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		Publication p2 = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		Publication p3 = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		Publication p4 = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		Publication p5 = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");

		cart.addItem(p1);
		cart.addItem(p2);
		cart.addItem(p3);
		cart.addItem(p4);
		cart.addItem(p5);

		cart.printCart();
		cart.printCartStatistics();

		cart.removeItem(p3);
		cart.printCart();
	}
}