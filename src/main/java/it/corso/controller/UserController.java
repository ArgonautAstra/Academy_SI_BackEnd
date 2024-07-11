package it.corso.controller;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.corso.dto.UserDto;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserLoginResponseDto;
import it.corso.dto.UserSignupDto;
import it.corso.dto.UserUpdateDto;
import it.corso.model.Role;
import it.corso.model.User;
import it.corso.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserController {	
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SignupUser(@Valid @RequestBody UserSignupDto user) {

		if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}", user.getPassword()))
			return Response.status(Response.Status.BAD_REQUEST).build();
		
		try {
			
			if(userService.existsUserByEmail(user.getEmail()))
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			userService.userSignup(user);
			
			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByEmail(@PathParam("email") String email) {
		
		try {

			UserDto user = userService.getUserDtoByEmail(email);
			
			return Response.status(Response.Status.OK).entity(user).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("/{email}")
	public Response deleteUserByEmail(@PathParam("email") String email) {
		
		try {

			userService.userDelete(email);
			
			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Path("/")
	public Response updateUserById(@RequestBody UserUpdateDto user) {
		
		try {

			userService.userUpdate(user);
			
			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Path("{id_user}/course/{id_course}/subscribe")
	public Response addCourse(@PathParam("id_user") int userId, @PathParam("id_course") int courseId) {
		
		try {
		
			userService.addCourse(userId, courseId);
		
			return Response.status(Response.Status.OK).build();
		
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Path("{id_user}/course/{id_course}/unsubscribe")
	public Response deleteCourse(@PathParam("id_user") int userId, @PathParam("id_course") int courseId) {
		
		try {
		
			userService.deleteCourse(userId, courseId);
		
			return Response.status(Response.Status.OK).build();
		
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {
		
		try {

			List<UserDto> list = userService.getAllUser();
			
			return Response.status(Response.Status.OK).entity(list).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
	
		try {
			
			if (userService.login(userLoginRequestDto)) 
				return Response.ok(issueToken(userLoginRequestDto.getEmail())).build();
			
		} catch (Exception e) {
			return Response.status (Response.Status.BAD_REQUEST).build();
		} 
		
		return Response.status (Response.Status.BAD_REQUEST).build();
	}
	
	private UserLoginResponseDto issueToken(String email) {
		  
		  byte[] secret = "33trentinientraronoatrentotuttie33trotterellando1234567890".getBytes();
		  Key key = Keys.hmacShaKeyFor(secret);
		  
		  User userInfo = userService.getUserByEmail(email);
		  Map<String, Object> map = new HashMap<>();
		  
		  map.put("firstname", userInfo.getFirstname());
		  map.put("lastname", userInfo.getLastname());
		  map.put("email", email);
		  
		  List<String> role = new ArrayList<>();
		  
		  for (Role item : userInfo.getRoles()) {
			  role.add(item.getTipology().name());
		  }
		  
		  map.put("roles", role);
		  
		  Date creation = new Date();
		  Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));
		  String jwtToken = Jwts.builder()
		                        .setClaims(map)
		                        .setIssuer("http://localhost:8080") 
		                        .setIssuedAt(creation)
		                        .setExpiration(end)
		                        .signWith(key)
		                        .compact();
		  
		  UserLoginResponseDto token = new UserLoginResponseDto(); 
		  
		  token.setToken(jwtToken);
		  token.setTtl(end);
		  token.setTokenCreationTime(creation);
		  
		  return token;
	}
	
}
