package com.segg3r.swan;

import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.google.inject.Guice.createInjector;
import static java.lang.System.nanoTime;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.glassfish.jersey.jetty.JettyHttpContainerFactory.createServer;

public class SwanApplication {

	private static final Logger LOG = Logger.getLogger(SwanApplication.class.getName());

	private List<Module> modules = emptyList();
	private List<Class<?>> resourceClasses = emptyList();
	private URI uri;

	public SwanApplication() {
	}

	public void start() {
		if (resourceClasses == null || resourceClasses.isEmpty())
			throw new SwanException("Cannot start Swan application without resource classes.");
		if (uri == null)
			throw new SwanException("Cannot start Swan application without uri.");

		long beforeStart = nanoTime();
		startServer();
		long afterStart = nanoTime();
		long tookMs = (afterStart - beforeStart) / 1_000_000;
		LOG.info("Swan application started in " + tookMs + " ms.");
	}

	private void startServer() {
		try {
			ResourceConfig resourceConfig = buildResourceConfig();
			Server server = createServer(uri, resourceConfig);
			server.start();
		} catch (Exception e) {
			throw new SwanException("Could not start Swan application embedded server.", e);
		}
	}

	private ResourceConfig buildResourceConfig() {
		Injector injector = createInjector(modules);
		ResourceConfig resourceConfig = new ResourceConfig();

		resourceClasses.stream()
				.map(injector::getInstance)
				.forEach(resourceConfig::register);

		return resourceConfig;
	}

	public SwanApplication modules(Module... modules) {
		this.modules = asList(modules);
		return this;
	}

	public SwanApplication resources(Class<?>... resources) {
		this.resourceClasses = asList(resources);
		return this;
	}

	public SwanApplication uri(URI uri) {
		this.uri = uri;
		return this;
	}

}
