package artory.artory.domain;

import artory.artory.domain.common.BaseEntity;

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

public class ExhibitionGenre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibitionGenre_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;




    private int media = 0;
    private int craft = 0;
    private int design = 0;
    private int picture = 0;
    private int specialExhibition = 0;
    private int sculpture = 0;
    private int planExhibition = 0;
    private int installationArt = 0;
    private int painting = 0;
    private int artistExhibition = 0;

    // 각 장르의 카운트를 증가시키는 메서드
    public void increaseMediaCount() {
        this.media++;
    }

    public void increaseCraftCount() {
        this.craft++;
    }

    public void increaseDesignCount() {
        this.design++;
    }

    public void increasePictureCount() {
        this.picture++;
    }

    public void increaseSculptureCount() {
        this.sculpture++;
    }

    public void increasePlanExhibitionCount() {
        this.planExhibition++;
    }

    public void increaseSpecialExhibitionCount() {
        this.specialExhibition++;
    }

    public void increaseInstallationArtCount() {
        this.installationArt++;
    }

    public void increasePaintingCount() {
        this.painting++;
    }

    public void increaseArtistExhibitionCount() {
        this.artistExhibition++;
    }



}
