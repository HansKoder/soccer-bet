package com.hans.bet.soccer_service.match.presentation.rest.mapper;

import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.presentation.rest.dto.response.GetMatchResponse;

public class MatchRestMapper {

    public static GetMatchResponse toResponse (Match domain) {
        return new GetMatchResponse(
                domain.getId().getValue().toString(),
                domain.getLocal().name(),
                domain.getVisiting().name(),
                domain.getTournament(),
                domain.getStatusMatch().name()
                );
    }

}
