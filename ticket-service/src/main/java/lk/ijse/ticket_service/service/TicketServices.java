package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;

import java.util.List;

public interface TicketServices {
    String ticketCreate(TicketDTO ticketDTO);
    String updateTicket(String updateTicketId ,TicketDTO ticketDTO);
    String getTicketDetails(String ticketId);
    boolean alreadyTicketHaveCheck(String ticketId);
    void ticketStatusUpdate(String ticketId);
    String deleteTicket(String deleteTicketId);
    List<TicketDTO> getAllTicketDetails();
}
