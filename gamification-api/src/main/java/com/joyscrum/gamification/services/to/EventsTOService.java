package com.joyscrum.gamification.services.to;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Event;
import com.joyscrum.gamification.services.crud.interfaces.IAppActionsManager;
import com.joyscrum.gamification.services.crud.interfaces.IAppUsersManager;
import com.joyscrum.gamification.services.to.interfaces.IEventsTOService;
import com.joyscrum.gamification.to.EventTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementation of the event transfert object management interface.
 *
 * @see IEventsTOService
 * @author Alexandre Perusset
 */
@Stateless
public class EventsTOService implements IEventsTOService {

  @EJB
  IAppUsersManager usersManager;

  @EJB
  IAppActionsManager actionTypesManager;

  @Override
  public EventTO buildEventTO(Event event) {
    return new EventTO(
            event.getId().toHexString(),
            event.getUser().getId(),
            event.getActionType().getId().toHexString(),
            event.getTimestamp()
    );
  }

  @Override
  public void updateEventEntity(Event existing, EventTO state, Application application) throws EntityNotFoundException, UnauthorizedException {
    try {
      existing.setUser(usersManager.findById(state.getUserId(), application));
      existing.setActionType(actionTypesManager.findById(state.getActionId(), application));
    } catch (UnauthorizedException e) {
      e.printStackTrace();
      throw e;
    }

    existing.setTimestamp(state.getTimestamp());
    existing.setApplication(application);
  }
}
