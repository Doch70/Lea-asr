package DefaultPackage;

import java.io.IOException;

import com.developpez.adiguba.shell.Shell;

public class fonction {
	public static void say(String text) {
		Shell sh = new Shell();
		try {
			String create_sound = "pico2wave -l fr-FR  -w reponse.wav " + text;
			String play_sound = "play reponse.wav";
			String result = sh.command(create_sound).consumeAsString();
			//System.out.println(result);
			String play = sh.command(play_sound).consumeAsString();
			//System.out.println(play);
			String delete_file = sh.command("rm reponse.wav").consumeAsString();
			//System.out.println(delete_file);
			
		} catch (IllegalStateException | IOException e) {

		}
	}
}
