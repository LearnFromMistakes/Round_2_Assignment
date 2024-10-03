package com.example.ems.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Getter
@Setter
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String department;
    private String gender;

}
