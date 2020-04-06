package Formulas;

public class Formula {
/**
 * @program: JDHomeWork_QZ_YF
 *
 * @description: 公式
 *
 * @author: feng
 *
 * @create: 2020-04-06 23:28
 **/
    private int num1;
    private String symbol;
    private int num2;

    public int result;  // 暂时先用int
    public String describtion;

    Formula(int num1, String symbol, int num2){
        this.num1 = num1;
        this.symbol = symbol;
        this.num2 = num2;
        describtion = num1 + " " + symbol + " " + num2;
        switch (symbol){
            case "+":
                result = num1 + num2;
                break;
            case "−":
                result = num1 - num2;
                break;
            case "×":
                result = num1 * num2;
                break;
            case "÷":
                result = num1 / num2;   // 这里到时候化为真分数
                break;
            default:
                result = -1;    // 结果为-1 代表出错了
        }
    }


}
