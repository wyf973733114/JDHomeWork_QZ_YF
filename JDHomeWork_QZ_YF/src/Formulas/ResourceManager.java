package Formulas;

import java.io.*;

/*这个类进行资源管理 调用它的方法进行文件写入并打印 -- 文件的路径是工程路径*/
public final class ResourceManager {
    // 这三个当宏用
    /*输出的表达式的文件名*/
    public static final String exercisesFileName = "Exercises.txt";
    public static int exercisesCount;
    /*输出的表达式答案的文件名*/
    public static final String answersFileName = "Answers.txt";
    public static int answersCount;
    /*输出的调试日志的文件名*/
    public static final String gradeFileName = "Grade.txt";

    private static String baseUrl;

    /**
    * @Description: 构造的时候初始化文件夹
    * @Author: fang
    * @Date: 2020/4/4
    */
    ResourceManager() {
        // 保存文件夹路径 -- 工程路径
        ResourceManager.baseUrl = System.getProperty("user.dir") + "/";
        System.out.println(ResourceManager.baseUrl);
        exercisesCount = 1;
        answersCount = 1;
    }

    /**
     * @Description: 控制台输出并写入对应的txt文件
     * @Param: [file, str]
     * @Author: feng
     * @Date: 2020/4/4
     */
    static void logAndWrite(String fileName, String str) {
        // 在输入的文件夹下创建文件
        try {
            // 确定输入的字符串格式
            String newStr;
            switch (fileName){
                case exercisesFileName:
                    newStr = "四则运算题目" + exercisesCount +" "+ str + "\n";
                    exercisesCount += 1;
                    break;
                case answersFileName:
                    newStr = "答案" + answersCount + " " + str + "\n";
                    answersCount += 1;
                    break;
                case gradeFileName:
                    newStr = str + "\n";   //如果是日志的话格式全部由外部定义
                    break;
                default:
                    throw new IOException();
            }

            FileOutputStream fos = new FileOutputStream(fileName,true); //true表示在文件末尾追加
            fos.write(newStr.getBytes());
            fos.close();

            System.out.println(newStr);
        } catch (IOException e) {
            System.out.println(str + "字符串写入失败！请检查文件名！！！");
        }
    }
}

