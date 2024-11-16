package com.carsharing.controller;

import com.carsharing.dto.CarRequestDto;
import com.carsharing.dto.CarResponseDto;
import com.carsharing.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cars Endpoint", description = "Endpoint for car management")
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Validated
public class CarController {
    private final CarService carService;

    //TODO: @Operation for other controllers
    @GetMapping
    @Operation(description = "Gets all cars, paged")
    public List<CarResponseDto> getAll(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CarResponseDto getById(@PathVariable @Positive Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarResponseDto save(@RequestBody @Valid CarRequestDto requestDto) {
        return carService.save(requestDto);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@RequestBody @Valid CarRequestDto requestDto, @PathVariable @Positive Long id) {
        return carService.update(requestDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(Long id) {
        carService.deleteById(id);
    }
}
