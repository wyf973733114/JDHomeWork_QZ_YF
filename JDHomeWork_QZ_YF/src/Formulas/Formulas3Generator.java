package Formulas;

import java.util.*;

public class Formulas3Generator {
/**
 * @program: JDHomeWork_QZ_YF
 *
 * @description: 三参数式子生成器
 *
 * @author: feng
 *
 * @create: 2020-04-07 22:07
 **/
    // 随机数生成器
    private Random random = new Random();
    // 二参数式子生成器
    private Formulas2Generator formulas2Generator;
    // 参数范围
    private Integer scope;

    // 哈希表记录 双参数式子 -> String -> num2
    private Map<Formula2, Map<String, Set<Integer>>> recordMapThree = new HashMap<>();

    Formulas3Generator(int scope) {
        this.scope = scope;
        formulas2Generator = new Formulas2Generator(scope);
    }

    /**
     * @description:  生成一条不重复的三参数公式
     * @return: 生成的式子，失败则返回null
     * @author: feng
     * @date: 2020/4/5
     */
    Formula3 generator(){
        // 生成两个随机数num1、num2 和符号symbol
        String symbol = RandomSymbol.randomSymbol();
        Formula2 formula2 = formulas2Generator.generator();  // 第一个数
        while (formula2 == null){
            formula2 = formulas2Generator.generator();   // 直到生成成功
        }

        int num;    // 第二个数小于或等于第一个数
        if (symbol == "÷"){
            // 除法除数不为0
            num = (int) (1 + Math.random()*( formula2.result -1 +1));
        }else{
            num = random.nextInt(formula2.result + 1);
        }

        // 判断是否包含第一个参数
        if (recordMapThree.containsKey(formula2)){
            Map<String, Set<Integer>> symToNum2 = recordMapThree.get(formula2);

            // 包含符号则继续查询
            if (symToNum2.containsKey(symbol)){
                Set<Integer> num2s = symToNum2.get(symbol);

                // 判断是否包含第二个参数
                if (num2s.contains(num)){
                    // 和已有记录重复，重新生成
                    //System.out.println("生成失败！"+ num1 + symbol + num2);
                    return null;
                }else{
                    num2s.add(num);    // 不存在则添加
                }

            }else{
                // 不存在则添加
                Set<Integer> num2s = new HashSet<>();    // 第二个数的集合
                num2s.add(num);

                symToNum2.put(symbol, num2s); // 添加联系
            }

        }else{
            // 不含有则增加记录
            Set<Integer> num2s = new HashSet<>();    // 第二个数的集合
            num2s.add(num);

            Map<String, Set<Integer>> symToNum2 = new HashMap<>();  // 符号到第二个数集合的映射
            symToNum2.put(symbol, num2s);

            // 第一个数到符号的映射
            recordMapThree.put(formula2,symToNum2);
        }
        //System.out.println("生成成功！"+ num1 + symbol + num2);
        Boolean randomSwap = Boolean.FALSE;
        if(!Objects.equals(symbol, "-") && !((symbol == "÷") && (formula2.result == 0)) && random.nextBoolean()){
            randomSwap = Boolean.TRUE;
        }
//        Boolean withBrackets = (formula2.)
        // 判断结果是否合法
        Formula3 formula3 = new Formula3(formula2,symbol,num, randomSwap, Boolean.TRUE);
        if ((formula3.result < 0) || (formula3.result >= scope)){
            return null;    // 参数超过范围
        }
        return formula3;
    }



}
