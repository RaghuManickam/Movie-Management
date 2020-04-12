package controllers;

import model.MultiplexModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.MultiplexService;

import javax.inject.Inject;

public class MultiplexController extends Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Inject
    FormFactory formFactory;
    @Inject
    MessagesApi messagesApi;
    @Inject
    MultiplexService multiplexService;

    public Result listMultiplex(Http.Request request) {
        return ok(views.html.multiplex.list.render(this.multiplexService.getAllMultiplex()));
    }

    public Result createMultiplex(Http.Request request) {
        Form<MultiplexModel> multiplexModelForm = this.formFactory.form(MultiplexModel.class);
        return ok(views.html.multiplex.add.render(multiplexModelForm, "Add Multiplex",null, request, messagesApi.preferred(request)));
    }

    public Result editMultiplex(Http.Request request, Integer ID) {
        Form<MultiplexModel> multiplexModelForm = this.formFactory.form(MultiplexModel.class).fill(multiplexService.getMultiplexModel(ID));
        return ok(views.html.multiplex.add.render(multiplexModelForm, "Edit Multiplex",ID, request, messagesApi.preferred(request)));
    }

    public Result delete(Http.Request request, Integer ID) {
        multiplexService.deleteByID(ID);
        return redirect(routes.MultiplexController.listMultiplex());
    }

    public Result addMultiplex(Http.Request request, Integer ID) {
        Form<MultiplexModel> multiplexModelForm = this.formFactory.form(MultiplexModel.class).bindFromRequest(request);
        if (multiplexModelForm.hasErrors()) {
            logger.error("errors = {}", multiplexModelForm.errors());
            request.flash().adding("failed", "Constraints not satisfied!!!");
            return badRequest(views.html.multiplex.add.render(multiplexModelForm, ID == null ? "Add Multiplex" : "Edit Multiplex",ID, request, messagesApi.preferred(request)));
        }
        multiplexModelForm.get().setId(ID);
        this.multiplexService.addOrUpdateMultiplex(multiplexModelForm.get());
        request.flash().adding("success", "Movie Added Successfully");
        return redirect(routes.MultiplexController.listMultiplex());
    }
}
