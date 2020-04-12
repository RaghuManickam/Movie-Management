package controllers;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import service.ScreenService;
import util.ResponseDesigner;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SearchRestController extends Controller {
    @Inject
    private ScreenService screenService;
    @Inject
    private HttpExecutionContext httpExecutionContext;

    public CompletionStage<Result> search(String searchString, Integer movieOrMulti) {
        return supplyAsync(() -> ok(ResponseDesigner.design(this.screenService.getSearchResult(searchString, movieOrMulti), true)), httpExecutionContext.current());
    }
}
