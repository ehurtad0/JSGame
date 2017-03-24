package com.joyscrum.gamification.services.exposed;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;
import com.joyscrum.gamification.services.crud.interfaces.IAppActionsManager;
import com.joyscrum.gamification.services.crud.interfaces.IApplicationsManager;
import com.joyscrum.gamification.services.exposed.interfaces.IAppActionsResource;
import com.joyscrum.gamification.services.to.interfaces.IAppActionsTOService;
import com.joyscrum.gamification.to.AppActionTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

/**
 * REST and Remote Service. Expose some service to manage application actions.
 *
 * @author Gaël Jobin
 */
@Stateless
@Path("actions")
public class AppActionsResource implements IAppActionsResource {

    @Context
    private UriInfo context;

    @EJB
    private IAppActionsManager actionManager;

    @EJB
    private IAppActionsTOService actionTOService;

    @EJB
    private IApplicationsManager appManager;

    /**
     * Creates a new instance of AppActionResource
     */
    public AppActionsResource() {
    }

    /**
     * Create a new AppAction resource from the provided representation. This
     * method is used by jax-rs when th api user call the api via rest/jax-rs.
     *
     * @param actionTO the new action representation
     * @param idApp    id of the application
     * @return Response HTTP Code 201 Created
     * @throws EntityNotFoundException if application does not exists
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public Response restCreateAction(AppActionTO actionTO, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException {
        return Response.created(
                context.getAbsolutePathBuilder().path(
                        createAction(actionTO, idApp)
                ).build()
        ).build();
    }

    /**
     * Create a new AppAction resource from the provided representation. This
     * method
     *
     * @param actionTO the new action representation
     * @param idApp    id of the application
     * @return id of the new action
     * @throws EntityNotFoundException if application does not exists
     */
    @Override
    public String createAction(AppActionTO actionTO, String idApp) throws EntityNotFoundException {
        AppAction action = new AppAction();
        actionTOService.updateActionTypeEntity(action, actionTO, appManager.findById(idApp));
        return actionManager.create(action);
    }

    /**
     * Retrieves a representation of a list of AppActionTO resources.
     *
     * @param idApp id of the application
     * @return List<AppActionTO> a list of AppActionTO
     * @throws EntityNotFoundException application does not exists
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public List<AppActionTO> getActions(@HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException {
        List<AppActionTO> result = new LinkedList<>();
        for (AppAction action : actionManager.findAll(appManager.findById(idApp))) {
            result.add(actionTOService.buildPublicActionTypeTO(action));
        }
        return result;
    }

    /**
     * Retrieves representation of an action resource.
     *
     * @param id    id of the action
     * @param idApp id of the application
     * @return AppActionTO an instance of AppActionTO
     * @throws EntityNotFoundException action does not exists
     * @throws UnauthorizedException   action does not belong to application
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public AppActionTO getAction(@PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
        return actionTOService.buildPublicActionTypeTO(actionManager.findById(id, appManager.findById(idApp)));
    }

    /**
     * Updates an action resource by passing his new representation.
     *
     * @param actionTO the new representation of the action
     * @param id       id of the action to update
     * @param idApp    id of the application
     * @return Response HTTP Code 204 No Content
     * @throws EntityNotFoundException if action or application does not exists
     * @throws UnauthorizedException   action does not belong to application
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public Response restUpdateAction(AppActionTO actionTO, @PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
        updateAction(actionTO, id, idApp);
        return Response.noContent().build();
    }

    @Override
    public void updateAction(AppActionTO actionTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException {
        Application app = appManager.findById(idApp);
        AppAction action = actionManager.findById(id, app);
        actionTOService.updateActionTypeEntity(action, actionTO, app);
        actionManager.update(action, app);
    }

    /**
     * Deletes an actions resource.
     *
     * @param id    the if of the action to delete
     * @param idApp id of the application
     * @return Response HTTP Code 204 No Content
     * @throws EntityNotFoundException if the action does not exists
     * @throws UnauthorizedException   action does not belong application
     */
    @DELETE
    @Path("{id}")
    @Override
    public Response restDeleteAction(@PathParam("id") String id, @HeaderParam(value = RESTAPI.APP) String idApp) throws EntityNotFoundException, UnauthorizedException {
        deleteAction(id, idApp);
        return Response.noContent().build();
    }

    @Override
    public void deleteAction(String id, String idApp) throws EntityNotFoundException, UnauthorizedException {
        actionManager.delete(id, appManager.findById(idApp));
    }
}
