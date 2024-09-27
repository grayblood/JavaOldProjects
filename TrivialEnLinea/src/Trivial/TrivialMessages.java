package Trivial;

public class  TrivialMessages
{
	public static final String ACK = "ACK";
	public static final String WELCOME = "BENVINGUT";
	public static final String STARTING = "PREPARAT";
	public static final String ANSWER_CORRECT = ":pogchamp:";
	public static final String ANSWER_WRONG = ":peepoclown:";
	public static final String CONTINUE = "'TAS PICAO?";
	public static final String CONTINUE_YES = "NIPAH";
	public static final String CONTINUE_NO = "PLEGA";
	
	public static final byte BYTE_ACK = 0b00000001;
	public static final byte BYTE_WELCOME = 0b00000010;
	public static final byte BYTE_NICK_UNAVAILABLE = 0b00000011;
	public static final byte BYTE_QUEUE = 0b00000100;
	public static final byte BYTE_ON_GAME = 0b00000101;
	public static final byte BYTE_ANSWER_CORRECT = 0b00000110;
	public static final byte BYTE_ANSWER_WRONG = 0b00000111;
	public static final byte BYTE_CONTINUE = 0b00001000;
	public static final byte BYTE_CONTINUE_YES = 0b00001001;
	public static final byte BYTE_CONTINUE_NO = 0b00001010;
	
	public static String msgToString(byte message)
	{
		String toString = Integer.toBinaryString(message) + " -> ";
		switch(message)
		{
			case BYTE_ACK:
				 toString += "ACK";
				 break;
			case BYTE_WELCOME:
				 toString += "WELCOME";
				 break;
			case BYTE_NICK_UNAVAILABLE:
				 toString += "NICK UNAVAILABLE";
				 break;
			case BYTE_QUEUE:
				 toString += "YOU ARE ON QUEUE";
				 break;
			case BYTE_ON_GAME:
				 toString += "THERE'S AN ONGOING GAME";
				 break;
			case BYTE_ANSWER_CORRECT:
				 toString += "CORRECT ANSWER";
				 break;
			case BYTE_ANSWER_WRONG:
				 toString += "WRONG ANSWER";
				 break;
			case BYTE_CONTINUE:
				 toString += "WANT TO CONTINUE?";
				 break;
			case BYTE_CONTINUE_YES:
				 toString += "WANTS TO CONTINUE";
				 break;
			case BYTE_CONTINUE_NO:
				 toString += "DOESN'T WANT TO CONTINUE";
				 break;
			default:
				 toString += "UNKNOWN MESSAGE";
				 break;
		}
		return toString;
	}
}