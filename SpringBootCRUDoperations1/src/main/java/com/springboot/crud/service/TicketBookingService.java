package com.springboot.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.Model.Ticket;
import com.springboot.crud.Repo.TicketBookingRepo;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingRepo ticketBookingrepo;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingrepo.save(ticket); //http://localhost:8080
	}

	public Ticket getTicketByID(Integer ticketId) {
		// TODO Auto-generated method stub
		return ticketBookingrepo.findById(ticketId).get();
	}

	public void deleteTicketMethod(Integer ticketId) {
		// TODO Auto-generated method stub
		 ticketBookingrepo.deleteById(ticketId);
	}
	
	public Iterable<Ticket> getAllTicketsList(){
		return ticketBookingrepo.findAll();
	}

	public Ticket updateTicketDetails(Integer id, String newEmail) {
		// TODO Auto-generated method stub
		Ticket t = ticketBookingrepo.findById(id).get();
		t.setEmail(newEmail);
		Ticket updatedTicket = ticketBookingrepo.save(t);
		return updatedTicket;
	}
	
}
