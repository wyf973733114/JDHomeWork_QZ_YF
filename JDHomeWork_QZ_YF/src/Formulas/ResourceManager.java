package Formulas;

import java.io.*;

final class ResourceManager {
/*
  @program: JDHomeWork_QZ_YF
 *
 * @description: 这个类负责控制台输和文件写入  -- 文件的路径是工程路径
 *
 * @author: feng
 *
 * @create: 2020-04-05 10:39
 */

    // 这三个文件名当宏用
    /*输出的表达式的文件名*/
    static final String exercisesFileName = "Exercises.txt";
    // 第几条公式，私有静态属性
    private int exercisesCount = 1;

    /*输出的表达式答案的文件名*/
    static final String answersFileName = "Answers.txt";
    // 第几个答案，私有静态属性
    private int answersCount = 1;

    /*输出的调试日志的文件名*/
    static final String gradeFileName = "Grade.txt";

    // 文件名
    private String fileName;
    // 文件全路径
    private String path;

    /**
     * @description:  构造的时候初始化文件夹
     * @author: feng
     * @date: 2020/4/5
     */
    ResourceManager(String fileName) {
        // 保存文件夹路径 -- 工程路径
        this.fileName = fileName;
        path = System.getProperty("user.dir") + "/" + fileName;

        System.out.println(path);
    }

    /**
     * @description:  控制台输出并写入对应的txt文件
     * @param:  [file, str]
     * @author: feng
     * @date: 2020/4/5
     */
    void logAndWrite(String str) {
        try {
            // 确定输入的字符串格式
            String newStr;
            switch (fileName){
                case exercisesFileName:
                    newStr = "四则运算题目" + exercisesCount +"： "+ str + "\n";
                    exercisesCount += 1;
                    break;
                case answersFileName:
                    newStr = "答案" + answersCount + "： " + str + "\n";
                    answersCount += 1;
                    break;
                case gradeFileName:
                    newStr = str + "\n";   //如果是日志的话格式全部由外部定义
                    break;
                default:
                    throw new IOException();
            }

            FileOutputStream fos = new FileOutputStream(path,true); //true表示在文件末尾追加
            fos.write(newStr.getBytes());
            fos.close();

            System.out.println(newStr);
        } catch (IOException e) {
            System.out.println(str + "字符串写入失败！请检查文件名！！！");
        }
    }
}

