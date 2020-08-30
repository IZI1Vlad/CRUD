package ru.vpirogov;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.vpirogov.domain.Employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test  // Тесты на проверку работы методов 1) Добавления сотрудника 2) Получения всех сотр. 3) Получение одного сотр. 4) Удаление сотр.
    public void addTest() throws Exception {
        Employee employee = mockEmployee("addTest");
        byte[] employeeJSON = toJson(employee);
        MvcResult result = mockMvc.perform(post("/employee")
                .content(employeeJSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getOneTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/employee/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void deleteTest() throws Exception {
        MvcResult result = mockMvc.perform(delete("/employee/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    // Создание обьекта сотрудника
    private Employee mockEmployee(String prefix) {
        Employee employee = new Employee();
        employee.setFirstName("firstName" + prefix);
        return employee;
    }
    // Конвертация сотрудника в формат Json
    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}

