package src;

public class DocumentProcessing {

    public static String editSentence(String input1, String input2, int n){
        String operation = input2.substring(0, 1);
        switch(operation){
            case "w": input1 += input2.substring(1, n+1);
                      return input1;
            case "d" : input1 = input1.substring(0, input1.length()-(n));
                        return input1;
            case "u" : return "";
            default : return input1;
        }
    }
    public static void main(String[] args) {
        System.out.println(editSentence("aabda", "dababdea", 1));
        
    }
    
}
