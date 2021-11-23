package Learn.SPLUNK.splunk_Sdk;

import com.splunk.*;

public class Connect {
	public static Service service;

	public static void connectSplunk() {

		/*
		 * Overriding the static method setSslSecurityProtocol to implement the security
		 * protocol of choice
		 */
		HttpService.setSslSecurityProtocol( SSLSecurityProtocol.TLSv1_2 );
		/* end comment for overriding the method setSslSecurityProtocol */

		ServiceArgs loginArgs = new ServiceArgs();
		loginArgs.setUsername("ashwanikumarshaw");
		loginArgs.setPassword("");
		loginArgs.setHost("127.0.0.1");
		loginArgs.setPort(8089);

		// Create a Service instance and log in with the argument map
		service = Service.connect(loginArgs);
		System.out.println(service.getToken());
	}

}
