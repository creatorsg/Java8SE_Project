package chapter5.oop.good;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
// 		abstract method로 인해 생성 불가 
//      Employee emp = new Employee();
    	Employee emp1 = new MereClerk("철수",100);
    	Employee emp2 = new Manager("철수",200, "인사부");
    	Manager manager = new Manager("둘리", 200, "개발부");
    	System.out.println(manager.getDeptName());
    	System.out.println(manager.getSalary());
    	System.out.println(manager.getName());
    	
    	//불가능
//    	System.out.println(emp2.getDeptName());
    	System.out.println(emp2.getSalary());
    	System.out.println(emp2.getName());

    	//이렇게 주입하면 가능 
    	Manager mgr = (Manager)emp2;
    	System.out.println(mgr.getDeptName());

    	
        MereClerk mereClerk1 = new MereClerk("철수", 100);
        MereClerk mereClerk2 = new MereClerk("영희", 100);
        
        //Employee 타입의 배열 선언 (Heterogeneous)
        Employee[] emps = new Employee[3];
        emps[0] = new MereClerk("철수",100);
        emps[1] = new MereClerk("영희",100);
        emps[2] = new Manager("홍길동",200,"인사부");
        
        for(Employee emp : emps) {
        	System.out.println("현재 월급입니다.");
        	if(emp instanceof Manager) {
        		System.out.println("부서명 = " + ((Manager)emp).getDeptName() + " ");
        	}
        	System.out.println(emp.getName() + "의 현재 월급은" + emp.getSalary() + " 만원 입니다.");
        	
        	emp.manageSalary(10);
        	
        	System.out.println("올린 후의 월급입니다.");
        	if(emp instanceof Manager) {
        		System.out.println("부서명 = " + ((Manager)emp).getDeptName() + " ");
        	}
        	System.out.println(emp.getName() + "의 현재 월급은" + emp.getSalary() + " 만원 입니다.");
        }
        
        
        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");

        System.out.println("");
        
        
        System.out.println("올린 후의 월급입니다.");
        
        mereClerk1.manageSalary(10);
        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
        
        mereClerk2.manageSalary(10);
        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
        
        manager.manageSalary(10);
        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");
        
   }
}

