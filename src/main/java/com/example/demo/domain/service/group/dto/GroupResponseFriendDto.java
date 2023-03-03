package com.example.demo.domain.service.group.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupResponseFriendDto {
    private String name;
    private String uuid;
    private String profileImageUrl;
}
