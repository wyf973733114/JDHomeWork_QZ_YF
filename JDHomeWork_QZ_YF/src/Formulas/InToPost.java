package Formulas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class InToPost {
	private Stack<String> theStack;
	private List<String> input;
	private List<String> output;

	public InToPost(String des) {
		theStack = new Stack<String>();
		input = new ArrayList<String>(Arrays.asList(des.split("\\s+")));
		input.remove(0);
		input.remove(input.size() - 1);
		output = new ArrayList<String>();
	}

	public List<String> doTrans() {
		System.out.println(input);
		for (int j = 0; j < input.size(); j++) {
			String ch = input.get(j);
			switch (ch) {
			case "+":
			case "-":
				gotOper(ch, 1);
				break;
			case "*":
			case "/":
				gotOper(ch, 2);
				break;
			case "(":
				theStack.push(ch);
				break;
			case ")":
				gotParen(ch);
				break;
			default:
				output.add(ch);
				break;
			}
		}
		while (!theStack.isEmpty()) {
			output.add(theStack.pop());
		}
		System.out.println(output);
		return output;
	}

	public void gotOper(String opThis, int prec1) {
		while (!theStack.isEmpty()) {
			String opTop = theStack.pop();
			if (opTop == "(") {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == "+" || opTop == "-")
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output.add(opTop);
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(String ch) {
		while (!theStack.isEmpty()) {
			String chx = theStack.pop();
			if (chx == "(")
				break;
			else
				output.add(chx);
		}
	}

	public static void main(String[] args) {
		String des = "四则运算题目10: 1 + 2 * 4 / 5 - 7 + 3 / 6 = ";

		InToPost theTrans = new InToPost(des);
		List<String> output = theTrans.doTrans();
	}
}