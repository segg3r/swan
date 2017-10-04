package com.segg3r.swan.dashboard;

import com.segg3r.swan.base.RestService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/dashboard")
public class RestDashboardService implements RestService<Dashboard> {

	private final DashboardService dashboardService;

	@Inject
	public RestDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@Override
	public Dashboard getById(long id) {
		Dashboard dashboard = new Dashboard();
		dashboard.setId(id);
		dashboard.setName("Dashboard " + id);

		return dashboard;
	}

	@Override
	public Dashboard add(Dashboard dashboard) {
		dashboard.setId(100);

		return dashboard;
	}

	@Override
	public Dashboard addOrUpdate(long id, Dashboard dashboard) {
		dashboard.setId(id);
		dashboard.setName("Dashboard " + id);

		return dashboard;
	}

	@Override
	public void delete(long id) {
		System.out.println("Deleted " + id);
	}

}
