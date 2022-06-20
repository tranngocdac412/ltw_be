package com.example.btlltw.mapper;

import com.example.btlltw.dto.CreateCarDto;
import com.example.btlltw.entity.Car;
import org.modelmapper.ModelMapper;

public class CarMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static CreateCarDto convertToDTO(Car car){
        return modelMapper.map(car, CreateCarDto.class);
    }

    public static Car convertToEntity(CreateCarDto createCarDto){
        return modelMapper.map(createCarDto, Car.class);
    }

//    public static Page<PostDto> convertToDTOs(Page<Post> posts){
//        return posts.map(PostMapper::convertToDTO);
//    }
}
