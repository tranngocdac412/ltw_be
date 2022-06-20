package com.example.btlltw.mapper;

import com.example.btlltw.dto.CreateTourDto;
import com.example.btlltw.entity.Tour;
import org.modelmapper.ModelMapper;

public class TourMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static Tour convertToEntity(CreateTourDto createTourDto){
        return modelMapper.map(createTourDto, Tour.class);
    }
}
