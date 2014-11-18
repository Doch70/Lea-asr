package DefaultPackage;

import java.io.IOException;
import com.developpez.adiguba.shell.Shell;

public class fonction {
	
	public static void say(String text)
	{
		Shell sh = new Shell();
		
		try
		{
			sh.command("pico2wave -l fr-FR  -w reponse.wav '" + text + "'").consumeAsString();
			sh.command("play reponse.wav").consumeAsString();
			sh.command("rm reponse.wav").consumeAsString();
			
		}catch (IOException e)
		{

		} // END try...catch
	}// END say(String text)
}// END fonction class
