package com.card_status.repositories;

import com.card_status.entity.DeliveredCard;
import com.card_status.entity.PickUpCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DeliveredCardRepositories extends JpaRepository<DeliveredCard,String> {
    @Query(value = "SELECT * FROM delivered_card WHERE card_id = :cardId", nativeQuery = true)
    Optional<DeliveredCard> findByCard_id(@Param("cardId") String cardId);

    //    Optional<DeliveredCard> findByCard_id(String cardId);

}
