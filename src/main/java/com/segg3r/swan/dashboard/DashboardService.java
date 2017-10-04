package com.segg3r.swan.dashboard;

import javax.inject.Inject;

public class DashboardService {

	private final DashboardRepository dashboardRepository;

	@Inject
	public DashboardService(DashboardRepository dashboardRepository) {
		this.dashboardRepository = dashboardRepository;
	}

	public void createDashboard(Dashboard dashboard) {
		dashboardRepository.createDashboard(dashboard);
	}

}

