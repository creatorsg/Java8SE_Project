package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	private Publication[] publications;

	public StatisticsAnalyzer(Publication[] publications) {
		this.publications = publications;
	}

	public void printStatistics() {
		int novelCount = 0, novelSum = 0;
		int refCount = 0, refSum = 0;
		int magCount = 0, magSum = 0;
		int year2007Count = 0;

		for (Publication p : publications) {
			if (p instanceof Novel) {
				novelCount++;
				novelSum += p.getPrice();
			} else if (p instanceof ReferenceBook) {
				refCount++;
				refSum += p.getPrice();
			} else if (p instanceof Magazine) {
				magCount++;
				magSum += p.getPrice();
			}
			if (p.getPublishDate() != null && p.getPublishDate().startsWith("2007")) {
				year2007Count++;
			}
		}

		int total = publications.length;

		System.out.println("===== 출판물 통계 분석 =====");

		System.out.println("1. 타입별 평균 가격:");
		System.out.println("   - 소설: " + String.format("%,d", novelCount == 0 ? 0 : novelSum / novelCount) + "원");
		System.out.println("   - 참고서: " + String.format("%,d", refCount == 0 ? 0 : refSum / refCount) + "원");
		System.out.println("   - 잡지: " + String.format("%,d", magCount == 0 ? 0 : magSum / magCount) + "원");
		System.out.println();

		System.out.println("2. 출판물 유형 분포:");
		System.out.println("   - 소설: " + String.format("%.2f", novelCount * 100.0 / total) + "%");
		System.out.println("   - 참고서: " + String.format("%.2f", refCount * 100.0 / total) + "%");
		System.out.println("   - 잡지: " + String.format("%.2f", magCount * 100.0 / total) + "%");
		System.out.println();

		System.out.println("3. 2007년에 출판된 출판물 비율: " + String.format("%.2f", year2007Count * 100.0 / total) + "%");
	}
}