package com.example.neobank.repositories;

import com.example.neobank.dto.PaginationStatsDTO;
import com.example.neobank.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface TransactionsRepository extends JpaRepository<Transactions, UUID> {
    @Query(value = "SELECT * FROM transactions WHERE user_id=UUID_TO_BIN(:user_id) ORDER BY timestamp LIMIT :registers OFFSET :page",nativeQuery = true)
    List<Transactions> getTransactions(@Param(value = "page") int page, @Param(value = "registers") int registers,@Param(value = "user_id") String uid);

    @Query(value = "SELECT CAST(COUNT(*) AS SIGNED) as totalRecords,CAST(CEIL(COUNT(*)/:batch_size) AS SIGNED) as totalPages FROM transactions WHERE user_id = UUID_TO_BIN(:user_id)",nativeQuery = true)
    PaginationStatsDTO getPaginationInfo(@Param(value = "batch_size") int batchSize,@Param(value = "user_id") String uid);

}
