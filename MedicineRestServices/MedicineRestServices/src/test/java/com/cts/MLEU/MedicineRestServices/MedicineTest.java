package com.cts.MLEU.MedicineRestServices;

import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;import com.cts.MLEU.MedicineRestServices.Model.Medicine;
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
	
	
}