package com.example.msi.katalogfilm0261;

import java.util.List;

public class Movie{
	private com.example.msi.katalogfilm0261.Dates dates;
	private int page;
	private int totalPages;
	private List<com.example.msi.katalogfilm0261.ResultsItem> results = null;
	private int totalResults;

	public void setDates(com.example.msi.katalogfilm0261.Dates dates){
		this.dates = dates;
	}

	public com.example.msi.katalogfilm0261.Dates getDates(){
		return dates;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<com.example.msi.katalogfilm0261.ResultsItem> results){
		this.results = results;
	}

	public List<com.example.msi.katalogfilm0261.ResultsItem> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"Movie{" + 
			"dates = '" + dates + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}