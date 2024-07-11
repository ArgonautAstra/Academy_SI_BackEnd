package it.corso.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.CourseAddRequestDto;
import it.corso.dto.CourseDto;
import it.corso.dto.UserSignupDto;
import it.corso.jwt.JWTTokenNeeded;
import it.corso.jwt.Secured;
import it.corso.service.CourseService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//@JWTTokenNeeded
@Path("/course")
//@Secured(role = "Admin")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCourse() {
		
		try {

			List<CourseDto> list = courseService.getAllCourse();
			
			return Response.status(Response.Status.OK).entity(list).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SignupUser(@Valid @RequestBody CourseAddRequestDto course) {
		
		try {
			
			courseService.createCourse(course);
			
			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/category/{id}")
	public Response deleteCourseByCategory(@PathParam("id") int id) {
		
		try {

			courseService.deleteByCategory(id);

			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
