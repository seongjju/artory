package artory.artory.domain;

import artory.artory.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Builder

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class LikeStory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeStory_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;



}