package Formulas;

import java.util.*;

public class FormulasGenerator {
/*
  @program: JDHomeWork_QZ_YF
 *
 * @description: 这个类负责生成公式
 *
 * @author: feng
 *
 * @create: 2020-04-05 10:39
 */

    // 随机数生成器
    private Random random = new Random();
    // 参数范围
    private Integer scope;
    // 运算符集合
    private String symbolArray[] = {"+", "−", "×", "÷"};

    // 哈希表记录 num1 -> String -> num2
    private Map<Integer, Map<String, Set<Integer>>> recordMap = new HashMap<>();
    // 已生成的式子集合
    List<Formula> formulaList = new ArrayList<>();

    FormulasGenerator(int scope) {
        this.scope = scope;
    }

    /**
     * @description:  生成一条不重复的双参数公式
     * @return: 判断是否生成成功
     * @author: feng
     * @date: 2020/4/5
     */
    Boolean generatorTow() {
        // 生成两个随机数num1、num2 和符号symbol
        String symbol = randomSymbol();
        int num1 = random.nextInt(scope);  // 第一个数
        int num2;    // 第二个数小于或等于第一个数
        if (symbol == "÷"){
            // 除法除数不为0
            num2 = (int) (1 + Math.random()*( num1 -1 +1));
        }else{
            num2 = random.nextInt(num1 + 1);
        }

        // 判断是否包含第一个参数
        if (recordMap.containsKey(num1)){
            Map<String, Set<Integer>> symToNum2 = recordMap.get(num1);

            // 包含符号则继续查询
            if (symToNum2.containsKey(symbol)){
                Set<Integer> num2s = symToNum2.get(symbol);

                // 判断是否包含第二个参数
                if (num2s.contains(num2)){
                    // 和已有记录重复，重新生成
                    //System.out.println("生成失败！"+ num1 + symbol + num2);
                    return Boolean.FALSE;
                }else{
                    num2s.add(num2);    // 不存在则添加
                }

            }else{
                // 不存在则添加
                Set<Integer> num2s = new HashSet<>();    // 第二个数的集合
                num2s.add(num2);

                symToNum2.put(symbol, num2s); // 添加联系
            }

        }else{
            // 不含有则增加记录
            Set<Integer> num2s = new HashSet<>();    // 第二个数的集合
            num2s.add(num2);

            Map<String, Set<Integer>> symToNum2 = new HashMap<>();  // 符号到第二个数集合的映射
            symToNum2.put(symbol, num2s);

            // 第一个数到符号的映射
            recordMap.put(num1,symToNum2);
        }
        //System.out.println("生成成功！"+ num1 + symbol + num2);
        if(symbol!= "-" && !(symbol == "÷" && num1 == 0) && random.nextBoolean()){
            // 不为减法、 不为被除数为0的除法 则随机交换两个数
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
        }

        formulaList.add(new Formula(num1,symbol,num2));
        return Boolean.TRUE;
    }

    /**
     * @description:  生成随机符号
     * @return: 生成的符号
     * @author: feng
     * @date: 2020/4/6
     */
    String randomSymbol(){
        int index = random.nextInt(symbolArray.length);
        return symbolArray[index];
    }

    void getFormula(){
        for (Formula formula:
             formulaList) {
            System.out.println(formula.describtion + " = " + formula.result);
        }
    }
}
