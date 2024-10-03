package com.example.demo.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Document(indexName = "employees")
public class Employee {


    private Long id;

    private String name;

    private String gender;

    private Long phone;

    private String department;

}
