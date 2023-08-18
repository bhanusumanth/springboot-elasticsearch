package com.bhanu.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.DateFormat;

import java.util.List;

/**
 * Entity class representing an employee stored in Elasticsearch.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "employees")
public class Employee {

    @Id
    @JsonIgnore // Exclude id field from JSON serialization
    private String id;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Keyword)
    private String designation;

    @Field(type = FieldType.Integer)
    private Integer salary;

    @Field(type = FieldType.Date, format = DateFormat.year_month_day)
    private String dateOfJoining;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Keyword)
    private String gender;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Keyword)
    private String maritalStatus;

    @Field(type = FieldType.Text)
    private List<String> interests;
}
