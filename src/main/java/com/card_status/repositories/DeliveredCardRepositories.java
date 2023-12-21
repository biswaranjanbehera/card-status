package com.card_status.repositories;

import com.card_status.entity.DeliveredCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveredCardRepositories extends JpaRepository<DeliveredCard,String> {
}
