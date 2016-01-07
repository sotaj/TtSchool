package pingPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunGet implements Runnable{
	private boolean running = true;	
	public void printPing(){

}
public void stahp(){
	running=false;
}

	@Override
	public void run() {
		try{
			
			Process p = Runtime.getRuntime().exec("ping " + PingMain.ipIn.getText());
			 //p.waitFor();
			   BufferedReader reader = 
				         new BufferedReader(new InputStreamReader(p.getInputStream()));
				 
				    String line = "";			
				    
				    
				    	while ((line = reader.readLine())!= null || running == true) {
				    	
				    	StringBuilder sb = new StringBuilder();
					sb.append(line + "\n");
			
					
						System.out.println(sb.toString());	
						
					}
				    //	while (running) {		    
					//	}
				 
		}							    
		 catch (IOException e1) {
			e1.printStackTrace();
			
		}
	}
}