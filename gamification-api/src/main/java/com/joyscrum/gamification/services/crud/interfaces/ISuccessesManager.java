package com.joyscrum.gamification.services.crud.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Success;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get successes.
 *
 * @author Alexandre Perusset
 */
@Local
public interface ISuccessesManager {

   String create(Success successData);

   void update(Success newState, Application app) throws EntityNotFoundException, UnauthorizedException;

   void delete(String id, Application app) throws EntityNotFoundException, UnauthorizedException;

   Success findById(String id, Application app) throws EntityNotFoundException, UnauthorizedException;

   List<Success> findAll(Application app);

   void checkRights(Success success, Application app) throws UnauthorizedException;
}
