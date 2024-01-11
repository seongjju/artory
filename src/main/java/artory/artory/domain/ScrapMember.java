package artory.artory.domain;


import artory.artory.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ScrapMember extends BaseEntity {
//저장스토리 이름을 어차피 책갈피(=스크랩)이니까 스크랩 스토리

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrap_id")
    private Long id;

    // 유저 즐겨찾기 여부를 나타내는 필드 추가
    @Column(name = "is_favorite")
    private boolean favorite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_member_id")
    private Member sourceMember;  // 즐겨찾기를 하는 멤버

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_member_id")
    private Member targetMember;  // 즐겨찾기를 받는 멤버


}