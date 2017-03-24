package ch.heigvd.gamification.services.to;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Event;
import ch.heigvd.gamification.services.crud.interfaces.IAppActionsManager;
import ch.heigvd.gamification.services.crud.interfaces.IAppUsersManager;
import ch.heigvd.gamification.services.to.interfaces.IEventsTOService;
import ch.heigvd.gamification.to.EventTO;

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
