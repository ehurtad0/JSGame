package com.joyscrum.gamification.services.to.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Event;
import com.joyscrum.gamification.to.EventTO;
import javax.ejb.Local;

/**
 * This interface provides methods for converting events to transfert object or
 * update events from transfert object.
 *
 * @author Alexandre Perusset
 */
@Local
public interface IEventsTOService {

  public EventTO buildEventTO(Event event);

  public void updateEventEntity(Event existingEntitiy, EventTO newState, Application application) throws EntityNotFoundException, UnauthorizedException;
}
