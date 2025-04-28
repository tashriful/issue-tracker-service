package com.aye.web.service;

import com.aye.web.model.Department;

import java.util.List;

public interface ProjectService{

    Department saveProjects(Department projects);

    List<Department> fetchAllProjects();

    Department findProjectById(Long id);

    void deleteProjectById(Long id);


}
