package com.springboot.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.Model.Ticket;
import com.springboot.crud.service.TicketBookingService;

@RestController
@RequestMapping("/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketService;
	
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicketByID(ticketId);
	}
	
	@GetMapping(value="/getAllTickets")
	public Iterable<Ticket> getAllBookingTickets(){
		return ticketService.getAllTicketsList();
		
	}
	
	@DeleteMapping(value="/deleteticket/{ticketId}")
	public void deleteTicketById(@PathVariable("ticketId") Integer id) {
		 ticketService.deleteTicketMethod(id);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer id, @PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicketDetails(id,newEmail);
	}
}
