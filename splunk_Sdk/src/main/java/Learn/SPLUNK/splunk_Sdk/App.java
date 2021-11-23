package Learn.SPLUNK.splunk_Sdk;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Splunk!" );
        
        WriteLog.loG();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RealTimeSearch.search("index=\"main\" | table \"Event Log\" ");
    }
}
