package Formulas;

public class Result {
    public String describtion;
    public String result;  // 暂时先用int
    
    // 二元表达式和三元表达式的返回标准，便于写入文件
    Result(String des, String res) {
    	this.describtion = des;
    	this.result = res;
    }
}

