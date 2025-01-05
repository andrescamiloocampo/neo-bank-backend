package com.example.neobank.repositories;

import com.example.neobank.models.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PocketRepository extends JpaRepository<Pocket, UUID> {
}
