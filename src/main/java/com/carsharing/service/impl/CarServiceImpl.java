package com.carsharing.service.impl;

import com.carsharing.dto.CarRequestDto;
import com.carsharing.dto.CarResponseDto;
import com.carsharing.exception.EntityNotFoundException;
import com.carsharing.mapper.CarMapper;
import com.carsharing.model.Car;
import com.carsharing.repository.CarRepository;
import com.carsharing.service.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarResponseDto> findAll(Pageable pageable) {
        Page<Car> carsPerPage = carRepository.findAll(pageable);
        return carMapper.toListDto(carsPerPage.getContent());
    }

    @Override
    public CarResponseDto findById(Long id) {
        return carMapper.toDto(carRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find a car by id")));
    }

    @Override
    public CarResponseDto save(CarRequestDto requestDto) {
        Car model = carMapper.toModel(requestDto);
        return carMapper.toDto(carRepository.save(model));
    }

    @Override
    @Transactional
    public CarResponseDto update(CarRequestDto requestDto, Long id) {
        Car car = carRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find a car by id"));
        carMapper.updateFromDto(requestDto, car);
        Car updatedCar = carRepository.save(car);
        return carMapper.toDto(updatedCar);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
