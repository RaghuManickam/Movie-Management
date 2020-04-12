package service;

import entity.Movie;
import model.MovieModel;
import org.modelmapper.ModelMapper;
import repository.MovieRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class MovieService {
    @Inject
    MovieRepository movieRepository;
    @Inject
    ModelMapper modelMapper;

    public MovieModel addMovie(MovieModel movieModel) {
        return modelMapper.map(movieRepository.insertOrUpdate(modelMapper.map(movieModel, Movie.class)), MovieModel.class);
    }

    public List<MovieModel> getAllMovie() {
        return movieRepository.list().stream().map(m -> modelMapper.map(m, MovieModel.class)).collect(Collectors.toList());
    }

    public List<MovieModel> getNotAllottedMovie(Integer MovieID) {
        return movieRepository.getNotAllottedMovie(MovieID).stream().map(m -> modelMapper.map(m, MovieModel.class)).collect(Collectors.toList());
    }

    public void deleteByID(Integer id) {
        movieRepository.delete(id);
    }

    public MovieModel getMovieByID(Integer id) {
        return modelMapper.map(movieRepository.getByID(id), MovieModel.class);
    }
}
