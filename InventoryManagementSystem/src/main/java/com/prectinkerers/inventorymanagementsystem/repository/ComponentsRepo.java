package com.prectinkerers.inventorymanagementsystem.repository;

import com.prectinkerers.inventorymanagementsystem.dao.components.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentsRepo extends JpaRepository<Component, Integer> {

    @Query(
        "SELECT c FROM Component c WHERE "+
        "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword , '%')) OR " +
        "LOWER(c.description) LIKE LOWER(CONCAT('%', :keyword , '%')) OR " +
        "LOWER(c.explanatoryName) LIKE LOWER(CONCAT('%', :keyword , '%')) "
    )
    List<Component> searchComponent(String keyword);
}