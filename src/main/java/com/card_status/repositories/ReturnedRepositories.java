package com.card_status.repositories;

import com.card_status.entity.Returned;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnedRepositories extends JpaRepository<Returned,String> {
}
