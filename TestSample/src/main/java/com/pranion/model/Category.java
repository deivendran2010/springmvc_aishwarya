package com.pranion.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Category {
	
	private int categoryId;
	
	private String categoryName;
	
	private List<Subcategory> subcategoryList;

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
	public List<Subcategory> getSubcategoryList() {
		return subcategoryList;
	}

	/**
	 * @param subcategoryList the subcategoryList to set
	 */
	public void setSubcategoryList(List<Subcategory> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
