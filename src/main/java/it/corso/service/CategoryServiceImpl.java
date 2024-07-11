package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoryDao;
import it.corso.dto.CategoryDto;
import it.corso.exception.UnauthorizedException;
import it.corso.model.Category;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public void createCategory(CategoryDto courseDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int id) throws UnauthorizedException, ObjectNotFoundException {
		
		Optional<Category> optional = categoryDao.findById(id);
		
		if(optional.isPresent()) {
			
			Category categoryDb = optional.get();
			
			if(!categoryDb.getCourses().isEmpty()) 
				categoryDao.delete(categoryDb);
			else 
				throw new UnauthorizedException();
			
		} else {
			throw new ObjectNotFoundException(null);
		}
		
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> category = (List<Category>) categoryDao.findAll();
		List<CategoryDto> categoryDto = new ArrayList<>();
		
		category.forEach(c -> categoryDto.add(modelMapper.map(c, CategoryDto.class)));
		
		return categoryDto;
	}

}
