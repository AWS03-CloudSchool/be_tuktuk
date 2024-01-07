package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadium")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64)")
    private String name;

    @Column(name = "owner",nullable = false)
    private long owner;

    @Embedded
    private Location location;

    @Column(name = "specific_info", nullable = false, columnDefinition = "text")
    private String specificInfo; //주차 여부, 찾아 오는 상세한 길 같은 구단 등록주가 상세히 입력하는 폼.

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Court> courts;

    /**
     * stadium court에서 연관관계의 주인은 court.
     * court에서 stadium을 외래키 참조한다.
     * stadium이 삭제되면, 이와 연관된 court도 삭제되어야 한다. cascade 옵션 모두 사용
     */
}
