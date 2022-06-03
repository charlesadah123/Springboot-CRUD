package net.javaguides.springboot.backendspringboot.controller;

import net.javaguides.springboot.backendspringboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.backendspringboot.model.Employee;
import net.javaguides.springboot.backendspringboot.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.HashMap;
import java.lang.Boolean;
import java.util.Map;

@RestController // used to buid rest api
@RequestMapping("/api/v1")    // used to map web request to handler methods
@CrossOrigin( origins  = "http://localhost:4200")
public class EmployeeController {
    @Autowired   // To inject dependencies
    private EmployeeRepository employeeRepository;


    //get employees REST API
    @GetMapping("employees")

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    //get employees by id REST API
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee); // component of hibernate
    }

    //save employees REST API
    @PostMapping("add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }


    //update employees REST API
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());

        return ResponseEntity.ok(this.employeeRepository.save(employee));

    }


    //delete employees REST API
    @DeleteMapping("employees/{id}")
    public Map<String, Boolean> deleteEmployee( @PathVariable(value = "id") Long employeeId ) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        this.employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}

