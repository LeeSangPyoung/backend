package com.example.auction.domain;

import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<Auction, Long>{    // Repository Pattern Interface
  
}