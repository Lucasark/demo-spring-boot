package com.example.demo.model.request;

import com.example.demo.model.Request;
import com.example.demo.model.base.PaisBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class PaisHistoricalRequest extends PaisBase implements Request {

    @Serial
    private static final long serialVersionUID = 5366840091524394937L;
}
