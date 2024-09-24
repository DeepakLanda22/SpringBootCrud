package com.springboot.crud.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.Model.Ticket;

@Repository
public interface TicketBookingRepo extends JpaRepository<Ticket,Integer>{

}
