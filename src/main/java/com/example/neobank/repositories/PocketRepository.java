package com.example.neobank.repositories;

import com.example.neobank.models.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PocketRepository extends JpaRepository<Pocket, UUID> {
    @Query(value = "SELECT p.id,p.name,p.sub_amount,p.balance_id FROM pockets p JOIN balance b ON p.balance_id = b.id WHERE b.id = UUID_TO_BIN(?1) AND p.id = UUID_TO_BIN(?2)",nativeQuery = true)
    Pocket findPocketBalance(@Param("pocket_id") String pocket_id, @Param("balance_id") String balance_id);
}
