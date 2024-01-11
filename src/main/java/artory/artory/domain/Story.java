package artory.artory.domain;

import artory.artory.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Story extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long id;


    private String storyTitle;
    private String storySatisfactionLevel;
    private String storyWeather;
    private String storyCompanion;
    private String storyKeyword;

    @Lob
    private String storyContext;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<ScrapStory> scrapStoryList = new ArrayList<>();;



}