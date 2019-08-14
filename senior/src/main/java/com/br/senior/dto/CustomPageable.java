/**
 * 
 */
package com.br.senior.dto;


/**
 * @author bruno.freiberger
 *
 */
public class CustomPageable {
	private Integer page;
	private Integer size;
	private Sort sort;
	
	public CustomPageable(Integer page, Integer size, Sort sort) {
		this.page = page;
		this.size = size;
		this.sort = sort;
	}
	
	public CustomPageable() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
