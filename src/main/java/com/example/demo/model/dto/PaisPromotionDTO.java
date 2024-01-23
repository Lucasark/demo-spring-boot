package com.example.demo.model.dto;

import com.example.demo.model.Dto;
import com.example.demo.model.base.PaisBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaisPromotionDTO extends PaisBase implements Dto {

    @Serial
    private static final long serialVersionUID = 3276195328554118289L;

    private String id;
}
