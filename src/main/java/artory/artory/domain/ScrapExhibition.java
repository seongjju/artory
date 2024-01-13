package artory.artory.domain;


import artory.artory.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;




@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ScrapExhibition extends BaseEntity {
//My Story 달력에 필요
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrapExhibition_id")
    private Long id;

    private int year;
    private int month;
    private int day;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;



}