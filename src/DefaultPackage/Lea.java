package DefaultPackage;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;



/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class Lea {

    public static void main(String[] args) {
        ConfigurationManager cm;

        
        cm = new ConfigurationManager(Lea.class.getResource("Lea.sphinx4.config.xml"));
       

        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Impossible de démarrer le micro.");
            recognizer.deallocate();
            System.exit(1);
        }

        System.out.println("Lea vous écoute : ");

        // loop the recognition until the programm exits.
        while (true) {
            System.out.println("Vous pouvez parler :\n");

            Result result = recognizer.recognize();

            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                System.out.println("Vous avez dit: " + resultText);
                
                if (resultText.contains("bonjour")) {
                	String cmd = "espeak -v french bonjour";
                	try{
                		Runtime.getRuntime().exec(cmd);
                	}
                	catch(Exception e){
                		
                	}
            }
                
            } else {
                System.out.println("Je n'ai pas entendu ce que vous avez dit .\n");
            }
            
            
            
        }
    }
}
