//van mason
//fraccalc
//mulvaney period 1


import java.util.*;

public class FracCalcv2 
{
    public static void main(String[] args)throws MulvaneyException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("User name: ");
        String user = scanner.nextLine();
        if(user.equalsIgnoreCase("mulvaney") || user.equalsIgnoreCase("paul")){
            throw new MulvaneyException("Sorry no can do");
        }
        else{
            System.out.println("Hello " + user + ", Hit enter to start calculating.");
            //calls input manager
            InputManager(user);
        }
        scanner.close();
    }
    //throws a mulvaney exception 
    public static void InputManager(String user) throws MulvaneyException{
        Scanner userInput = new Scanner(System.in);
        String userString = userInput.nextLine();
        //runs the program until the user enters quit
        while(!userString.equals("quit")){
            System.out.print("Enter: ");
            //asks the user for their input
            String input = userInput.nextLine();
            Scanner inputScanner = new Scanner(input);
            userString = input;
            if(input.equals("help")){
                //help message
                System.out.println("Type quit to exit the program. You can type whole numbers such as 7");
                System.out.println("Improper or regular fractions are displayed as 7/12 or 17/2");
                System.out.println("Mixed numbers are displayed as 2_3/4");

            }
            else if(input.equalsIgnoreCase("quit")){
                //quit message
                System.out.println("Goodbye " + user);

            }
            else if(input.contains("/")){
                convertToImproper(input);

            }
            else {
                //echos input
                convertToImproper(input);
            }
            /*else{
            System.out.println(input + "is not in the right format.");   
            }*/
        }
    }
    
    //Every method needs a comment, thumbs up?
    public static String convertToImproper(String inputs){
        Scanner inputScanner = new Scanner(inputs);
        //breaks the input up into 3 tokens
        String token1 = inputScanner.next();
        String token2 = inputScanner.next();
        String token3 = inputScanner.next();
        String token1FirstInt = "";
        String token1SecondInt = "";
        String token1ThirdInt = "";
        int wholeNumber = 0;
        int numerator = 0;
        int denominator = 0;
        int newNumerator = 0;
        //if statements converting the first token into an improper fraction
        if(token1.contains("_")){
            //breaks the first token up into 3 different segments if it contains a mixed number
            token1FirstInt = token1.substring(0,token1.indexOf("_"));
            token1SecondInt = token1.substring(token1.indexOf("_") + 1,token1.indexOf("/"));
            token1ThirdInt = token1.substring(token1.indexOf("/") + 1, token1.length());
            //parses those strings into ints

            wholeNumber = Integer.parseInt(token1FirstInt);
            numerator = Integer.parseInt(token1SecondInt);
            denominator = Integer.parseInt(token1ThirdInt);
            if(wholeNumber >= 0){
                newNumerator = (wholeNumber *  denominator) + numerator;
                numerator = newNumerator;
            }
            else if(wholeNumber < 0){
               newNumerator = (wholeNumber * denominator) - numerator;
               numerator = newNumerator;
            }
        }
        else if(token1.contains("/")){
            //breaks the first token up into three different tokens if it contains a /
            token1FirstInt = token1.substring(0,token1.indexOf("/"));
            token1ThirdInt = token1.substring(token1.indexOf("/") + 1, token1.length());
            //parses those strings into 2 ints
            numerator = Integer.parseInt(token1FirstInt);
            denominator = Integer.parseInt(token1ThirdInt);

        }
        else{
            //parses the whole number into a int 
            numerator = Integer.parseInt(token1);
            denominator = 1;
        }
        //if statements breaking up the third token
        String token3FirstInt = "";
        String token3SecondInt = "";
        String token3ThirdInt = "";
        int wholeNumber3 = 0;
        int numerator3 = 0;
        int denominator3 = 0;
        int newNumerator3 = 0;
        if(token3.contains("_")){
            //breaks the third token up into 3 different segments if it contains a mixed number
            token3FirstInt = token3.substring(0,token3.indexOf("_"));
            token3SecondInt = token3.substring(token3.indexOf("_") + 1,token3.indexOf("/"));
            token3ThirdInt = token3.substring(token3.indexOf("/") + 1, token3.length());
            //parses those strings into ints
            wholeNumber3 = Integer.parseInt(token3FirstInt);
            numerator3 = Integer.parseInt(token3SecondInt);
            denominator3 = Integer.parseInt(token3ThirdInt);
            if(wholeNumber3 >= 0){
                newNumerator3 = (wholeNumber3 *  denominator3) + numerator3;
                numerator3 = newNumerator3;
            }
            else if(wholeNumber3 < 0){
               newNumerator3 = (wholeNumber3 * denominator3) - numerator3;
               numerator3 = newNumerator3;
            }
            

        }
        else if(token3.contains("/")){
            //breaks the first token up into three different tokens if it contains a /
            token3FirstInt = token3.substring(0,token3.indexOf("/"));
            token3ThirdInt = token3.substring(token3.indexOf("/") + 1 , token3.length());
            //parses those strings into 2 ints
            numerator3 = Integer.parseInt(token3FirstInt);
            denominator3 = Integer.parseInt(token3ThirdInt);

        }
        else{
            //parses the whole number into a int 
            numerator3 = Integer.parseInt(token3);
            denominator3 = 1;
        }

        math(token2, wholeNumber, numerator, denominator, wholeNumber3, numerator3, denominator3);

        return inputs; 

    }

    public static void math(String operator, int firstwhole, int  firstnum, int firstden, int secondwhole, int secondnum, int secondden){
        //addition operation if statement
        int finalFraction = 0;
        int finalDenominator = 0;
        int finalNumerator = 0;

        if (operator.contains("+")){

            finalDenominator = firstden * secondden;
            finalNumerator = (firstden * secondnum) + (secondden * firstnum);
            GCMfinder(finalNumerator, finalDenominator);
            /*if(finalDenominator == 1 || finalDenominator == 0){
            System.out.println(finalNumerator);
            }
            else{
            System.out.println(finalNumerator + "/" + finalDenominator);
            }*/

        }
        //subtraction if statement
        else if(operator.contains("-")){
            finalDenominator = firstden * secondden;
            finalNumerator = ((secondden * firstnum) - firstden * secondnum)  ;
            GCMfinder(finalNumerator, finalDenominator);
            /*if(finalDenominator == 1 || finalDenominator == 0){
            System.out.println(finalNumerator);
            }
            else{
            System.out.println(finalNumerator + "/" + finalDenominator);   
            }*/
        }
        //multiplication if statement
        else if(operator.contains("*")){
            finalDenominator = firstden * secondden;
            finalNumerator = firstnum * secondnum;
            GCMfinder(finalNumerator, finalDenominator);
            /*if(finalDenominator == 1 || finalDenominator == 0){
            System.out.println(finalNumerator);
            }
            else{
            System.out.println(finalNumerator + "/" + finalDenominator);   
            }*/
        }
        //division if statement
        else if(operator.contains("/")){
            finalNumerator = firstnum * secondden;
            finalDenominator = firstden * secondnum;
            GCMfinder(finalNumerator, finalDenominator);
            /*if(finalDenominator == 1 || finalDenominator == 0){
            System.out.println(finalNumerator);
            }

            else{
            System.out.println(finalNumerator + "/" + finalDenominator);   
            }*/
        }
    }
    //reducing method
    public static void GCMfinder(int num, int den){
        //finds the max for a gcm
        //needs to be absolute value for negative numbers
        int minNum = Math.min(Math.abs(num), Math.abs(den));
        int gcm = 1;
        //for loop to determine the final gcm
        for(int i = 1; i <= minNum; i++){
            if(num % i == 0 && den % i == 0){
                gcm = i;  
            }
        }
        num /= gcm;
        den /= gcm;
        //prints out the final fraction
        if(den == num){
            System.out.println(1);  
        }
        else if(den == 1){
            System.out.println(num);

        }
        else if(num == 0){
         System.out.println(0);   
        }
        else{
            System.out.println(num + "/" + den);   
        }
    }
}
