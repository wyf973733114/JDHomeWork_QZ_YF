package Formulas;

import java.util.Objects;
import java.util.Random;

public class Formula2 {
    /**
     * @program: JDHomeWork_QZ_YF
     * @description: 公式
     * @author: feng
     * @create: 2020-04-06 23:28
     **/
    private Random random = new Random();

    private int num1;
    public String symbol;
    private int num2;

    public String result;  // 暂时先用int
    public String describtion;

    /**
     * @description: 传入参数生成二参数公式
     * @param: 参数1 运算符号 参数2 是否需要随机交换
     * @author: feng
     * @date: 2020/4/7
     */
    Formula2(int num1, String symbol, int num2, Boolean randomSwap) {

        if (randomSwap && random.nextBoolean()) {
            // 用随机数判断是否随机交换两个数
            this.num2 = num1;
            this.num1 = num2;
        } else {
            this.num1 = num1;
            this.num2 = num2;
        }
        this.symbol = symbol;

        describtion = num1 + " " + symbol + " " + num2;
        switch (symbol) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "−":
                result = String.valueOf(num1 - num2);
                break;
            case "×":
                result = String.valueOf(num1 * num2);
                break;
            case "÷":
                int cm = MathMethon.conventionMax(num1, num2);  // 求最大公约数
                int part1 = num1/cm;
                int part2 = num2/cm;
                if (part1 == part2 ){
                    result = "1";
                }else {
                    result = part1 + "/" + part2;   // 这里到时候化为真分数
                }
                break;
            default:
                result = "未识别的运算符号！";    // 结果为-1 代表出错了
        }
    }

    // 为了拿对象当key
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Formula2 formula = (Formula2) obj;
        if (num1 != 0 ? num1 != (formula.num1) : formula.num1 != 0) {
            return false;
        }
        if (symbol != null ? !symbol.equals(formula.symbol) : formula.symbol != null) {
            return false;
        }
        if (num2 != 0 ? num2 != (formula.num2) : formula.num2 != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return num1 != 0 && symbol != null && num2 != 0 ?
                ((Integer) num1).hashCode() + symbol.hashCode() + ((Integer) num2).hashCode() : 0;
    }


}
