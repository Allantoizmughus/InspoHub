
package com.moringaschool.inspohub.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pagination {

    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("nextPage")
    @Expose
    private Integer nextPage;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param nextPage
     * @param totalPages
     * @param currentPage
     */
    public Pagination(Integer currentPage, Integer nextPage, Integer totalPages) {
        super();
        this.currentPage = currentPage;
        this.nextPage = nextPage;
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
