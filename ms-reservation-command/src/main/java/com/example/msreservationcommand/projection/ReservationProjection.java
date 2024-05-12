package com.example.msreservationcommand.projection;

import com.example.coreapi.events.ReservationAddedEvent;
import com.example.coreapi.events.ReservationRemovedEvent;
import com.example.msreservationcommand.Aggregate.ReservationAggregate;
import com.example.msreservationcommand.repository.ReservationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationProjection {

    @Autowired
    ReservationRepository reservationRepository;

    @EventHandler
    public void AddReservation(ReservationAddedEvent event){
        reservationRepository.save(new ReservationAggregate(event.getIdRes(),event.getDateDebut(),event.getDateFin(),
                                                            event.getIdCh()));
    }

    @EventHandler
    public void DeleteReservation(ReservationRemovedEvent event){
        reservationRepository.deleteById(event.getIdRes());
    }
}
