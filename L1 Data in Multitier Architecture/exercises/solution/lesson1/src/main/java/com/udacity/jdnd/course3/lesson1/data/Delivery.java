package com.udacity.jdnd.course3.lesson1.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.type.YesNoConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {
    @Id
    private Long id;

    @Nationalized
    private String name;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime;
    @Convert(converter = YesNoConverter.class)
    private Boolean completed;

    //make sure to specify mappedBy. Lazy fetch optional,
    // but often a good idea for collection attributes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Plant> plants;

    /* getters and setters */
}
