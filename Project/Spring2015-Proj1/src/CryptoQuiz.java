


import java.util.Scanner;





public class CryptoQuiz {


private static int 

NUM_BITS1, 

NUM_BITS2, 

NUM_BITS3, 

NUM_BITS4;


private static String 

CRYPT1,

CRYPT2,

CRYPT3, 

CRYPT4;


private static String 

promptInitialChoice, 

promptSelectBITs,

promptWhichSystemPart1,

promptWhichSystemPart2,

promptSelectSystem,

promptHowManyBITsPart1,

promptHowManyBITsPart2,

feedbackInvalidChoice,

feedbackCorrect,

feedbackIncorrect;








//CODE ABOVE HERE IS GIVEN TO YOU - DO NOT ALTER IT







public static void main(String[] args) {

Scanner myScanner = new Scanner(System.in);



//Initialize the quiz Q&A values, storing the values in the

//  variables that were defined for you earlier in the code above.


NUM_BITS1=64; 
NUM_BITS2=128; 
NUM_BITS3=168; 
NUM_BITS4=768;


CRYPT1="Blowfish";
CRYPT2="Rijndael";
CRYPT3="TripleDES";
CRYPT4="RSA";

//Ask what language they would like to use.

      System.out.print("1) English   2) Espanol: ");
       int inputLanguage = myScanner.nextInt();
//Based on the language selected above, set prompt and feedback 
//  variables in that language.
       if(inputLanguage==1) {
    	   promptInitialChoice = "Enter 1 to guess a crypto system, 2 to guess how many BITs: "; 
    	   promptSelectBITs = "Select number of BITs: ";
    	   promptWhichSystemPart1 = "Which crypto system uses ";
    	   promptWhichSystemPart2 = "BITs?"; 
    	   promptSelectSystem = "Select a crypto system: "; 
    	   promptHowManyBITsPart1 = "How many BITs are used in a ";
    	   promptHowManyBITsPart2 = " system?";
    	   feedbackInvalidChoice = "Invalid choice.";
    	   feedbackCorrect = "Correct!";
    	   feedbackIncorrect = "Incorrect!";
        }
    else if (inputLanguage==2) {
    	promptInitialChoice = "Presione el numero 1 para adivinar un sistema de codificacion criptografica, 2 para adivinar la cantidad de BITS:"; 
    	promptSelectBITs = "Seleccione el numero de BITs:"; 
    	promptWhichSystemPart1 = "Que sistema de codificacion criptografica utiliza ";
    	promptWhichSystemPart2 = "BITs?"; 
    	promptSelectSystem = "Seleccione un sistema de codificacion criptografica: "; 
    	promptHowManyBITsPart1 = "Cuantos BITs son utilizados en un sistema ";
    	promptHowManyBITsPart2 = "?";
    	feedbackInvalidChoice = "Opcion invalida.";
    	feedbackCorrect = "Correcto!";
    	feedbackIncorrect = "Incorrecto!";
        }

    

      //Perform the quiz!

        
    if(inputLanguage == 1)
    {   //English

    System.out.print(promptInitialChoice);
    int inputSystem = myScanner.nextInt(); 
    /*

    * 1 to guess a crypto system, 2 to guess how many BITs

    */

    	if(inputSystem == 1)
    {  //to guess a crypto system

    		System.out.print(promptSelectBITs);
    		int inputBITs = myScanner.nextInt();  //64,128,168,768 otherwise "Invalid choice."

    			if(inputBITs==64 || inputBITs==128 || inputBITs==168 || inputBITs==768)
    		{
    				System.out.print(promptWhichSystemPart1 + inputBITs + promptWhichSystemPart2);
    				String inputcrypto = myScanner.next();
    				if (inputBITs==64 && inputcrypto.equals(CRYPT1) ||
    					inputBITs==128 && inputcrypto.equals(CRYPT2) ||
    					inputBITs==168 && inputcrypto.equals(CRYPT3) ||
    					inputBITs==768 && inputcrypto.equals(CRYPT4)) 
    				{
    					System.out.print(feedbackCorrect);
    				}
    				else {
    					System.out.print(feedbackIncorrect);
    					 }
    		}
    			
    		else 
    	   {
    		System.out.print(feedbackInvalidChoice);
           }
   }
   

    	else if (inputSystem == 2) 
  { //to guess how many BITs
    	System.out.print(promptSelectSystem);
    	String cryptoSystem = myScanner.next();
     
          if(cryptoSystem.equals(CRYPT1) ||
    		 cryptoSystem.equals(CRYPT2) ||
    		 cryptoSystem.equals(CRYPT3) ||
    		 cryptoSystem.equals(CRYPT4))
      {
        	System.out.print(promptHowManyBITsPart1 + cryptoSystem + promptHowManyBITsPart2);
        	int answer = myScanner.nextInt();
        	   if  (cryptoSystem.equals(CRYPT1) && answer == 64 ||
        			cryptoSystem.equals(CRYPT2) && answer == 128 ||
        			cryptoSystem.equals(CRYPT3) && answer == 168||
        			cryptoSystem.equals(CRYPT4) && answer == 768) 
        	   {
        		   System.out.print(feedbackCorrect);
        		}

        	   else 
        	   {
        		   System.out.print(feedbackIncorrect);
        	   	}

     }
         else
      {
        System.out.print(feedbackInvalidChoice);
      }

   }
 }
    
 else if (inputLanguage== 2) 
{   //Spanish
    System.out.print(promptInitialChoice);
    int inputSystem = myScanner.nextInt(); 
    		if(inputSystem == 1)
    		{  //to guess a crypto system
    			System.out.print(promptSelectBITs);
    			int inputBITs = myScanner.nextInt();  //64,128,168,768 otherwise "Invalid choice." 
        			if(inputBITs==64 || inputBITs==128 || inputBITs==168 || inputBITs==768)
        			{
        				System.out.print(promptWhichSystemPart1 + inputBITs + promptWhichSystemPart2);
        				String inputCrypto = myScanner.next();
        				if (inputBITs==64 && inputCrypto.equals(CRYPT1) ||
        					inputBITs==128 && inputCrypto.equals(CRYPT2) ||
        					inputBITs==168 && inputCrypto.equals(CRYPT3) ||
        					inputBITs==768 && inputCrypto.equals(CRYPT4)) 
        				{
        					System.out.print(feedbackCorrect);
        				}

        				else
        				{
        					System.out.print(feedbackIncorrect);
        				}
        			}
        			else
        			{
        				System.out.print(feedbackInvalidChoice);
        			}
    		}
    	else if (inputSystem == 2)
    		{ //to guess how many BITs
    		System.out.print(promptSelectSystem);
    		String cryptoSystem = myScanner.next();
    			if (cryptoSystem.equals(CRYPT1) ||
    			cryptoSystem.equals(CRYPT2) ||
    			cryptoSystem.equals(CRYPT3) ||
    			cryptoSystem.equals(CRYPT4))
    			{
    				System.out.print(promptHowManyBITsPart1 + cryptoSystem + promptHowManyBITsPart2);
    				int inputAnswer = myScanner.nextInt();
    					if  (cryptoSystem.equals(CRYPT1) && inputAnswer == 64 ||  		
    						cryptoSystem.equals(CRYPT2) && inputAnswer == 128 ||
    						cryptoSystem.equals(CRYPT3) && inputAnswer == 168||
    						cryptoSystem.equals(CRYPT4) && inputAnswer == 768) 
    					{
    						System.out.print(feedbackCorrect);
    					}
    					else
    					{
    						System.out.print(feedbackIncorrect);
    					}
    			}
    			else 
    			{
    				System.out.print(feedbackInvalidChoice);
    			}
    		}
}



myScanner.close();

}

}



 