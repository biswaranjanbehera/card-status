package com.card_status.repositories;

import com.card_status.entity.PickUpCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupRepositories extends JpaRepository<PickUpCard,Integer> {
}
