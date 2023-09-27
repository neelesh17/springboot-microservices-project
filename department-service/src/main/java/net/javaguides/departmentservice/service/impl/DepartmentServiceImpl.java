package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exceptions.ResourceNotFoundException;
import net.javaguides.departmentservice.mapper.AutoDepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department = new Department(
//                departmentDto.getId(),departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode()
//        );
        Department department = AutoDepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
//        return new DepartmentDto(
//                savedDepartment.getId(), savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode()
//        );
        return AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Optional<Department> optionalDepartment = Optional.ofNullable(departmentRepository.findByDepartmentCode(code));
        if(optionalDepartment.isEmpty()){
            throw new ResourceNotFoundException("Deaprtment", "departmentCode", code);
        }
//        return new DepartmentDto(
//                department.getId(), department.getDepartmentName(),
//                department.getDepartmentDescription(), department.getDepartmentCode()
//        );
        return AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(optionalDepartment.get());
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        return allDepartments.stream().map((department) -> AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department)).collect(Collectors.toList());
    }


}
