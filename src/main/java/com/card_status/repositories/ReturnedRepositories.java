package com.card_status.repositories;

import com.card_status.entity.DeliveredException;
import com.card_status.entity.PickUpCard;
import com.card_status.entity.Returned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReturnedRepositories extends JpaRepository<Returned,String> {
    @Query(value = "SELECT * FROM returned WHERE card_id = :cardId", nativeQuery = true)
    Optional<Returned> findByCard_id(@Param("cardId") String cardId);

    //   Optional<Returned> findByCard_id(String cardId);
}
