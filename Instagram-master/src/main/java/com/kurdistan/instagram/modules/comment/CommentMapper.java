package com.kurdistan.instagram.modules.comment;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDTO(Comment comments);

    List<Comment> toListComment(List<CommentDTO> commentDTOS);
    List<CommentDTO> toListCommentDTO(List<Comment> commentsList);

}
