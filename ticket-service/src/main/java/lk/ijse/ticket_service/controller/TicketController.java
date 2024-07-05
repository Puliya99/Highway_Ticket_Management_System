package lk.ijse.ticket_service.controller;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.service.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticketService")
public class TicketController {

    @Autowired
    TicketServices ticketServices;

    @GetMapping
    public void checkHealth(){
        System.out.println("Ticket Worked...");
    }

    @PostMapping("/createTicket")
    public String createTicket(@RequestBody TicketDTO ticketDTO){
        String ticket = ticketServices.ticketCreate(ticketDTO);
        return ticket;
    }

    @PutMapping("/updateTicket/{updateTicketId}")
    public String updateTicket(@PathVariable("updateTicketId") String updateTicketId, @RequestBody TicketDTO ticketDTO){
        String ticket = ticketServices.updateTicket(updateTicketId, ticketDTO);
        return ticket;
    }

    @GetMapping("/getTicketDetails/{ticketId}")
    public String getTicketDetails(@PathVariable("ticketId") String ticketId){
        String ticketDetails = ticketServices.getTicketDetails(ticketId);
        return ticketDetails;
    }

    @GetMapping("/ticketHaveCheck/{ticketId}")
    public boolean alreadyTicketHaveCheck(@PathVariable("ticketId") String ticketId){
        boolean b = ticketServices.alreadyTicketHaveCheck(ticketId);
        return b;
    }

    @PostMapping("/statusUpdate/{ticketId}")
    public String ticketStatusUpdate(@PathVariable("ticketId") String ticketId){
        ticketServices.ticketStatusUpdate(ticketId);
        return "done";
    }

    @DeleteMapping("/delete/{ticketId}")
    public String ticketDelete(@PathVariable ("ticketId") String deleteTicketId){
        String resp = ticketServices.deleteTicket(deleteTicketId);
        return resp;
    }

    @GetMapping("/getAllTicket")
    public List<TicketDTO> getAllTickets(){
        List<TicketDTO> allTickets = ticketServices.getAllTicketDetails();
        return allTickets;
    }
}
