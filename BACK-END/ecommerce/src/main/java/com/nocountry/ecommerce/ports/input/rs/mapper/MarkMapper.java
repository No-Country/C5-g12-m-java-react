package com.nocountry.ecommerce.ports.input.rs.mapper;

import java.util.List;

import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.ports.input.rs.request.MarkCreateRequest;
import com.nocountry.ecommerce.ports.input.rs.request.MarkUpdateRequest;
import com.nocountry.ecommerce.ports.input.rs.response.MarkDetails;

import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface MarkMapper {
    Mark CreateMarkToMark(MarkCreateRequest request);
    Mark UpdateMarkToMark(MarkUpdateRequest request);
    MarkDetails MarkToMarkDetails(Mark mark);
    List<MarkDetails> MarkListToMarkDetailList(List<Mark> list);
}
