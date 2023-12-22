package com.card_status.repositories;

import com.card_status.entity.PickUpCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PickupRepositories extends JpaRepository<PickUpCard,Integer> {

    @Query(value = "SELECT * FROM pickup_card WHERE card_id = :cardId", nativeQuery = true)
    Optional<PickUpCard> findByCard_id(@Param("cardId") String cardId);

    //    @Query("SELECT * FROM PickUpCard de WHERE de.card_id = :cardId")
    //    PickUpCard findByCard_id(String card_id);//card_id

    //    @Query("SELECT * FROM PickUpCard de WHERE de.card_id = :cardId")
    //    PickUpCard findCard(@Param("cardId") String cardId);
}
