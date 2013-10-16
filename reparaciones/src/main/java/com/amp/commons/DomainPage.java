package com.amp.commons;

import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.h2.mvstore.Page;

public abstract class DomainPage<T> {
	
	private class PageNumber{
		
		private int numPage;
		
		public PageNumber(int num){
			 this.numPage = num;
		}

		public int getNumPage() {
			return numPage;
		}		
	}
	
	private List<T> pageElements; 	
	private int numberOfPages;
	private int pageNumber;
	private List<PageNumber> pageNumbers;

	
	public DomainPage(){		
	}

	public List<T> getPageElements() {
		return pageElements;
	}

	public void setPageElements(List<T> pageElements) {
		this.pageElements = pageElements;
		java.util.Iterator<T> it = pageElements.iterator();
		
		int pageNumber=1;
		while(it.hasNext()){			
			PageNumber aPageNumber = new PageNumber(pageNumber);
			this.pageNumbers.add(aPageNumber);
			pageNumber++;
		}		
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<PageNumber> getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(List<PageNumber> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}	
}
