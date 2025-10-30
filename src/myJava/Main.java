package myJava;

public class Main {
    public static void main(String[] args) {

        try{
            int num = Integer.parseInt(args[0]);
            String inputs = args[1];

            WordsUtil wordsUtil = new WordsUtil();
             new WordController(num, inputs, wordsUtil.getDictionary());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}