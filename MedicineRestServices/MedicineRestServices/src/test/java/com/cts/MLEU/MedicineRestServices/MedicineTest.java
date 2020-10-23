package com.cts.MLEU.MedicineRestServices;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;
import com.cts.MLEU.MedicineRestServices.Repository.MedicineRepository;
import com.cts.MLEU.MedicineRestServices.Service.MedicineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineTest {

	@MockBean
	MedicineRepository medicineDao;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	MedicineService medicineImpl;
	
	@Before
	public void init() {
		Medicine medicine = new Medicine(1,"lexo","fever",150.25,150,new Date(2020-01-01),new Date(2020-15-15));
		
		when(medicineDao.findById(1)).thenReturn(Optional.of(medicine));
	}
	
	@WithMockUser("USER")
	@Test
	public void testFindName() throws Exception{
		mockMvc.perform(get("/medicine/getMedicineByName/lexo"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.medId", is(1)))
        .andExpect(jsonPath("$.medName", is("lexo")))
        .andExpect(jsonPath("$.medType", is("fever")))
        .andExpect(jsonPath("$.medPrice", is(150.25)))
        .andExpect(jsonPath("$.medStock", is(150)))
        .andExpect(jsonPath("$.manDate", is(new Date(2020-01-01))))
		.andExpect(jsonPath("$.expDate", is(new Date(2020-15-15))));
	}
	
	@WithMockUser("USER")
	@Test
    public void findAll() throws Exception {
        // given
        Medicine medicine = new Medicine();
        medicine.setMedId(1);
        medicine.setMedName("lexo");
        medicine.setMedType("fever");
        medicine.setMedprice(150.25);
        medicine.setMedStock(150);
        medicine.setManDate(new Date(2020-01-01));
        medicine.setExpDate(new Date(2020-13-13));
        List<Medicine> medicines = Arrays.asList(medicine);
        given(medicineImpl.getAllMedicine()).willReturn(medicines);

        // when + then
        this.mockMvc.perform(get("/medicine/m"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json("[{'medId':1,'medName':'lexo','medType':'fever','medStock':150,'manDate':'2020-01-01','expDate':'2020-15-15','medprice':150.25}]"));
    }
	
	@Test
	public void testDelete() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/medicine/deleteMedicine/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
}