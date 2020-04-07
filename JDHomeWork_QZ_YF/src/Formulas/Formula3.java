package Formulas;

import java.util.Random;

public class Formula3 {
/**
 * @program: JDHomeWork_QZ_YF
 *
 * @description: 传参构建三参数式子
 *
 * @author: feng
 *
 * @create: 2020-04-07 23:46
 **/
    private Formula2 formula;   // 二参数式子
    private String symbol;
    private int num;
    private Random random = new Random();

    public int result;  // 暂时先用int
    public String describtion;

    /**
     * @description:  传入参数生成二参数公式
     * @param:  参数1 运算符号 参数2 是否需要随机交换
     * @author: feng
     * @date: 2020/4/7
     */
    Formula3(Formula2 formula2, String symbol, int num, Boolean randomSwap,Boolean withBrackets){

        this.symbol = symbol;
        this.num = num;
        this.formula = formula;
        Boolean swap = randomSwap && random.nextBoolean();
        String formula2describtion = withBrackets ? "(" + formula2.describtion + ")" : formula2.describtion;

        if (swap){
            // 用随机数判断是否随机交换两个数
            describtion = formula2describtion + " " + symbol + " " + num;
        }else{
            describtion = num + " " + symbol + " " + formula2describtion;
        }

        switch (symbol){
            case "+":
                result = formula2.result + num;
                break;
            case "−":
                result = swap? (num - formula2.result):(formula2.result - num);
                break;
            case "×":
                result = formula2.result * num;
                break;
            case "÷":
                result = swap? (num / formula2.result):(formula2.result / num);   // 这里到时候化为真分数
                break;
            default:
                result = -1;    // 结果为-1 代表出错了
        }

    }

}
