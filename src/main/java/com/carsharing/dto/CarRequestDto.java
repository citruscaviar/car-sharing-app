package com.carsharing.dto;

import com.carsharing.model.Car;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CarRequestDto {
    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @NotNull
    private Car.CarType carType;
    @Positive
    private int inventory;
    @Positive
    private BigDecimal dailyFee;
}
