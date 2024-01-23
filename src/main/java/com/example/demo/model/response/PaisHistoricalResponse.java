package com.example.demo.model.response;

import com.example.demo.model.Response;
import com.example.demo.model.base.PaisBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PaisHistoricalResponse extends PaisBase implements Response {

    @Serial
    private static final long serialVersionUID = -1636997343537380445L;

    private String id;
    private Long version;
}
