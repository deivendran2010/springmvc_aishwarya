package com.pranion.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CategoryDTO {
	
	private int categoryId;
	
	private String categoryName;
	
	private List<SubcategoryDTO> subcategoryList;

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the subcategoryList
	 */
	public List<SubcategoryDTO> getSubcategoryList() {
		return subcategoryList;
	}

	/**
	 * @param subcategoryList the subcategoryList to set
	 */
	public void setSubcategoryList(List<SubcategoryDTO> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

}
