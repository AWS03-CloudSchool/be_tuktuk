package com.example.tuktuk.domain.global;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Money {

    @Column(name = "value")
    private int value;

    public Money(int value) {
        this.value = value;
    }
}
