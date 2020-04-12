package repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Movie;
import entity.Multiplex;
import entity.Screen;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.function.Function;

@Singleton
@Transactional
public class ScreenRepository {
    @Inject
    private JPAApi jpaApi;

    // wrap this.jpaApi.withTransaction : to make it reusable
    private <T> T wrap(Function<EntityManager, T> function) {
        return this.jpaApi.withTransaction(function);
    }

    public Screen getScreenByMultiplexAndScreenNumber(Integer multiplexID, Integer screenNumber) {
        Screen screen = null;
        try {
            screen = this.wrap(entityManager -> entityManager.createQuery("select s from Screen s where s.multiplex.id=:multiplexID and s.ScreenNumber=:screenNumber and s.isDeleted=false", Screen.class)
                    .setParameter("multiplexID", multiplexID).setParameter("screenNumber", screenNumber).getSingleResult());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return screen;
    }

    public void delete(Integer movieID, Integer multiplexID, Integer screenNumber) {
        this.wrap(entityManager ->
                entityManager.createQuery("Delete from Screen s where s.movie.id=:movieID and s.multiplex.id=:multiplexID and s.ScreenNumber=:screenNumber")
                        .setParameter("movieID", movieID)
                        .setParameter("multiplexID", multiplexID)
                        .setParameter("screenNumber", screenNumber)
                        .executeUpdate()
        );
    }

    public Screen add(Screen screen) {
        return this.wrap(eM -> {
            if (screen.getId() == null) {
                eM.persist(screen);
            } else {
                eM.merge(screen);
            }
            return screen;
        });
    }

    public JsonNode find(String searchString, int movieOrMulti) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseObject;
        if (movieOrMulti == 1) {
            responseObject = mapper.convertValue(this.wrap(entityManager -> entityManager.createQuery("select s from Movie s where lower(s.movieName) like lower(:searchString) and s.isDeleted=false", Movie.class)
                    .setParameter("searchString", "%" + searchString + "%").getResultList()), JsonNode.class);
        } else {
            responseObject = mapper.convertValue(this.wrap(entityManager -> entityManager.createQuery("select s from Multiplex s where lower(s.name) like lower(:searchString) and s.isDeleted=false", Multiplex.class)
                    .setParameter("searchString", "%" + searchString + "%").getResultList()), JsonNode.class);
        }
        return responseObject;
    }
}
