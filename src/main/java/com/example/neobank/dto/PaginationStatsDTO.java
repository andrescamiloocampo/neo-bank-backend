package com.example.neobank.dto;


public class PaginationStatsDTO {
    private long totalRecords;
    private long totalPages;

    public PaginationStatsDTO(long totalRecords, long totalPages) {
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
    }

    public PaginationStatsDTO() {
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
