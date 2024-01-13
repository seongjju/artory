package artory.artory.domain;

import artory.artory.domain.common.BaseEntity;
import artory.artory.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Exhibition extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private Long id;

    private String exhibitionTitle; //제목, 크롤링기준: TITLE
    private String exhibitionImage; //이미지 Url, 크롤링기준: MAIN_IMG
    private String exhibitionAddress; //자치구, 크롤링기준: GUNAME
    private String exhibitionPlace; //장소, 크롤링기준: PLACE
    private String exhibitionDuration; //기간, 크롤링기준: DATE
    private String exhibitionInstitution; //기관명, 크롤링기준: ORG_NAME
    private String exhibitionViewingTime; //관람시간, 유저가 입력

    private String exhibitionViewingAge; //관람연령, 크롤링기준: USE_TRGT
    private String exhibitionPrice; //가격, 크롤링기준: USE_FEE
    private String exhibitionUrl; //전시회 사이트, 크롤링 기준: ORG_LINK
    private String exhibitionLongitude; //경도, 크롤링기준: LOT
    private String exhibitionLatitude; //위도, 크롤링기준: LAT

    //시작날짜,종료날짜가 따로 필요하다면 STRTDATE,END_DATE로 하면됨

    private boolean isEnded = false; //전시회 종료되었는지, 안되었는지


    private int exhibitionLikeCount = 0; // 좋아요 수

    private String genreCategory;

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<Story> storyList = new ArrayList<>();

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<ScrapExhibition> scrapExhibitionList = new ArrayList<>();

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<LikeExhibition> likeExhibitionList = new ArrayList<>();

    @OneToOne(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private ExhibitionGenre exhibitionGenre;


    //가장 높은 3개의 값을 가지는 장르 선택
    public void updateCategory() {
        Map<String, Integer> genreCounts = Map.of(
                "media", exhibitionGenre.getMedia(),
                "craft", exhibitionGenre.getCraft(),
                "design", exhibitionGenre.getDesign(),
                "picture", exhibitionGenre.getPicture(),
                "specialExhibition", exhibitionGenre.getSpecialExhibition(),
                "sculpture", exhibitionGenre.getSculpture(),
                "planExhibition", exhibitionGenre.getPlanExhibition(),
                "installationArt", exhibitionGenre.getInstallationArt(),
                "painting", exhibitionGenre.getPainting(),
                "artistExhibition", exhibitionGenre.getArtistExhibition()
        );

        List<String> topGenres = genreCounts.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        this.genreCategory = String.join(", ", topGenres);
    }

}
