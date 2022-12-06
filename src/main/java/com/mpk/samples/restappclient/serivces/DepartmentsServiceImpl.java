package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.DepartmentEntity;
import com.mpk.samples.restappclient.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DepartmentsServiceImpl {
    
    private final DepartmentRepository departmentRepository;
    
    public List<DepartmentEntity> findAllDepartments(){
        return departmentRepository.findAll();
    }

    public DepartmentEntity postNewDepartment(DepartmentEntity departmentEntity) {
        if(departmentRepository.findByDepartmentName(departmentEntity.departmentName()) != null){
            return departmentRepository.findByDepartmentName(departmentEntity.departmentName());
        }
        return departmentRepository.save(departmentEntity);
    }
}
