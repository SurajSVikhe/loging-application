package com.BikkadIT.blog.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.payloads.ApiResponse;
import com.BikkadIT.blog.payloads.CategoryDto;
import com.BikkadIT.blog.payloads.UserDto;
import com.BikkadIT.blog.services.CategoryService;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,categoryId);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	   //delete
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse>deleteCategory(@PathVariable("categoryId")Integer categoryid){
			
			this.categoryService.deleteCategory(categoryid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
		}
		
		//GET  - Single Category get
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto>getCategory(@PathVariable  Integer categoryId){
			CategoryDto categoryDto=this.categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
				}
	//getAll
		@GetMapping
		public ResponseEntity<List<CategoryDto>>getCategories(){
			
			List<CategoryDto> categories = this.categoryService.getCategory();
			
			return ResponseEntity.ok(categories);
		}
}
