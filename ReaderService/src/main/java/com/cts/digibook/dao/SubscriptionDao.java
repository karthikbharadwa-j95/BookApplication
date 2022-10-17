package com.cts.digibook.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.digibook.entity.Subscription;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, String> {

	public List<Subscription> findBySubReaderId(String subReaderId);

	public Subscription findBySubBookId(String subBookId);

	public Subscription findBySubscriptionId(String subscriptionId);
	
	@Query(nativeQuery = false, value = "Select b from Subscription b where b.subReaderEmail = ?1 and b.subBookId=?2" )
	public Optional<Subscription> findBySubBookIdAndSubReaderEmail(String emailId, String bookId);
}