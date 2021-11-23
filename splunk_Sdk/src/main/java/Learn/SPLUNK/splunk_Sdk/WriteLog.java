package Learn.SPLUNK.splunk_Sdk;

import com.splunk.*;

public class WriteLog {
	
	public static void loG() {
		Connect.connectSplunk();
		
		 Receiver re=Connect.service.getReceiver();
			Args logA=new Args();
			logA.put("sourcetype", "hellowsplunk");
			
			for(int i=0;i<10;i++) {
				re.log("main",logA,"{ \"Event Log\" : "+i+"}");
			}
	}

}
