/**
 * 
 */
package com.br.senior.dto;

/**
 * @author bruno.freiberger
 *
 */
public class PagebleData {

	private CustomPageable pageable;
	private CityFilterDTO filter;
	private Sort sort;

	public CustomPageable getPageable() {
		return pageable;
	}

	public void setPageable(CustomPageable pageable) {
		this.pageable = pageable;
	}

	public CityFilterDTO getFilter() {
		return filter;
	}

	public void setFilter(CityFilterDTO filter) {
		this.filter = filter;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
