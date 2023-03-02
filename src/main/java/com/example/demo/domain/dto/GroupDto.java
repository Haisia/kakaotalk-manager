package com.example.demo.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class GroupDto {
    private String name;

    @Getter
    @Setter
    public static class GroupAddFriendDto {

        private List<String> friendUuid;
        private String groupId;
    }

    @Getter
    @Setter
    public static class ResponseDto {
        private String groupName;
        private String groupId;
        List<ResponseFriendDto> members;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ResponseFriendDto {
        private String name;
        private String uuid;
        private String profileImageUrl;
    }
}
