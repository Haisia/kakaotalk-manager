package com.example.demo.domain.service.group;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.GroupMember;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.repository.GroupMemberRepository;
import com.example.demo.domain.repository.GroupRepository;
import com.example.demo.web.controller.exception.custom.PermissionException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final FriendRepository friendRepository;

    public List<GroupDto.ResponseDto> get (User user) {
        List<Group> groupList = groupRepository.findAllByUserId(user.getId());

        List<GroupDto.ResponseDto> result = new ArrayList<>();
        for (Group group : groupList) {
            List<Friend> friendList = group.getGroupMemberList()
                    .stream()
                    .map(GroupMember::getFriend).toList();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.typeMap(Friend.class, GroupDto.ResponseFriendDto.class)
                    .addMappings(mapper -> {
                        mapper.map(Friend::getNickname, GroupDto.ResponseFriendDto::setName);
                    });

            List<GroupDto.ResponseFriendDto> friendDto = modelMapper.map(friendList, new TypeToken<List<GroupDto.ResponseFriendDto>>() {
            }.getType());

            result.add(new GroupDto.ResponseDto(group.getName(), group.getId(), friendDto));
        }

        return result;
    }

    public Group create (User user, GroupDto dto) {
        return groupRepository.save(new Group(user, dto.getName()));
    }

    public void addMember (GroupDto.GroupAddFriendDto dto, User user) throws Exception {
        Group group = groupRepository.findById(Long.parseLong(dto.getGroupId())).orElseThrow();
        isValid(user, group);

        List<Friend> addFriends = new ArrayList<>();
        dto.getFriendUuid().forEach(uuid -> {
            Friend f = friendRepository.findByUuid(uuid).orElseThrow();
            if (!group.getGroupMemberList().contains(f)) {
                addFriends.add(f);
            }
        });

        addFriends.forEach(friend -> { groupMemberRepository.save(new GroupMember(group, friend)); });
    }

    @Transactional
    public void delete (Long id, User user) throws Exception {
        Group group = groupRepository.findById(id).orElseThrow();
        isValid(user, group);

        groupRepository.delete(group);
    }

    @Transactional
    public void modify (Long id, GroupDto groupDto, User user) throws Exception {
        Group findGroup = groupRepository.findById(id).orElseThrow();
        isValid(user, findGroup);

        findGroup.setName(groupDto.getName());
    }

    /**
     *  isValid : 해당 유저가 그룹의 주인인지 확인하는 메소드
     *
     * @param user
     * @param group
     * @throws Exception user가 group의 주인이 아닐 때 발생
     */
    private void isValid (User user, Group group) throws Exception {
        if (!group.getUser().equals(user)) throw new PermissionException();
    }
}
