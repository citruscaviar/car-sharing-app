package com.carsharing.mapper;

import com.carsharing.config.MapperConfig;
import com.carsharing.dto.CarRequestDto;
import com.carsharing.dto.CarResponseDto;
import com.carsharing.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CarMapper {
    CarResponseDto toDto(Car car);
    Car toModel(CarRequestDto requestDto);
    List<CarResponseDto> toListDto(List<Car> cars);

    void updateFromDto(CarRequestDto requestDto, @MappingTarget Car car);
}
