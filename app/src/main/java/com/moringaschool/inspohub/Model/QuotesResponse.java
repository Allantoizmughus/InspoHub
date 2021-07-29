
package com.moringaschool.inspohub.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuotesResponse {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("totalQuotes")
    @Expose
    private Integer totalQuotes;
    @SerializedName("data")
    @Expose
    private List<Quote> quoteList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public QuotesResponse() {
    }

    /**
     * 
     * @param totalQuotes
     * @param pagination
     * @param quoteList
     * @param message
     * @param statusCode
     */
    public QuotesResponse(Integer statusCode, String message, Pagination pagination, Integer totalQuotes, List<Quote> quoteList) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.pagination = pagination;
        this.totalQuotes = totalQuotes;
        this.quoteList = quoteList;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Integer getTotalQuotes() {
        return totalQuotes;
    }

    public void setTotalQuotes(Integer totalQuotes) {
        this.totalQuotes = totalQuotes;
    }

    public List<Quote> getData() {
        return quoteList;
    }

    public void setData(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

}
