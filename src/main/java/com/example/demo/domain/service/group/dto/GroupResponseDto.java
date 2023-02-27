package com.example.demo.domain.service.group.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupResponseDto {
    private String groupName;
    private String groupId;
    List<GroupResponseFriendDto> members;
}
