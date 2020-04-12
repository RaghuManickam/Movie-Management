package Actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.Materializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.SearchModel;
import model.SearchResult;

import java.util.concurrent.CompletionStage;

public class SearchActor extends AbstractActor {

    private ActorRef guardian;


    public SearchActor(ActorRef guardian) {
        this.guardian = guardian;
    }

    public static Props init(ActorRef actorRef) {
        return Props.create(SearchActor.class, () -> new SearchActor(actorRef));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(JsonNode.class, this::processMessage)
                .build();
    }

    private void processMessage(JsonNode jsonNode) {
        ObjectMapper mapper1 = new ObjectMapper();
        SearchModel searchModel = mapper1.convertValue(jsonNode, SearchModel.class);
        CompletionStage<HttpResponse> responseFuture = this.callRestApi(searchModel.getSearchString(), searchModel.getMovieOrMulti());
        responseFuture.thenCompose(this::consumeHttpResponse)
                .thenAccept(SearchResult -> {
                    System.out.println("DATA : " + SearchResult);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode json = mapper.convertValue(SearchResult, JsonNode.class);
                    this.guardian.tell(json, getSelf());
                });
    }

    private CompletionStage<SearchResult> consumeHttpResponse(HttpResponse httpResponse) {
        Materializer materializer = Materializer.matFromSystem(getContext().getSystem());
        return Jackson.unmarshaller(SearchResult.class)
                .unmarshal(httpResponse.entity(), materializer)
                .thenApply(messageModel -> {
                    this.discardEntity(httpResponse, materializer);
                    return messageModel;
                });
    }

    private void discardEntity(HttpResponse httpResponse, Materializer materializer) {
        httpResponse.discardEntityBytes(materializer)
                .completionStage()
                .whenComplete((done, ex) -> System.out.println("Discarded"));
    }

    private CompletionStage<HttpResponse> callRestApi(String searchString, Integer movieOrMulti) {
        return Http.get(getContext().getSystem()).singleRequest(HttpRequest.create("http://localhost:9000/api/search?searchString=" + searchString + "&movieOrMulti=" + movieOrMulti));
    }
}
