package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dto.CategoryDto;
import it.corso.exception.UnauthorizedException;
import it.corso.jwt.JWTTokenNeeded;
import it.corso.jwt.Secured;
import it.corso.service.CategoryService;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javassist.tools.rmi.ObjectNotFoundException;

//@JWTTokenNeeded
@Path("/category")
//@Secured(role = "Admin")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategory() {
		
		try {

			List<CategoryDto> list = categoryService.getAllCategory();
			
			return Response.status(Response.Status.OK).entity(list).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	@DELETE
	@Path("/")
	public Response deleteCategory(@PathParam("id") int id) {
		
		try {
			
			categoryService.deleteCategory(id);

			return Response.status(Response.Status.OK).build();
			
		} catch(UnauthorizedException e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch(ObjectNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
