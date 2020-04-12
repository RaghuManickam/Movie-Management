package controllers;

import defaultComponent.DefaultComponent;
import model.MovieModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.MovieService;

import javax.inject.Inject;

public class MovieController extends Controller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Inject
    FormFactory formFactory;
    @Inject
    MessagesApi messagesApi;
    @Inject
    MovieService movieService;

    public Result createMovie(Http.Request request) {
        Form<MovieModel> movieModelForm = this.formFactory.form(MovieModel.class);
        return ok(views.html.movie.addMovie.render(movieModelForm, "Add Movie", null, request, messagesApi.preferred(request)));
    }

    public Result editMovie(Http.Request request, Integer ID) {
        Form<MovieModel> movieModelForm = this.formFactory.form(MovieModel.class).fill(movieService.getMovieByID(ID));
        return ok(views.html.movie.addMovie.render(movieModelForm, "Edit Movie", ID, request, messagesApi.preferred(request)));
    }

    public Result delete(Http.Request request, Integer ID) {
        movieService.deleteByID(ID);
        return redirect(routes.MovieController.listMovie());
    }

    public Result addMovie(Http.Request request, Integer ID) {
        Form<MovieModel> movieModelForm = this.formFactory.form(MovieModel.class).bindFromRequest(request);
        if (movieModelForm.hasErrors()) {
            logger.error("errors = {}", movieModelForm.errors());
            request.flash().adding("failed", "Constraints not satisfied!!!");
            return badRequest(views.html.movie.addMovie.render(movieModelForm, ID == null ? "Add Movie" : "Edit Movie", ID, request, messagesApi.preferred(request)));
        }
        movieModelForm.get().setId(ID);
        this.movieService.addMovie(movieModelForm.get());
        request.flash().adding("success", "Movie Added Successfully");
        return redirect(routes.MovieController.listMovie());
    }

    public Result listMovie(Http.Request request) {
        return ok(views.html.movie.list.render(this.movieService.getAllMovie()));
    }
}
