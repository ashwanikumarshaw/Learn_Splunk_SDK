package Learn.SPLUNK.splunk_Sdk;

import java.io.*;

import com.splunk.*;

public class RealTimeSearch  {

	public static void search(String qu) {		
		Connect.connectSplunk();
		// Create an argument map for the export arguments
		JobExportArgs exportArgs = new JobExportArgs();
		exportArgs.setEarliestTime("-1m");
		exportArgs.setLatestTime("now");
		exportArgs.setSearchMode(JobExportArgs.SearchMode.NORMAL); 

		// Run the search with a search query and export arguments
		String mySearch =  "search "+qu;
		
		InputStream exportSearch = Connect.service.export(mySearch, exportArgs);

		// Display results using the SDK's multi-results reader for XML 
		MultiResultsReaderXml multiResultsReader;
		try {
			multiResultsReader = new MultiResultsReaderXml(exportSearch);
		

		int counter = 0;  // count the number of events
		for (SearchResults searchResults : multiResultsReader)
		{
		    for (Event event : searchResults) {
		        System.out.println("***** Event " + counter++ + " *****");
		        for (String key: event.keySet())
		        	if(key.contains("Event Log"))//Logged value 
		            System.out.println("  key " + key + " value :  " + event.get(key));
		    }
		}
			multiResultsReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
}
