package chatbotProject;

public class Chatbot {

	private String userName;
	private Topic Kevin;
	private boolean chatting;
	
	public Chatbot() {
		Kevin = new ChatbotKevin();
		userName = "unknown user";
		chatting = true;
	}
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			string response = ChatbotMain.getInput();
			if(Kevin.isTriggered(response)) {
				chatting = false;
				Kevin.startChatting();
			}
			else
			{
				ChatbotMain.print("I am sorry. I do not understand.");
			}
		}
	}

}
