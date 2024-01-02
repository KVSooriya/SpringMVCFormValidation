package com.vismee.springformvalidation.model;

import com.vismee.springformvalidation.customvalidation.CourseCode;
import com.vismee.springformvalidation.customvalidation.PhoneNumber;
import jakarta.validation.constraints.*;

public class Customer
{
    private String firstName;

    @NotNull
    @Size(min=1,message="required")
    private String lastName;

    @NotNull
    @Min(value=10)
    @Max(value=50)
    private Integer age;

    @Pattern(regexp="^[a-zA-Z0-9]{6}")
    private String postalCode;

    @CourseCode(value="KV")  // custom validation
    private String course;

    @PhoneNumber  // custom validation
    private String phoneNumber;

    public Customer()
    {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
