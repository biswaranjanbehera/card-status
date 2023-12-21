package com.card_status.repositories;

import com.card_status.entity.DeliveredException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveredExceptionRepositories extends JpaRepository<DeliveredException,String> {
}
