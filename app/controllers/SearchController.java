package controllers;

import Actor.SearchActor;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.F;
import play.libs.streams.ActorFlow;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.WebSocket;

import javax.inject.Inject;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Results.ok;

public class SearchController {
    @Inject
    private ActorSystem actorSystem;
    @Inject
    private Materializer materializer;

    public WebSocket socket() {
        return WebSocket.Json.acceptOrResult(this::createActorFlow);
    }

    private CompletionStage<F.Either<Result, Flow<JsonNode, JsonNode, ?>>> createActorFlow(Http.RequestHeader header) {
        return CompletableFuture.completedFuture(F.Either.Right(createFlowForActor()));
    }

    private Flow<JsonNode, JsonNode, ?> createFlowForActor() {
        return ActorFlow.actorRef(SearchActor::init, this.actorSystem, this.materializer);
    }

}
