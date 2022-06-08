package com.example.retrofitclient.controller.controllerg;


import com.example.retrofitclient.controller.ServiceImpl.RetrofitImpl;
import com.example.retrofitclient.controller.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RetrofitController {
    @Autowired
    RetrofitImpl retrofitimpl;
   @GetMapping("/get-all")
   public List<Department> getAll() throws IOException {
       return retrofitimpl.allGet();
   }
   @PostMapping("/getdepp")
    public Department create(@RequestBody Department department) throws IOException{
       return retrofitimpl.allcreate(department);
   }
  @GetMapping("/{id}")
    public Department getById(@PathVariable("id") Long departmentId) throws IOException {
       return retrofitimpl.alldept(departmentId);
  }
}
