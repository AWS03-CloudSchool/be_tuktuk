package com.example.tuktuk.stadium.controller.dto.responseDto.court;

import com.example.tuktuk.stadium.domain.court.Court;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CourtCreateResponseDto {

    private final String courtName;

    private final String stadiumName;

    private final String courtType;

    private int hourlyRentFee;

    private List<String> images;

    public static CourtCreateResponseDto from(Court court){
        return CourtCreateResponseDto.builder()
                .courtName(court.getName())
                .stadiumName(court.getStadium().getName())
                .courtType(court.getCourtType().name())
                .hourlyRentFee(court.getHourlyRentFee())
                .images(court.getImages())
                .build();
    }
}
