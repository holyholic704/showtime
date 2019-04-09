package com.showtime.util;

public class Page {
	int start = 0;
	int count = 10;
	int last = 0;
	int pageSize = 0;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public void caculateLast(int total) {
		pageSize = (int) Math.ceil((double) total / count);
		if (0 == total % count) {
			last = total - count;
		} else {
			last = total - total % count;
		}
	}

}
