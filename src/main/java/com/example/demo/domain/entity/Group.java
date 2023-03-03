package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static org.hibernate.annotations.CascadeType.*;

@Data
@Entity
@Table(name = "CUSTOM_GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;

    @Column(name = "GROUP_NAME")
    private String name;

    @OneToMany(mappedBy = "group")
    @Cascade(ALL)
    private List<GroupMember> groupMemberList;

    protected Group() {}

    public Group(User user, String name) {
        this.user = user;
        this.name = name;
    }
}
