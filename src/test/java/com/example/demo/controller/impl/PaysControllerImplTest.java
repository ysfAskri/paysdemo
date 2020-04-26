package com.example.demo.controller.impl;

import com.example.demo.builder.PaysBuilder;
import com.example.demo.mapper.PaysMapper;
import com.example.demo.mapper.ReferenceMapper;
import com.example.demo.model.Pays;
import com.example.demo.service.PaysService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.util.Utils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class PaysControllerImplTest {
    private static final String ENDPOINT_URL = "/pays";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private PaysControllerImpl paysController;
    @MockBean
    private PaysService paysService;
    @MockBean
    private PaysMapper paysMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.paysController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(paysMapper.asDTOList(any())).thenReturn(PaysBuilder.getListDTO());

        Mockito.when(paysService.findAll()).thenReturn(PaysBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(paysMapper.asDTO(any())).thenReturn(PaysBuilder.getDTO());

        Mockito.when(paysService.findById(anyString())).thenReturn(java.util.Optional.of(PaysBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is("1")));
        Mockito.verify(paysService, times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(paysService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(paysMapper.asEntity(any())).thenReturn(PaysBuilder.getEntity());
        Mockito.when(paysService.save(any(Pays.class))).thenReturn(PaysBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(PaysBuilder.getDTO())))
                .andExpect(status().isCreated());
        Mockito.verify(paysService, times(1)).save(any(Pays.class));
        Mockito.verifyNoMoreInteractions(paysService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(paysMapper.asEntity(any())).thenReturn(PaysBuilder.getEntity());
        Mockito.when(paysService.update(any(), anyString())).thenReturn(PaysBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(PaysBuilder.getDTO())))
                .andExpect(status().isOk());
        Mockito.verify(paysService, times(1)).update(any(Pays.class), anyString());
        Mockito.verifyNoMoreInteractions(paysService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(paysService).deleteById(anyString());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(status().isOk());
        Mockito.verify(paysService, times(1)).deleteById(anyString());
        Mockito.verifyNoMoreInteractions(paysService);
    }
}
