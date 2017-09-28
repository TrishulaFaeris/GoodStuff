package chatbotProject;

import java.util.Scanner;

public class ChatbotMain {

	
	public static Chatbot chatbot = new Chatbot();
	
	public static void main(String[] args) {
		chatbot.startTalking();
	}
	//pasted from class notes "Utility"
	private static Scanner inputSource = new Scanner(System.in);

	public static int findKeyword(String searchString, String keyword, int startPsn) {
		//makes lowercase
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		//find the first position after the startPsn
		int psn = searchString.indexOf(keyword, startPsn);
		
		//keep searching until keyword is found (noNegations and isolated)
		while(psn >= 0) {
			
			if(keywordIsIsolated(psn,keyword,searchString)&& noNegations(searchString,psn)) {
				return psn;
			} else {
				//look for the next occurrence
				psn = searchString.indexOf(keyword, psn +1);
			}
			}
			return -1;
		}
		public static boolean keywordIsIsolated(int psn, String keyword, String s){
			boolean Isolated = false;
			if(psn == 0) 
			{
				if(s.substring(psn,keyword.length()+1).equalsIgnoreCase(keyword)) 
				{
					if(s.substring(s.indexOf(psn+keyword.length()),(s.indexOf(psn+keyword.length()+1))).compareTo("a") < 0)
						Isolated = true;
				}
				else
					Isolated = false;
			}
			else
			{
				if(s.substring(psn,keyword.length()+1).equalsIgnoreCase(keyword)) 
				{
					if(s.substring(s.indexOf(psn+keyword.length()),(s.indexOf(psn+keyword.length()+1))).compareTo("a") < 0)
					{
						if(s.substring(psn-1,psn).compareTo("a") <0 )
						{
							Isolated = true;
						}
					}
				}
				else
				{
					Isolated = false;
				}
			}
			if(Isolated)
				return true;
			else
				return false;
		}

		public static boolean noNegations(String s, int psn){
			return true;
		}


		public static String getInput(){
			return inputSource.nextLine();
		}

		public static void print(String s){
			multiLinePrint(s);
		}

		public static void multiLinePrint(String s){
			String printString = "";
			int cutoff = 25;
			//this while loop last as long as there are words left in the original String
			while(s.length() > 0){

				String currentCut = "";
				String nextWord = "";

				//while the current cut is still less than the line length 
				//AND there are still words left to add
				while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

					//add the next word
					currentCut += nextWord;

					//remove the word that was added from the original String
					s = s.substring(nextWord.length());

					//identify the following word, exclude the space
					int endOfWord = s.indexOf(" ");

					//if there are no more spaces, this is the last word, so add the whole thing
					if(endOfWord == -1) {
						endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
					}

					//the next word should include the space
					nextWord = s.substring(0,endOfWord+1);
				}

				printString +=currentCut+"\n";

			}
			System.out.print(printString);
		}

		public static int getIntegerInput() {
			print("Please enter an integer.");
			String integerString = getInput();
			boolean isInteger = false;
			int value = 0;
			while(!isInteger){
				try{
					value = Integer.parseInt(integerString);
					//will not continue if an error above is thrown
					isInteger = true;//exits loop if entry is valid
				}catch(NumberFormatException e){
					print("You must enter an integer. You better try again.");
					integerString = getInput();
				}
			}
			return value;
		}

}
