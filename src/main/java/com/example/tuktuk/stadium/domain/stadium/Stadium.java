package com.example.tuktuk.stadium.domain.stadium;

import com.example.tuktuk.stadium.domain.Location;
import com.example.tuktuk.stadium.domain.court.Court;
import com.example.tuktuk.user.domain.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadium")
public class Stadium {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    private UserId ownerId;

    @Embedded
    private Location location;

    @Comment("This column is stadium officials wrote about the stadium in detail")
    @Column(name = "specific_info", nullable = false, columnDefinition = "text")
    private String specificInfo;

    @ElementCollection
    @CollectionTable(name = "stadium_images",joinColumns = @JoinColumn(name = "stadium_id"))
    @Column(name = "image_path")
    private final List<String> images = new ArrayList<>();

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL)
    private final List<Court> courts = new ArrayList<>();
}
