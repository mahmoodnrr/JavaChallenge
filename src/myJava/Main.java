package myJava;

public class Main {
    public static void main(String[] args) {

        try{
            int num = Integer.parseInt(args[0]);
            String inputs = args[1];

             new WordController(num, inputs, new WordsUtil().getDictionary());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}