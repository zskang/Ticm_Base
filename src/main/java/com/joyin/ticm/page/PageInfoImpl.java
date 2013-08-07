package com.joyin.ticm.page;

import java.util.List;

@SuppressWarnings("unchecked")
public class PageInfoImpl implements PageInfo {
    private int pageSize;
    private int start;
    private long totalRecords;
    private List pageData;
    private int pageCount;
    private int currentPageNo;

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

    public PageInfoImpl(List pageData, long totalRecords, int pageSize,
            int currentPageNo) {
        this.pageData = pageData;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.currentPageNo = currentPageNo;

        pageCount = (int) ((totalRecords + pageSize - 1) / pageSize);
        if (totalRecords <= 0) {
            pageCount = 0;
        }

        if (this.currentPageNo == pageCount) {
            this.pageSize = (int) (totalRecords - ((pageCount - 1) * pageSize));
        }

        start = (this.currentPageNo - 1) * pageSize;
    }

    public PageInfoImpl() {
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public long getEndIndex() {
        return start + pageSize - 1;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List getPageData() {
        return pageData;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public long getStartIndex() {
        return start;
    }

    public int getStartOfNextPage() {
        int pageNo = currentPageNo + 1;
        if (pageNo > pageCount) {
            pageNo = pageCount;
        }
        return this.getStartOfPage(pageNo);
    }

    public int getStartOfPage(int pageNo) {
        int startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) {
            startIndex = 1;
        }
        return startIndex;
    }

    public int getStartOfPreviousPage() {
        int pageNo = currentPageNo - 1;
        if (pageNo < 1) {
            pageNo = 1;
        }
        return this.getStartOfPage(pageNo);
    }

    public boolean isNextPageEnable() {
        return currentPageNo < pageCount;
    }

    public boolean isPreviousPageEnable() {
        return currentPageNo > 1;
    }

}
