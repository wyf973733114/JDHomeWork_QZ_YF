package Formulas;

public class MathMethon {
    /**
     * @program: JDHomeWork_QZ_YF
     * @description: 进行数学运算，封装获取最小公倍数，最大公约数方法
     * @author: feng
     * @create: 2020-04-08 14:28
     **/
    //计算最大公约数
    public static int conventionMax(int a, int b) {
        int num = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                num = i;
            }
        }
        return num;
    }

    //计算最小公倍数
    public static int multipleMin(int m, int n) {
        //将m,n转化成最大公约数为1，那之后他们的乘积就是代表最小公倍数
        return n * m / conventionMax(m, n);
    }

    // 传入字符串（最多一个"/"），返回不小于其的最小整数
    public static int translateResult(String valueStr) {
        if (!valueStr.contains("/")) {
            return Integer.valueOf(valueStr).intValue();
        }
        //去掉多余的空格
        valueStr.replaceAll(" ", "");
        // 通过"/"切割字符串
        String[] numStrArray = valueStr.split("/");

        // 这里只写了两个参数的情况
        if (Integer.valueOf(numStrArray[1]).intValue() == 0){
            return Integer.MAX_VALUE;
        }
        int result = Integer.valueOf(numStrArray[0]).intValue() / Integer.valueOf(numStrArray[1]).intValue();
        if (Integer.valueOf(numStrArray[0]).intValue() % Integer.valueOf(numStrArray[1]).intValue() > 0) {
            result++;
        }

        return result;

    }
}