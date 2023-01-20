package com.BikkadIT.blog.services.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.entities.Category;
import com.BikkadIT.blog.execeptions.ResourceNotFoundException;
import com.BikkadIT.blog.payloads.CategoryDto;
import com.BikkadIT.blog.repositories.CategoryRepo;
import com.BikkadIT.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	//create
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
	 Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedcat = this.categoryRepo.save(category);
		return this.modelMapper.map(addedcat, CategoryDto.class);
	}

	//update
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).
		orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	//delete
	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
		this.categoryRepo.delete(category);
	}

	//get
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	//getAll
	@Override
	public List<CategoryDto> getCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDto = categories.stream().map((category)->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return categoryDto;
	}
	
       public Category dtoToCategory(CategoryDto categoryDto) {
    	   Category category = this.modelMapper.map(categoryDto, Category.class);
    	   return category;
       }
       
       public CategoryDto categoryToDto(Category category) {
    	   CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
             return categoryDto;
       }
}
