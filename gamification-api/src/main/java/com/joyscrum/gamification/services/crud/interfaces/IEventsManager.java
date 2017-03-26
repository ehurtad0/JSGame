package com.joyscrum.gamification.services.crud.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Event;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get events.
 *
 * @author Alexandre Perusset
 */
@Local
public interface IEventsManager {

   String create(Event eventData) throws EntityNotFoundException, UnauthorizedException;

   void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException;

   Event findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException;

   List<Event> findAll(Application application);

   void checkRights(Event event, Application app) throws UnauthorizedException;
}
