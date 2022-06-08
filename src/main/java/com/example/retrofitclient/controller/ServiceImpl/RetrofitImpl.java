package com.example.retrofitclient.controller.ServiceImpl;


import com.example.retrofitclient.controller.api.Api;
import com.example.retrofitclient.controller.entity.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.List;

@Service
public class RetrofitImpl implements Api {

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit retrofit;
    private String accessToken;

    private RetrofitService retrofitService;
    public OkHttpClient.Builder getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OkHttpClient.Builder httpClient) {
        this.httpClient = httpClient;
    }

    public RetrofitImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        retrofitService=retrofit.create(RetrofitService.class);

        this.accessToken = "token " + System.getenv("ACCESS_TOKEN");
    }
    public List<Department> allGet() throws IOException {
        Call<List<Department>> retrofitCall = retrofitService.getDeppy();

        Response<List<Department>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();

    }

    public Department allcreate(Department department) throws IOException {
        Call<Department> retrofitCall = retrofitService.saveDepartment(department);

        Response<Department> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public Department alldept(Long departmentId) throws IOException{

        Call<Department> retrofitCall = retrofitService.findByDepartmentById(departmentId);

        Response<Department> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }
}

