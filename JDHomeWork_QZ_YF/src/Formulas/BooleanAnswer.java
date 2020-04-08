package Formulas;

import java.util.ArrayList;
import java.util.Stack;

public class BooleanAnswer {
	
	static boolean isSymbol(String item) {
		return item.matches("\\D+");
	}
	
	static boolean booleanAnswer(ArrayList<String> exercise, ArrayList<String> result ) {
		int resultInBrackets = 0;	// 括号内计算的结果
		int left = 0, right = 0, i = 0, index = 0;	// 左右括号的索引
		String item = "";
		Formula2 formula2;
		
		// 获取左右括号的位置
		for(i = 0; i < exercise.size(); i++) {
			if(exercise.get(i).equalsIgnoreCase("(")) 
				left = i;
			if(exercise.get(i).equalsIgnoreCase(")"))
				right = i;
		}
		
		// 如果没有括号，说明是二元运算
		if(left == 0 && right == 0) {
			formula2 = new Formula2(Integer.parseInt(exercise.get(0)), exercise.get(1), Integer.parseInt(exercise.get(2)), false);
			return formula2.result.equalsIgnoreCase(result.get(0));
		}
		
		// 否则就是三元运算，先计算出括号内的结果
		formula2 = new Formula2(Integer.parseInt(exercise.get(left + 1)), exercise.get(left + 2), Integer.parseInt(exercise.get(right - 1)), false);
		resultInBrackets = Integer.parseInt(formula2.result);
		// 将括号内结果与另一数值进行运算
		for(int j = 0; j < exercise.size(); j++) {
			item = exercise.get(j);
			if(j >= left && j <= right)	// 跳过括号区域
				continue;
			if(!isSymbol(item))	// 让索引到达运算符处
				continue;
			
			if((j > exercise.size() / 2)) {
				index = j + 1;
				formula2 = new Formula2(resultInBrackets, item, Integer.parseInt(exercise.get(index)), false);
			}
			else {
				index = j - 1;
				formula2 = new Formula2(Integer.parseInt(exercise.get(index)), item, resultInBrackets, false);
			}
			return formula2.result.equalsIgnoreCase(result.get(0));
		}
		return false;
	}
}
