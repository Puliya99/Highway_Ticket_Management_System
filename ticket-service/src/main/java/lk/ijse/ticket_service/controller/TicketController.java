package lk.ijse.ticket_service.controller;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.service.TicketServices;
import lk.ijse.ticket_service.service.impl.TicketServiceIMPL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/ticketService")
public class TicketController {

    @Autowired
    TicketServices ticketServices;

    Logger logger = LoggerFactory.getLogger(TicketServiceIMPL.class);

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

    @DeleteMapping("/delete/{ticketId}")
    public String ticketDelete(@PathVariable ("ticketId") String deleteTicketId){
        String resp = ticketServices.deleteTicket(deleteTicketId);
        return resp;
    }

    @GetMapping("/getTicketDetails/{ticketId}")
    public String getTicketDetails(@PathVariable("ticketId") String ticketId){
        String ticketDetails = ticketServices.getTicketDetails(ticketId);
        return ticketDetails;
    }

    @GetMapping("/getAllTicket")
    public List<TicketDTO> getAllTickets(){
        List<TicketDTO> allTickets = ticketServices.getAllTicketDetails();
        return allTickets;
    }

    @GetMapping("/ticketHaveCheck/{ticketId}")
    public ResponseEntity<Boolean> alreadyTicketHaveCheck(@PathVariable("ticketId") String ticketId){
        boolean exists = ticketServices.alreadyTicketHaveCheck(ticketId);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/statusUpdate/{ticketId}")
    public ResponseEntity<String> ticketStatusUpdate(@PathVariable("ticketId") String ticketId) {
        try {
            ticketServices.ticketStatusUpdate(ticketId);
            return ResponseEntity.ok("Ticket status updated to PAID");
        } catch (NoSuchElementException e) {
            logger.info("This Id Has No Ticket: " + ticketId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Id Has No Ticket");
        }
    }
}
