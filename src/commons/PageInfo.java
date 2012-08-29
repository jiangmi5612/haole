package commons;

import java.util.List;

import org.hibernate.Query;

public class PageInfo {

	private List<?> list;		//保存取得的一页记录，用以曲线实现双返回值
	private int allRow;		//总记录数
	private int pageSize;		//每页记录数
	private int totalPage;		//总页数
	private int currentPage;	//当前页码
	
	private boolean isFirstPage;	//是否为第一页
	private boolean isLastPage;	//是否为最后一页
	
	private String listPage;	//用于展示页面的链接地址，截止到pageNo=，例如listProduct?pageNo=
	
	/**
	 * 独立构造函数
	 * @param allRow 总记录数
	 * @param pageSize 每页记录数
	 */
	public PageInfo(int allRow, int pageSize, int page){
		this.allRow = allRow;
		this.pageSize = pageSize;
		this.currentPage = page > 0? page:1;
		this.totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
		refreshInfo();
	}
	
	/**
	 * 与Hibernate耦合的构造函数
	 * @param countQuery 用于统计总行数的查询
	 * @param listQuery 用于获取数据的查询
	 * @param currentPage 需要获取的页码
	 * @param pageSize 每页记录数
	 */
	public PageInfo(Query countQuery, Query listQuery,int pageSize, int page){
		this.allRow = Integer.parseInt(countQuery.uniqueResult().toString());
		this.currentPage = page > 0? page:1;
		this.pageSize = pageSize;
		this.totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
		listQuery.setFirstResult(getOffSet());
		listQuery.setMaxResults(pageSize);
		list = listQuery.list();
		refreshInfo();
	}
	
	/**
	 * 在变更分页信息类的基本信息（如当前页码等）后
	 * 更新相关的判断信息
	 */
	public void refreshInfo() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
	}
	
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * @return the allRow
	 */
	public int getAllRow() {
		return allRow;
	}
	
	/**
	 * @param allRow the allRow to set
	 */
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = (currentPage == 0?1:currentPage);
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return the offSet
	 */
	public int getOffSet() {
		return pageSize * (currentPage - 1);
	}

	/**
	 * @return the isFirstPage
	 */
	public boolean isFirstPage() {
		return currentPage == 1;
	}
	/**

	/**
	 * @return the isLastPage
	 */
	public boolean isLastPage() {
		return currentPage == totalPage;
	}
	/**

	/**
	 * @return the listPage
	 */
	public String getListPage() {
		return listPage;
	}

	/**
	 * @param listPage the listPage to set
	 */
	public void setListPage(String listPage) {
		this.listPage = listPage;
	}
	
}
