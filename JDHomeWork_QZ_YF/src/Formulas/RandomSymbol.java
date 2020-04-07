package Formulas;

import java.util.Random;

public class RandomSymbol {
/**
 * @program: JDHomeWork_QZ_YF
 *
 * @description: 生成随机运算符
 *
 * @author: feng
 *
 * @create: 2020-04-07 23:10
 **/

    // 随机数生成器
    private static Random random = new Random();
    // 运算符集合
    static String symbolArray[] = {"+", "−", "×", "÷"};

    /**
     * @description:  生成随机符号
     * @return: 生成的符号
     * @author: feng
     * @date: 2020/4/6
     */
    static String randomSymbol(){
        int index = random.nextInt(symbolArray.length);
        return symbolArray[index];
    }
}
