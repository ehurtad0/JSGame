package com.joyscrum.gamification.services.exposed;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Rule;
import com.joyscrum.gamification.services.crud.interfaces.IApplicationsManager;
import com.joyscrum.gamification.services.crud.interfaces.IRulesManager;
import com.joyscrum.gamification.services.exposed.interfaces.IRulesResource;
import com.joyscrum.gamification.services.to.interfaces.IRulesTOService;
import com.joyscrum.gamification.to.RuleTO;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST and Remote Service. Expose some services to manage the rules of the
 * application. A rule is defined for a specific action and is used by one or
 * more success to detect when they can be given to the users. The rule is
 * completed when the total points of a user for an action is equals to the goal
 * points of the rule.
 *
 * @author Gaël Jobin
 */
@Stateless
@Path("rules")
public class RulesResource implements IRulesResource {

  @Context
  private UriInfo context;

  @EJB
  private IRulesManager rulesManager;

  @EJB
  private IRulesTOService rulesTOService;

  @EJB
  private IApplicationsManager appManager;

  /**
   * Creates a new instance of RulesResource
   */
  public RulesResource() {
  }

  /**
   * Creates a new Rule resource from the provided representation in the current
   * application.
   *
   * @param ruleTO the representation of the new rule
   * @param idApp id of the application
   * @return Response HTTP Code 201 Created
   * @throws EntityNotFoundException application does not exists
   * @throws UnauthorizedException rule action does not belong to application
   */
  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Override
  public Response restCreateRule(RuleTO ruleTO, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
    return Response.created(
            context.getAbsolutePathBuilder().path( createRule(ruleTO, idApp)
                    ).build()
    ).build();
  }

  @Override
  public String createRule(RuleTO ruleTO, String idApp) throws EntityNotFoundException, UnauthorizedException {
    Rule newRule = new Rule();
    rulesTOService.updateRuleEntity(newRule, ruleTO, appManager.findById(idApp));
    return rulesManager.create(newRule);
  }

  /**
   * Retrieves a representation of a list of Rule resources.
   *
   * @param idApp id of the application
   * @return List<RuleTO> an list of RuleTO
   * @throws EntityNotFoundException if application does not exists
   */
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  @Override
  public List<RuleTO> getAllRules(@HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException {
    List<RuleTO> result = new LinkedList<>();
    for (Rule rule : rulesManager.findAll(appManager.findById(idApp))) {
      result.add(rulesTOService.buildPublicRuleTO(rule));
    }
    return result;
  }

  /**
   * Retrieves representation of a Rule resource.
   *
   * @param id unique id of the rule
   * @param idApp id of the application
   * @return an instance of RuleTO
   * @throws EntityNotFoundException rule or application does not exists
   * @throws UnauthorizedException rule does not belong to current application
   */
  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  @Override
  public RuleTO getRule(@PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
    return rulesTOService.buildPublicRuleTO(rulesManager.findById(id, appManager.findById(idApp)));
  }

  /**
   * Updates an Rule resource by passing his new representation.
   *
   * @param ruleTO the new representation of the rule
   * @param id id of the rule to update
   * @param idApp id of the application
   * @return Response HTTP Code 204 No Content
   * @throws EntityNotFoundException rule or application does not exists
   * @throws UnauthorizedException rule does not belong to current application
   */
  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  @Override
  public Response restUpdateRule(RuleTO ruleTO, @PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
    updateRule(ruleTO, id, idApp);
    return Response.noContent().build();
  }

  @Override
  public void updateRule(RuleTO ruleTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException {
    Application app = appManager.findById(idApp);
    Rule ruleToUpdate = rulesManager.findById(id, app);
    rulesTOService.updateRuleEntity(ruleToUpdate, ruleTO, app);
    rulesManager.update(ruleToUpdate, app);
  }

  /**
   * Deletes a Rule resource by passing his unique id.
   *
   * @param id the unique id of the rule to delete
   * @param idApp id of the application
   * @return Response HTTP Code 204 No Content
   * @throws EntityNotFoundException rule or application does not exists
   * @throws UnauthorizedException rule does not belong to current application
   */
  @DELETE
  @Path("{id}")
  @Override
  public Response restDeleteRule(@PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
    deleteRule(id, idApp);
    return Response.noContent().build();
  }

  @Override
  public void deleteRule(String id, String idApp) throws EntityNotFoundException, UnauthorizedException {
    rulesManager.delete(id, appManager.findById(idApp));
  }
}
