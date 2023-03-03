package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.GroupMember;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class GroupDto {
    private String name;

    @Getter
    @Setter
    public static class GroupAddFriendDto {

        private List<String> friendUuid;
        private Long groupId;
    }

    @Getter
    @Setter
    public static class ResponseDto {
        private String groupName;
        private Long groupId;
        List<ResponseFriendDto> members;

        public ResponseDto(String groupName, Long groupId, List<ResponseFriendDto> members) {
            this.groupName = groupName;
            this.groupId = groupId;
            this.members = members;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseFriendDto {
        private String name;
        private String uuid;
        private String profileImageUrl;
    }
}
