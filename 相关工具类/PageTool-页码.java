package com.xiaomi.utils;

public class PageTool {
	private int pageCount;// ��ҳ��
	private int totalCount;// ��������
	private int currentPage;// ��ǰҳ��
	private int lastPage;// ��һҳ
	private int nextPage;// ��һҳ
	private int startIndex;// ��ʼ�±�
	private int pageSize;// ÿҳ������

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageTool() {

	}

	public PageTool(int totalCount, String currentPage) {
		super();
		this.totalCount = totalCount;
		pageSize = 5;//ÿҳ�������̶�Ϊ5��
		//��ʼ����ǰҳ��
		initialCurrentPage(currentPage);
		//��ʼ����ҳ��
		initialPageCount();
		//��ʼ����һҳ
		initalLastPage();
		//��ʼ����һҳ
		initalNextPage();
		//��ʼ����ʼ�±�
		initialStartIndex();
	}
	//��ʼ����ʼ�±귽��
	private void initialStartIndex() {
		startIndex = (currentPage - 1) * pageSize;
	}
	//��һҳ
	private void initalNextPage() {
		if (currentPage == pageCount) {
			nextPage = pageCount;
		}else {
			nextPage = currentPage + 1;
		}
	}
	//��һҳ
	private void initalLastPage() {
		if (currentPage == 1) {
			lastPage = 1;
		}else {
			lastPage = currentPage - 1;
		}
	}
	//��ʼ����ҳ��
	private void initialPageCount() {
		pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
	}
	//��ʼ����ǰҳ�뷽��
	private void initialCurrentPage(String currentPage) {
		/*
			��Ϊ��ǰҳ���Ǵ�ҳ���д�������,��ô�ڵ�һ�ν���show.jspҳ��ʱ, û�а취��ֵ
			��ʱ�ĵ�ǰҳ����ǵ�һҳ,��ֵΪ1
			���������,��������ת��,�����ڼ�ҳ���ǵڼ�ҳ
		 */
		if (currentPage == null) {
			this.currentPage = 1;
		}else {
			this.currentPage = Integer.valueOf(currentPage);
		}
	}

	@Override
	public String toString() {
		return "PageTool [pageCount=" + pageCount + ", totalCount=" + totalCount + ", currentPage=" + currentPage
				+ ", lastPage=" + lastPage + ", nextPage=" + nextPage + ", startIndex=" + startIndex + ", pageSize="
				+ pageSize + "]";
	}	
	

}
