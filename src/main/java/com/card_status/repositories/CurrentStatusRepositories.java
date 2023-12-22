package com.card_status.repositories;

import com.card_status.entity.CurrentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentStatusRepositories extends JpaRepository<CurrentStatus,String> {
}
