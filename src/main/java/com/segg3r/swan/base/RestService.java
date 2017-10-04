package com.segg3r.swan.base;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface RestService<T> {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	T getById(@PathParam("id") long id);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	T add(T entity);

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	T addOrUpdate(@PathParam("id") long id, T entity);

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void delete(@PathParam("id") long id);

}
