import com.segg3r.swan.SwanApplication;
import com.segg3r.swan.dashboard.RestDashboardService;

import static javax.ws.rs.core.UriBuilder.fromUri;

public class Runner {

	public static void main(String[] args)  {
		new SwanApplication()
				.resources(RestDashboardService.class)
				.uri(fromUri("http://localhost").port(9998).build())
				.start();
	}

}
