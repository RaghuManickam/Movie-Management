package service;

import entity.Multiplex;
import model.MultiplexModel;
import org.modelmapper.ModelMapper;
import repository.MultiplexRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class MultiplexService {
    @Inject
    MultiplexRepository multiplexRepository;
    @Inject
    ModelMapper modelMapper;

    public MultiplexModel getMultiplexModel(Integer id) {
        return modelMapper.map(multiplexRepository.getByID(id), MultiplexModel.class);
    }

    public void deleteByID(Integer id){
        multiplexRepository.deleteByID(id);
    }

    public List<MultiplexModel> getAllMultiplex() {
        return multiplexRepository.list().stream().map(m -> modelMapper.map(m, MultiplexModel.class)).collect(Collectors.toList());
    }

    public MultiplexModel addOrUpdateMultiplex(MultiplexModel multiplexModel) {
        return modelMapper.map(multiplexRepository.insertOrUpdate(modelMapper.map(multiplexModel, Multiplex.class)), MultiplexModel.class);
    }
}
