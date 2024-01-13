package artory.artory.domain;


import artory.artory.domain.common.BaseEntity;
import artory.artory.domain.enums.Gender;
import artory.artory.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String memberUserInfo;


    @Column(nullable = false, length = 10)
    private String nickname;


    private String image;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private String age;


    //@Column(nullable = false, length = 40) 필요하면 제한하자, 일단은 이대로

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Genre genre1;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Genre genre2;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Genre genre3;


    //mypage에서 사용
    private String introduction;
    private String myKeyword;

    //mystory에서 사용
    @Lob
    private String memo;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ScrapMember> scrapMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Story> storyList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ScrapStory> scrapStoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ScrapExhibition> scrapExhibitionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<LikeExhibition> likeExhibitionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<LikeStory> likeStoryList = new ArrayList<>();
}
