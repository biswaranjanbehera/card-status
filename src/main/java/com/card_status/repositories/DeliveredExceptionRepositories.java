package com.card_status.repositories;

import com.card_status.entity.DeliveredCard;
import com.card_status.entity.DeliveredException;
import com.card_status.entity.PickUpCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeliveredExceptionRepositories extends JpaRepository<DeliveredException,String> {

    @Query(value = "SELECT * FROM delivered_exception WHERE card_id = :cardId", nativeQuery = true)
    Optional<DeliveredException> findByCard_id(@Param("cardId") String cardId);

    @Query("SELECT COUNT(de) FROM DeliveredException de WHERE de.card_id = :cardId")
    int countByCardId(@Param("cardId") String cardId);



    @Query(value = "SELECT * FROM delivered_exception WHERE card_id = :cardId", nativeQuery = true)
    List<DeliveredException> findAllByCard_id(@Param("cardId") String cardId);

    //    @Query("SELECT * FROM DeliveredException de WHERE de.card_id = :cardId")
    //    Optional<DeliveredException> findByCard_id(String cardId);
    //    List<DeliveredException> findAllByCard_id(String cardId);


}
