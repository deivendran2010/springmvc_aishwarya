package com.pranion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranion.dto.CategoryDTO;

@Service
public interface CategoryService {

	List<CategoryDTO> getCategoryList();

}
