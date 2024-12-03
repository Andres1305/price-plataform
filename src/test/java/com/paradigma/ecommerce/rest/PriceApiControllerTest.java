package com.paradigma.ecommerce.rest;

import com.paradigma.ecommerce.application.port.incoming.PriceService;
import com.paradigma.ecommerce.domain.model.entities.Price;
import com.paradigma.ecommerce.interfaces.mappers.PriceMapperImpl;
import com.paradigma.ecommerce.interfaces.rest.PriceApiController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = PriceApiController.class)
@Import({ PriceMapperImpl.class})
class PriceApiControllerTest {


    public static final LocalDateTime NOW = LocalDateTime.now();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    Price price = Price.builder()
            .id(1L)
            .startDate(NOW)
            .endDate(LocalDateTime.now())
            .brandId(1)
            .priority(1)
            .productId(1)
            .currency("EN")
            .build();

    @Test
    void should_return_list_of_prices() throws  Exception{
        //given
        //when
        when(priceService.get(any(),any(),any()))
                .thenReturn(List.of(price));

        mockMvc.perform(get("/price?apply_date=2020-06-14-00.00.00&product_id=1&brand_id=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].product_id").value("1"))
                .andExpect(jsonPath("$[0].brand_id").value("1"));
        //then
        verify(priceService).get("2020-06-14-00.00.00",1,1);
        verifyNoMoreInteractions(priceService);

    }

}