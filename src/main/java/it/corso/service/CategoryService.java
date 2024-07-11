package it.corso.service;

import java.util.List;

import it.corso.dto.CategoryDto;
import it.corso.exception.UnauthorizedException;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CategoryService {
	  
	  void createCategory(CategoryDto courseDto);
	  
	  void deleteCategory(int id) throws UnauthorizedException, ObjectNotFoundException;
	
	  CategoryDto getCategoryById(int id);
	  
	  List<CategoryDto> getAllCategory();

}