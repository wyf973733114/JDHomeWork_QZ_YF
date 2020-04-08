package Formulas;

import java.util.ArrayList;
import java.util.Random;

public class FormulaGenerator {
/**
 * @program: JDHomeWork_QZ_YF
 *
 * @description: 随机生成两个参数或者三个参数的式子
 *
 * @author: feng
 *
 * @create: 2020-04-08 00:05
 **/
    // 随机数生成器
    private static Random random = new Random();

    /**
     * @description:  生成数条不重复的双参数公式或三参数的
     * @return: 生成的式子，失败则返回null
     * @author: feng
     * @date: 2020/4/5
     */
    static ArrayList<Result> generator(int scope,int count) {
        Formulas2Generator formulas2Generator = new Formulas2Generator(scope);
        Formulas3Generator formulas3Generator = new Formulas3Generator(scope);
        ArrayList<Result> list = new ArrayList<>();
        
        int i = 0;
        while(i< count){
            if (random.nextBoolean()){  // 随机生成二参数公式或者三参数公式
                Formula2 formula2 = formulas2Generator.generator();
                if (formula2 !=  null){
                	Result item = new Result(formula2.describtion, formula2.result);
                	list.add(item);
                    i++;
                }
            }else {
                Formula3 formula3 = formulas3Generator.generator();
                if (formula3 != null) {
                	Result item = new Result(formula3.describtion, formula3.result);
                	list.add(item);
                    i++;
                }
            }
        }
        return list;
    }
}
