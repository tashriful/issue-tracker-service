package com.aye.web.controller;


import com.aye.web.exception.ResourceNotFoundException;
import com.aye.web.model.DepartmentHead;
import com.aye.web.service.DepartmentHeadService;
import com.aye.web.service.SequenceGeneratorService;
import com.aye.issuetrackerdto.entityDto.DepartmentHeadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departmentHeads")
public class DepartmentHeadController {

    @Autowired
    private DepartmentHeadService departmentHeadService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/")
    public ResponseEntity<DepartmentHeadDto> createDepartmentHead(@RequestBody DepartmentHeadDto departmentHeadDto) {
        departmentHeadDto.setId(sequenceGeneratorService.generateSequence(DepartmentHead.SEQUENCE_NAME));
        DepartmentHeadDto createdDepartmentHead = departmentHeadService.createDepartmentHead(departmentHeadDto);
        return new ResponseEntity<>(createdDepartmentHead, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentHeadDto> getDepartmentHeadById(@PathVariable Long id) throws ResourceNotFoundException {
        System.out.println(id);
        DepartmentHeadDto departmentHeadDto = departmentHeadService.getDepartmentHeadById(id);
        return new ResponseEntity<>(departmentHeadDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentHeadDto>> getAllDepartmentHeads() {
        List<DepartmentHeadDto> departmentHeadDtos = departmentHeadService.getAllDepartmentHeads();
        return new ResponseEntity<>(departmentHeadDtos, HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<DepartmentHeadDto>> getDepartmentHeadsByDepartment(@PathVariable Long departmentId) {
        List<DepartmentHeadDto> departmentHeadDtos = departmentHeadService.getDepartmentHeadsByDepartment(departmentId);
        return new ResponseEntity<>(departmentHeadDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartmentHead(@PathVariable Long id) throws ResourceNotFoundException {
        departmentHeadService.deleteDepartmentHead(id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }
}
