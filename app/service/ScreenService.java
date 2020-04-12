package service;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Screen;
import model.MovieModel;
import model.ScreenModel;
import org.modelmapper.ModelMapper;
import repository.ScreenRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ScreenService {
    @Inject
    ModelMapper modelMapper;
    @Inject
    ScreenRepository screenRepository;

    public ScreenModel getScreenByMultiplexAndScreenNumber(Integer multiplexID, Integer screenNumber) {
        Screen screen = screenRepository.getScreenByMultiplexAndScreenNumber(multiplexID, screenNumber);
        if (screen == null) {
            return null;
        } else {
            return modelMapper.map(screen, ScreenModel.class);
        }

    }

    public void addScreen(ScreenModel screen) {
        screenRepository.add(modelMapper.map(screen, Screen.class));
    }

    public void delete(Integer movieID, Integer multiplexID, Integer screenNumber) {
        screenRepository.delete(movieID, multiplexID, screenNumber);
    }

    public JsonNode getSearchResult(String searchString, int movieOrMulti) {
        return screenRepository.find(searchString, movieOrMulti);
    }
}
