package DefaultPackage;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;



/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class testfr {

    public static void main(String[] args) {
        ConfigurationManager cm;

        
        cm = new ConfigurationManager(testfr.class.getResource("testfr.config.xml"));
       

        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }

        System.out.println("Say: (Good morning | Hello) ( Bhiksha | Evandro | Paul | Philip | Rita | Will )");

        // loop the recognition until the programm exits.
        while (true) {
            System.out.println("Start speaking. Press Ctrl-C to quit.\n");

            Result result = recognizer.recognize();

            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                System.out.println("You said: " + resultText);
                
                
                	/*String cmd = "espeak -v french bonjour";
                	try{
                		Runtime.getRuntime().exec(cmd);
                	}
                	catch(Exception e){
                		
                	}*/
                
                
            } else {
                System.out.println("I can't hear what you said.\n");
            }
            
            
            
        }
    }
}