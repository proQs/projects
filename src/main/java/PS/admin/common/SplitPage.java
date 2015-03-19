package PS.admin.common;

import java.io.Serializable;
import java.util.List;

public class SplitPage<T> implements Serializable {

	private static final long serialVersionUID = -7914983945613661637L;

	/**
	 * 分页查询参数
	 */
	private String orderColunm;// 排序条件
	private String orderMode;// 排序方式
	private int pageNumber = Config.default_pageNumber;// 第几页
	private int pageSize = Config.default_pageSize;// 每页显示几多

	/**
	 * 分页结果住数据
	 */
	private List<T> list; // 总数据
	private int totalPage; // 总页数
	private int totalRow; // 总行数

	/**
	 * 分页显示辅助属性
	 */
	private int currentPageCount;// 当前页记录数量
	private boolean isFirst;// 是否第一页
	private boolean isLast;// 是否最后一页

	public void manualSplit() {
		this.totalRow = list.size();
		getTotalPage();
	}
	/**
	 * 分页计算
	 */
	public void compute() {
		if(totalRow == 0){
			getTotalPage();
		}
		
		if (pageNumber == 1) {
			this.isFirst = true;
		} else {
			this.isFirst = false;
		}

		if (pageNumber == totalPage) {
			this.isLast = true;
		} else {
			this.isLast = false;
		}
	}

	public int getTotalPage() {
		if ((this.totalRow % this.pageSize) == 0) {
			this.totalPage = this.totalRow / this.pageSize;// 计算多少页
		} else {
			this.totalPage = this.totalRow / this.pageSize + 1;// 计算多少页
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void addList(List<T> list) {
		this.list.addAll(list);
	}

	public String getOrderColunm() {
		return orderColunm;
	}

	public void setOrderColunm(String orderColunm) {
		this.orderColunm = orderColunm;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public int getPageNumber() {
		if (pageNumber <= 0) {
			pageNumber = Config.default_pageNumber;
		}
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		if (pageSize <= 0) {
			pageSize = Config.default_pageSize;
		}
		if (pageSize > 200) {
			pageSize = Config.default_pageSize;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageCount() {
		return currentPageCount;
	}

	public void setCurrentPageCount(int currentPageCount) {
		this.currentPageCount = currentPageCount;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	public List<T> getPageList() {
		List<T> ls;
		if (isFirst) {
			if (totalRow < pageSize) {
				ls = list.subList(0, totalRow);
			} else {
				ls = list.subList(0, pageSize);
			}
		} else if (isLast) {
			ls = list.subList(pageSize * (totalPage - 1), list.size());
		} else {
			ls = list.subList(pageSize * (pageNumber - 1), pageSize * pageNumber);
		}
		return ls;
	}


}
