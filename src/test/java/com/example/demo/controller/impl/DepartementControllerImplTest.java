package com.example.demo.controller.impl;


import com.example.demo.builder.DepartementBuilder;
import com.example.demo.mapper.DepartementMapper;
import com.example.demo.mapper.ReferenceMapper;
import com.example.demo.model.Departement;
import com.example.demo.service.DepartementService;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DepartementControllerImplTest {
    private static final String ENDPOINT_URL = "/departements";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private DepartementControllerImpl departementController;
    @MockBean
    private DepartementService departementService;
    @MockBean
    private DepartementMapper departementMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.departementController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(departementMapper.asDTOList(any())).thenReturn(DepartementBuilder.getListDTO());

        Mockito.when(departementService.findAll()).thenReturn(DepartementBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(departementMapper.asDTO(any())).thenReturn(DepartementBuilder.getDTO());

        Mockito.when(departementService.findById(anyLong())).thenReturn(java.util.Optional.of(DepartementBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
        Mockito.verify(departementService, times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(departementService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(departementMapper.asEntity(any())).thenReturn(DepartementBuilder.getEntity());
        Mockito.when(departementService.save(any(Departement.class))).thenReturn(DepartementBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(DepartementBuilder.getDTO())))
                .andExpect(status().isCreated());
        Mockito.verify(departementService, times(1)).save(any(Departement.class));
        Mockito.verifyNoMoreInteractions(departementService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(departementMapper.asEntity(any())).thenReturn(DepartementBuilder.getEntity());
        Mockito.when(departementService.update(any(), anyLong())).thenReturn(DepartementBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(DepartementBuilder.getDTO())))
                .andExpect(status().isOk());
        Mockito.verify(departementService, times(1)).update(any(Departement.class), anyLong());
        Mockito.verifyNoMoreInteractions(departementService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(departementService).deleteById(anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(status().isOk());
        Mockito.verify(departementService, times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(departementService);
    }

}
