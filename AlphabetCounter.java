import java.util.Scanner;

public class AlphabetCounter{
	//Declaration of variables i would be using.
	private String applicationTitle = "*** Alphabet Counter *** - By Issa maro Nimaga";
	private String promptMessage = "Please enter the sentence or word whose letters you wish to count below...";
	private String continuityMsg = "Do you wish to count another string? (Press 'Y' for yes or any other key to exit)";
	private Scanner enteredData;
	private String userData = "";
	private int alphabetContainer[] = new int [52];			//An array for storing the 52 letters of the alphabet (Both capital and small)
	private int frequencyContainer[] = new int [52];		//An array for storing the frequency a letter has appeared
	private int aIndex;	//Short for alphabetContainerIndex
	private int fIndex;	//Short for frequencyContainerIndex
	private int highestFrequency = 0;
	private char highestLetter;
	private int secondHighestFrequency = 0;
	private char secondHighestLetter;
	private int thirdHighestFrequency = 0;
	private char thirdHighestLetter;
	private boolean completion = true;
	
    private AlphabetCounter(){
		//Initial output
        System.out.println(applicationTitle);
		
		while(completion){
			System.out.println(promptMessage);
			enteredData = new Scanner(System.in);
			userData = enteredData.nextLine();
			countLetters(userData);
			
			System.out.println(continuityMsg);
			enteredData = new Scanner (System.in);
			userData = enteredData.nextLine();
			if (userData.equalsIgnoreCase("Y") != true){
				completion = false;
			}
		}
    }
	
	//The countLetters method is for counting the number of times a letter appears in a piece of text and displaying the result in the Command line
	private void countLetters(String entryToCount){
		
		//Storing the Ascii values of all the Capital english alphabet in the 1st half of alphabetContainer array
		for (aIndex = 0; aIndex < 26 ; aIndex++){
			alphabetContainer[aIndex] = 65 + aIndex;
		}
		//Storing the Ascii values of all the small english alphabet in the 2nd half of alphabetContainer array
		for (aIndex = 0; aIndex < 26 ; aIndex++){
			alphabetContainer[26 + aIndex] = 97 + aIndex;
		}
		
		//Initialising the content of the frequencyContainer to zero for safeguarding measures
		for (fIndex = 0; fIndex < frequencyContainer.length ; fIndex++){
			frequencyContainer[fIndex] = 0;
		}
		
		//Counting the number of times a letter appears in the inputed message and storing it in the frequencyContainer array
		for (aIndex = 0; aIndex < entryToCount.length() ; aIndex++){	
			
			for (fIndex = 0; fIndex < alphabetContainer.length; fIndex++){	
				
				if ( entryToCount.charAt(aIndex) == alphabetContainer[fIndex]){
					frequencyContainer[fIndex]++;
				}
			}
		}
		
		//Loop for checking the arrays to find the highestFrequency index number
		for(fIndex = 0 ; fIndex < frequencyContainer.length; fIndex++){
			
			int selected = fIndex;		//Variable called selected as it will be comparing "selected" value in frequencyContainer against preset values
			
			if (frequencyContainer[selected] >= highestFrequency){
				//Storing the current value for highest as second highest before changing it
				thirdHighestLetter = secondHighestLetter;
				secondHighestLetter = highestLetter;
				thirdHighestFrequency = secondHighestFrequency;
				secondHighestFrequency = highestFrequency;
				
				//Changing current highest frequency & letter to new found one
				highestFrequency = frequencyContainer[selected];
				highestLetter = (char) alphabetContainer[selected];
			}
			if (frequencyContainer[selected] >= secondHighestFrequency && frequencyContainer[selected] < highestFrequency ){
				//Storing the current value for 2nd highest as 3rd highest before changing  it
				thirdHighestLetter = secondHighestLetter;
				thirdHighestFrequency = secondHighestFrequency;
				
				//Changing current highest frequency & letter to new found one
				secondHighestFrequency = frequencyContainer[selected];
				secondHighestLetter = (char) alphabetContainer[selected];
			}
			if (frequencyContainer[selected] > thirdHighestFrequency && frequencyContainer[selected] < highestFrequency  && frequencyContainer[selected] < secondHighestFrequency ){
				
				thirdHighestFrequency = frequencyContainer[fIndex];
				thirdHighestLetter = (char) alphabetContainer[fIndex];
			}
		}
		
		//Printing of answers
		System.out.println("The most frequent letters and the number of times they appear are: ");
		if(highestFrequency == 0){
			System.out.println("I'm sorry but that was a Non-alphabetical string.");
		} else if (secondHighestFrequency == 0){	
			System.out.println(highestFrequency+" "+ highestLetter+".");
		} else if (thirdHighestFrequency == 0){
			System.out.println(highestFrequency+" "+ highestLetter+", "+secondHighestFrequency+" "+secondHighestLetter+".");
		} else {
			System.out.println(highestFrequency+" "+ highestLetter+", "+secondHighestFrequency+" "+secondHighestLetter+", and "+thirdHighestFrequency+" "+thirdHighestLetter+".");
		}
		
		//Reinitialising the frequencyVariables to zero after printing to avoid not counting from zero
		highestFrequency = 0;
		secondHighestFrequency = 0;
		thirdHighestFrequency = 0;
	}
	
	//The Main method. It creates an instance of the AlphabetCounter class
	public static void main(String[] arguments){
		AlphabetCounter application = new AlphabetCounter();
		}
}