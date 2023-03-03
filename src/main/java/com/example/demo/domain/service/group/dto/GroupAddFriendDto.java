package com.example.demo.domain.service.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupAddFriendDto {

    private List<String> friendUuid;
    private String groupId;
}
