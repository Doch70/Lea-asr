package DefaultPackage;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
public class Lea {

    public static void main(String[] args)
    {
        ConfigurationManager cm;
        cm = new ConfigurationManager(Lea.class.getResource("Lea.sphinx4.config.xml"));
        												// acces au fichier de config

        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();							// allocation du moteur de
        												// reconnaissance vocal
        											
        
        Microphone microphone = (Microphone) cm.lookup("microphone");
        
        if (!microphone.startRecording())
        {
            System.out.println("Impossible de démarrer le micro.");
            recognizer.deallocate();
            System.exit(1);
        }

        
        
        
        
        
        System.out.println("Lea vous écoute : ");			
        fonction.say("Bonjour");							// pour les tests
        
//=====================Grande Boucle================================
        while (true)
        {
            System.out.println("Vous pouvez parler :\n");
            
            Result result = recognizer.recognize();

            if (result != null)
            {
            	
                String resultText = result.getBestFinalResultNoFiller();
                
                System.out.println("Vous avez dit : " + resultText);
                
                if (resultText.contains("bonjour"))
                {
                	fonction.say("Bonjour enculé de merde!");
                }
                
            }else
            {
                System.out.println("Je n'ai pas entendu ce que vous avez dit .\n");
            }
            
            
            
        }// END while(true)
        
    }// END main
    
}
