package Formulas;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private static int exercisesCount = 1;

    /*输出的表达式答案的文件名*/
    static final String answersFileName = "Answers.txt";
    // 第几个答案，私有静态属性
    private static int answersCount = 1;

    /*输出的调试日志的文件名*/
    static final String gradeFileName = "Grade.txt";

    // 文件名
    private String fileName;
    // 文件全路径
    private String path;
    
    ResourceManager() {
    	
    }

    /**
     * @description:   根据文件名，初始化文件地址
     * @param: [fileName]
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
     * @description:  清空文件的内容
     */
    void clearFile() {
        try {
        	FileOutputStream fos = new FileOutputStream(path,false); //true表示在文件末尾追加
            fos.write("".getBytes());
			fos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    
    
    /**
     * @description:  控制台输出并写入对应的txt文件
     * @param:  写入文件的内容
     * @author: feng
     * @date: 2020/4/5
     */
    void logAndWrite(String str) {
        try {
            // 确定输入的字符串格式
            String newStr;
            switch (fileName){
                case exercisesFileName:
                    newStr = "四则运算题目" + exercisesCount +": "+ str + "\n";
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
            
            FileOutputStream fos = new FileOutputStream(path,true); //true表示在文件末尾追加
            fos.write(newStr.getBytes());
            fos.close();

            System.out.println(newStr);
        } catch (IOException e) {
            System.out.println(str + "字符串写入失败！请检查文件名！！！");
        }
    }
    
    
    /**
     * @description:  将表达式和答案写入文件
     * @param:  表达式集合
     */
    void writeFormulasToFile(ArrayList<Result> FormulaList) {
    	ResourceManager r1 = new ResourceManager(exercisesFileName);    // 写入表达式
    	ResourceManager r2 = new ResourceManager(answersFileName);  // 写入答案  	
    	
    	// 清空文件内容
    	r1.clearFile();
    	r2.clearFile();
		
    	// 将表达式写入文件
		for(Result item: FormulaList) {
			r1.logAndWrite(item.describtion);
			r2.logAndWrite(String.valueOf(item.result));
		};
    }
    
    
    /**
     * @description:  获取文件内容，返回一个数组，元素为每一行的内容
     * @param:  文件名
     */
    static ArrayList<String> getFileContent(String fileName) throws FileNotFoundException {
    	ArrayList<String> content = new ArrayList<>();
    	File file = new File(fileName);
    	BufferedReader reader = null;
    	
    	try {
			reader = new BufferedReader(new FileReader(file));
			String tempStr = null;
			while((tempStr = reader.readLine()) != null) {
				content.add(tempStr);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return content;
    }
    
    
    // 检查答案
    static void checkAnswer() {
    	try {
    		// 打开Exercises.txt和answer.txt
    		ArrayList<String> exercisesContent = getFileContent(exercisesFileName);
    		ArrayList<String> answersContent = getFileContent(answersFileName);
    		
    		// 保存答案正确的题号，保存答案错误的题号
    		ArrayList<Integer> rightCount = new ArrayList<>();
    		ArrayList<Integer> errorCount = new ArrayList<>();
    		// 写入日志
    		ResourceManager r = new ResourceManager(gradeFileName);
    		r.clearFile();
    		
    		// 循环对比，对比每一项的答案是否正确
    		for(int i = 0; i < exercisesContent.size(); i++) {
    			// 获取数字
    			ArrayList temp1 = new ArrayList<String>(Arrays.asList(exercisesContent.get(i).split("\\s+")));
    			temp1.remove(0);
    			// 获取答案
    			ArrayList temp2 = new ArrayList<String>(Arrays.asList(answersContent.get(i).split("\\s+")));
    			temp2.remove(0);
    			// TODO:调用运算函数，计算结果
    			
    			boolean isTrue = BooleanAnswer.booleanAnswer(temp1, temp2);
    			if(isTrue) 
    				rightCount.add(i);
    			else
    				errorCount.add(i);
    		}
    		r.logAndWrite("Right:" + rightCount.toString());
    		r.logAndWrite("Error:" + errorCount.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	checkAnswer();
    }
}

