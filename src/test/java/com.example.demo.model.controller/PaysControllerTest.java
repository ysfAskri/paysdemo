//package com.example.demo.model.controller;
//
//import com.example.demo.controller.impl.PaysControllerImpl;
//import com.example.demo.dto.PaysDTO;
//import com.example.demo.model.Pays;
//import com.example.demo.service.PaysService;
//import com.google.gson.Gson;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PaysControllerTest {
//
//    private static final String ENDPOINT_URL = "/api/pays";
//    @Mock
//    PaysService paysService;
//
//    @InjectMocks
//    PaysControllerImpl paysController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.paysController).build();
//    }
//
//    @Test
//    public void findById() throws Exception {
//        Mockito.when(paysService.findById(ArgumentMatchers.anyString())).thenReturn(java.util.Optional.of(new Pays()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/{id}", "id"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(paysService, Mockito.times(1)).findById(ArgumentMatchers.anyString());
//        Mockito.verifyNoMoreInteractions(paysService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        PaysDTO dto = new PaysDTO();
//        /*TODO: Set Mock DATA in DTO Object*/
//        Gson gson = new Gson();
//        Mockito.when(paysService.save(ArgumentMatchers.any(PaysDTO.class))).thenReturn(dto);
//        mockMvc.perform(
//                MockMvcRequestBuilders.post(ENDPOINT_URL + "/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                        .content(gson.toJson(dto)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(paysService, Mockito.times(1)).save(ArgumentMatchers.any(PaysDTO.class));
//        Mockito.verifyNoMoreInteractions(paysService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        PaysDTO dto = new PaysDTO();
//        /*TODO: Set Mock DATA in DTO Object*/
//        Gson gson = new Gson();
//        Mockito.when(paysService.updateById(ArgumentMatchers.any(PaysDTO.class))).thenReturn(dto);
//        mockMvc.perform(
//                MockMvcRequestBuilders.put(ENDPOINT_URL + "/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                        .content(gson.toJson(dto)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(paysService, Mockito.times(1)).updateById(ArgumentMatchers.any(PaysDTO.class));
//        Mockito.verifyNoMoreInteractions(paysService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(paysService).deleteById(ArgumentMatchers.anyString());
//        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL + "/{id}", "id"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(paysService, Mockito.times(1)).deleteById(ArgumentMatchers.anyString());
//        Mockito.verifyNoMoreInteractions(paysService);
//    }
//
//    @Test
//    public void list() throws Exception {
//        PaysDTO dto = new PaysDTO();
//        /*TODO: Set Mock DATA in DTO Object*/
//        Mockito.when(paysService.findAll()).thenReturn(Arrays.asList(dto, dto));
//        mockMvc.perform(
//                MockMvcRequestBuilders.get(ENDPOINT_URL + "/")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
//                .andDo(MockMvcResultHandlers.print());
//        Mockito.verify(paysService, Mockito.times(1)).findAll();
//        Mockito.verifyNoMoreInteractions(paysService);
//    }
//}
