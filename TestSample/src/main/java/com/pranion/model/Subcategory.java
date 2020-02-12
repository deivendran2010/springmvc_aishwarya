package com.pranion.model;

import org.springframework.stereotype.Component;

@Component
public class Subcategory {
	
	private int subCategoryId;
	
	private String subCategoryName;
	
	private int categoryId;

	/**
	 * @return the subCategoryId
	 */
	public int getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subcategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", categoryId="
				+ categoryId + "]";
	}

}
