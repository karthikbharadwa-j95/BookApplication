package com.cts.digibook.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.digibook.entity.Subscription;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, String> {

	public List<Subscription> findBySubReaderId(String subReaderId);

	public Subscription findBySubBookId(String subBookId);

	public Subscription findBySubscriptionId(String subscriptionId);
}