package com.aye.web;

import com.aye.web.model.Department;
import com.aye.web.repository.DepartmentRepository;
import com.aye.web.service.DepartmentService;
import com.aye.issuetrackerdto.entityDto.DepartmentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;


    @Test
    public void testGetDepartmentById_ExistingDepartment() {
        Long departmentId = 6L;
        Department existingDepartment = new Department();
        existingDepartment.setId(departmentId);
        existingDepartment.setName("VAT");
        existingDepartment.setDescription("VAT Department");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(existingDepartment));

        DepartmentDto retrievedDepartment = departmentService.getDepartmentById(departmentId);
        System.out.println(retrievedDepartment);

        assertEquals(existingDepartment.getName(), retrievedDepartment.getName());
        assertEquals(existingDepartment.getDescription(), retrievedDepartment.getDescription());
    }
}
