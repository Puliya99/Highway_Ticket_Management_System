package lk.ijse.ticket_service.convert;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataConvert {

    private final ModelMapper modelMapper;


    public TicketDTO ticketEntityConvertTicketDTO(TicketEntity ticketEntity){
        return modelMapper.map(ticketEntity, TicketDTO.class);
    }

    public TicketEntity ticketDTOConvertTicketEntity(TicketDTO ticketDTO){
        return modelMapper.map(ticketDTO, TicketEntity.class);
    }

    public List<TicketDTO> ticketsEntityListConvertticketDTOList(List<TicketEntity> TicketEntityList){
        return modelMapper.map(TicketEntityList, List.class);
    }
}
