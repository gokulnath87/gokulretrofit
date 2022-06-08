package com.example.retrofitclient.controller.ServiceImpl;

import com.example.retrofitclient.controller.entity.Department;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RetrofitService {
    @GET("/dept/getdepp")
    Call<List<Department>> getDeppy();
    @POST("/dept/depp")
    Call<Department> saveDepartment(@Body Department department);
    @GET("/dept/{id}")
    Call <Department>findByDepartmentById(@Path("id") Long departmentId);
}
