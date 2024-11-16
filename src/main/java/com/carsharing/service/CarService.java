package com.carsharing.service;


import com.carsharing.dto.CarRequestDto;
import com.carsharing.dto.CarResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    List<CarResponseDto> findAll(Pageable pageable);

    CarResponseDto findById(Long id);

    CarResponseDto save(CarRequestDto requestDto);

    CarResponseDto update(CarRequestDto requestDto, Long id);

    void deleteById(Long id);
}
