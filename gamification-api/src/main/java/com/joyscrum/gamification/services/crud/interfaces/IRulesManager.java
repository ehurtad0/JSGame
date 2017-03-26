package com.joyscrum.gamification.services.crud.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;
import com.joyscrum.model.Rule;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get rules. It is
 * also possible de get all rules linked to a given action.
 *
 * @author Gaël Jobin
 */
@Local
public interface IRulesManager {

   String create(Rule employeeData);

   void update(Rule newState, Application application) throws EntityNotFoundException, UnauthorizedException;

   void delete(String id, Application applicaiton) throws EntityNotFoundException, UnauthorizedException;

   Rule findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException;

   List<Rule> findAll(Application application);

   List<Rule> findAllForAction(AppAction action);

   void checkRights(Rule rule, Application app) throws UnauthorizedException;
}
