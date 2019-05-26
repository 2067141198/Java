/*
*如何设计一个类
*一.根据需求列出功能
*1.传 年、月、日构造日期类
*2.在当前日期上增加多少天
*3.在当前日期上减少多少天
*4.可以返回字符创 String 的方法		"2019-05-20"
*5.加一些限制  年支持的范围[1900,2100]
*6.如果给定两个日期，希望计算出下相差的天数
*二.设计属性
*1.年、月、日
*/

public class Date {
	private int year;
	private int month;
	private int day;
	
	private Date(Date other) {
		this(other.year, other.month, other.day);
	}

	public Date(int year, int month, int day) {
		if(year < 1900 || year > 2100) {
			System.out.println("输入的年份：" + year + "不合法");
			return;
		}
		if(month < 1 || month > 12) {
			System.out.println("输入的月份：" + month + "不合法");
			return;
		}
		if(day < 1 || day > getDayOfMonth(year, month)) {
			System.out.println("输入的日期：" + day + "不合法");
			return;
		}
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void add(int days) {
		//必须是正数
		if(days < 0){
			System.out.println("输入增加的天数：" + days + "必须是正数");
			return;
		}
		day += days;
	}
	
	public void sub(int days) {
		//必须是正数
		if(days < 0){
			System.out.println("输入增加的天数：" + days + "必须是正数");
			return;
		}
		day -= days;
		if(day < 0) {
			month--;
			if(month < 0) {
				year--;
				month = 12;
			}
			day += getDayOfMonth(year, month - 1);
		}
	}
	
	public String toString() {
		return String.	format("%4d-%2d-%2d",year,month,day);
	}
	
	public static int differ (Date d1, Date d2) {
		if(!isGreatThan(d1, d2)) {
			System.out.println("时间不合法");
			return -1;
		}
		int days = 0;
		Date tmp = new Date(d1);
		while(isGreatThan(tmp, d2)) {
			tmp.sub(1);
			days++;
		}
		return days;
	}
	
	//内部使用的方法
	private static final int[] DAY_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};

	private static int getDayOfMonth(int year, int month) {
		int days = DAY_OF_MONTH[month - 1];
		if(month == 2 && isLeapYear(year)) {
			days = 29;
		}
		return days;
	}
	
	private static boolean isLeapYear(int year) {
		if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0)	
			return true;
		return false;
	}
	
	private static boolean isGreatThan (Date d1, Date d2) {
		if(d1.year > d2.year)
			return true;
		if(d1.year == d2.year && d1.month > d2.month)
			return true;
		if(d1.year == d2.year && d1.month == d2.month && d1.day == d2.day)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Date date = new Date(2019,5,20);
		System.out.println(date.toString());
		date.add(10);
		System.out.println(date.toString());
		date.add(10);
		System.out.println(date.toString());
		date.sub(20);
		System.out.println(date.toString());
		
		Date taday = new Date(2019,5,20);
		Date intern = new Date(2019,12,1);
		int a = Date.differ(intern,taday);
		System.out.println("距离目标日还有：" + a + "天");
	}
}



