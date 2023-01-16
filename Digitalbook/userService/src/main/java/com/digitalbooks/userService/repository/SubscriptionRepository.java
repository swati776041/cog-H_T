package com.digitalbooks.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.userService.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
