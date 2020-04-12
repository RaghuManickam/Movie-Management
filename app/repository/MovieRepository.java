package repository;

import entity.Movie;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

@Singleton
@Transactional
public class MovieRepository {
    @Inject
    private JPAApi jpaApi;

    // wrap this.jpaApi.withTransaction : to make it reusable
    private <T> T wrap(Function<EntityManager, T> function) {
        return this.jpaApi.withTransaction(function);
    }

    public Movie insertOrUpdate(Movie movie) {
        movie.setDeleted(false);
        return this.wrap(eM -> {
            if (movie.getId() == null) {
                eM.persist(movie);
            } else {
                eM.merge(movie);
            }
            return movie;
        });
    }

    public List<Movie> list() {
        return this.wrap(entityManager -> entityManager.createQuery("select m from Movie m where m.isDeleted=false ", Movie.class).getResultList());
    }

    public List<Movie> getNotAllottedMovie(Integer MovieID) {
        return this.wrap(entityManager -> entityManager.createQuery("select m from Movie m where m.id!=:MovieID and m.isDeleted=false", Movie.class).setParameter("MovieID", MovieID).getResultList());
    }

    public void delete(Integer id) {
        this.wrap(entityManager ->
                entityManager.createQuery("update Movie m set m.isDeleted=true where m.id=" + id).executeUpdate()
        );
    }

    public Movie getByID(Integer id) {
        return this.wrap(entityManager -> entityManager.createQuery("select m from Movie m where m.id=" + id + " and m.isDeleted=false", Movie.class).getSingleResult());
    }
}
