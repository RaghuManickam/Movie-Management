package service;

import entity.Screen;
import model.ScreenModel;
import model.SearchItem;
import org.modelmapper.ModelMapper;
import repository.MovieRepository;
import repository.MultiplexRepository;
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
    @Inject
    MovieRepository movieRepository;
    @Inject
    MultiplexRepository multiplexRepository;

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

    public List<SearchItem> getSearchResult(String searchString, int movieOrMulti) {
        if (movieOrMulti == 1) {
            return movieRepository.find(searchString).stream().map(m -> modelMapper.map(m, SearchItem.class)).collect(Collectors.toList());
        } else {
            return multiplexRepository.find(searchString).stream().map(m -> modelMapper.map(m, SearchItem.class)).collect(Collectors.toList());
        }
    }
}
