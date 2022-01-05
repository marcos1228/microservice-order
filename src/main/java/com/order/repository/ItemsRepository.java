package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.domain.model.Items;
@Repository
public interface ItemsRepository  extends JpaRepository<Items, Long>{

}
