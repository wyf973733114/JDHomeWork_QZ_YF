package Formulas;

import java.util.HashMap;
import java.util.Map;

public class MockResult {
	
	int[] numsArr = {1, 2};
	String operator;
	String exercise;
	String resultStr;
	int answer;
	
	// 输入数字数组和运算符，返回运算结果，这里假设只有两个数
	
	int setAnswer(int[] numsArr, String operator) {
		int res = 0;
		switch(operator) {
			case "+": 
				res = numsArr[0] + numsArr[1];
				break;
			case "-":
				res = numsArr[0] - numsArr[1];
				break;
			case "*":
				res = numsArr[0] * numsArr[1];
				break;
			case "/":
				res = numsArr[0] / numsArr[1];
				break;
			default:
				res = 0;
				break;
		}
		return res;
	}

	// 生成最终的表达式字符串
	String setResultStr(int[] numsArr, String operator, int answer) {
		return numsArr[0] + " " + operator + " " + numsArr[1] + " = " + answer;
	}
	
	// 构造函数
	MockResult(int[] numsArr, String operator) {
		this.numsArr = numsArr;
		this.operator = operator;
		this.answer = setAnswer(numsArr, operator);
		this.exercise = numsArr[0] + " " + operator + " " + numsArr[1] + " ="; 
		this.resultStr = setResultStr(numsArr, operator, this.answer);
	}
	
	// 返回随机运算符(没有除法，因为除法有些复杂)
	static String RandomOperator() {
		int a = (int)(Math.random() * 10) / 3;
		String res = "+";
		switch(a) {
			case 0:
				res = "+";
				break;
			case 1:
				res = "-";
				break;
			case 2: 
				res = "*";
				break;
			case 3:
				res = "/";
				break;
			default:
				break;
		}
		return res;
	}
	
	public static void main(String[] args) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		Map<String, Integer> map2 = new HashMap<String, Integer>();
//		Map[] maps = {};
		
		int[] arr = {0, 0};
		
		for(int i = 0; i < 10; i++) {
			arr[0] = (int)(Math.random() * 10);
			arr[1] = (int)(Math.random() * 10);
			MockResult data = new MockResult(arr, RandomOperator());
			System.out.println(data.resultStr);
		}
		
		
	}
}
