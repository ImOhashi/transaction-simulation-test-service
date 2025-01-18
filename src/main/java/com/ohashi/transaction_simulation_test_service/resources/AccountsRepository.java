package com.ohashi.transaction_simulation_test_service.resources;

import com.ohashi.transaction_simulation_test_service.domain.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByDocumentNumber(String documentNumber);
}
