package com.gamboatech.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class Movement {
    private Long id;
    private Long accountId;
    private LocalDateTime date;
    private String type;
    private Long value;
    private Long newBalance;
}
