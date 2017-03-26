package com.joyscrum.gamification.services.exposed.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.gamification.to.EventTO;
import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * Interface for events management. The methods inside can be called remotly or
 * with jax-rs rest api. It is not possible to update an existing event.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface IEventsResource {

  public String createEvent(EventTO newEventTO, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public EventTO getEvent(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<EventTO> getEvents(String idApp) throws EntityNotFoundException;

  public Response restCreateEvent(EventTO newEventTO, String idApp) throws EntityNotFoundException, UnauthorizedException;
}
