package Formulas;
// 需求：https://edu.cnblogs.com/campus/gdgy/se18_12/homework/10563 -- 对需求不清楚的通过网址再详细去看

/*
写在前面：生成题目的时候要输出一份 Exercises.txt 存储题目，Answers.txt 存储答案；
        使用 -e 校验答案时要输出一份 Grade.txt 存储日志
 */

// 1. 使用 -n 参数控制生成题目的个数

/* 2. 使用 -r 参数控制题目中数值（自然数、真分数和真分数分母）的范围
    将生成10以内（不包括10）的四则运算题目。该参数可以设置为1或其他自然数。该参数必须给定，否则程序报错并给出帮助信息。

#warning -- 这里必看，先理解ys
    a. 生成的题目中计算过程不能产生负数，也就是说算术表达式中如果存在形如e1− e2的子表达式，那么e1≥ e2。
    b. 生成的题目中如果存在形如e1÷ e2的子表达式，那么其结果应是真分数。
    c. 每道题目中出现的运算符个数不超过3个。
    d. 程序一次运行生成的题目不能重复。例如，23+45 和 45+23、6×8 和 8×6、3+(2+1) 和 1+2+3 这两个题目是重复的
        由于+是左结合的，1+2+3 等价于 (1+2)+3，也就是 3+(1+2)，也就是 3+(2+1)。
        但是1+2+3和3+2+1是不重复的两道题，因为 1+2+3 等价于 (1+2)+3，而 3+2+1 等价于 (3+2)+1，它们之间不能通过有限次交换变成同一个题目。
 */

/*
3. 对给定的题目文件和答案文件，判定答案中的对错并进行数量统计，输入参数如下：
 Myapp.exe -e <exercisefile>.txt -a <answerfile>.txt

统计结果输出到文件Grade.txt，格式如下:
Correct: 5 (1, 3, 5, 7, 9)
Wrong: 5 (2, 4, 6, 8, 10)
其中“:”后面的数字5表示对/错的题目的数量，括号内的是对/错题目的编号。为简单起见，假设输入的题目都是按照顺序编号的符合规范的题目。
*/

import static Formulas.ResourceManager.*;
import java.util.Arrays;

public class ParametersManager {
/*
  @program: JDHomeWork_QZ_YF
 *
 * @description: 这个类负责参数解析
 *
 * @author: feng
 *
 * @create: 2020-04-05 10:39
 */
    public static void main(String[] args) {
    	
    	System.out.println(args.length);
    }
}
