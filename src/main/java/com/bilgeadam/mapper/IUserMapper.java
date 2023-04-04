package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    User toUser(final UserRegisterRequestDto dto);
//    User toUser(final UserRegisterRequestDto dto);
    LoginResponseDto toUserLoginResponseDto(final User user);
    MovieComment toMovieComment(final MovieCommentCreateRequestDto dto);

}
