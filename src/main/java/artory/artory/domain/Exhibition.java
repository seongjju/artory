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

public class Exhibition extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private Long id;

    private String exhibitionImage;
    private String exhibitionAddress;
    private String exhibitionNumber;
    private String exhibitionHoliday;
    private String exhibitionDuration;
    private String exhibitionTime;
    private String exhibitionViewingTime;
    private String exhibitionViewingAge;
    private String exhibitionPrice;

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<ScrapStory> scrapStoryList = new ArrayList<>();



}
