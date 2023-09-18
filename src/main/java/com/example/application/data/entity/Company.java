package com.example.application.data.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Formula;

import java.util.LinkedList;
import java.util.List;

/**
 * Company Entity
 */
@Entity
public class Company extends AbstractEntity {

    //会社名
    @NotBlank
    private String name;

    // OneToMany
    @OneToMany(mappedBy = "company")
    @Nullable
    private List<Contact> employees = new LinkedList<>();

    //会社に属している従業員数
    @Formula("(select count(c.id) from Contact c where c.company_id = id)")
    private int employeeCount;

    // 従業員名情報 取得/設定
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // 従業員情報 取得/設定
    public List<Contact> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Contact> employees) {
        this.employees = employees;
    }

    // 従業員人数
    public int getEmployeeCount() {
        return employeeCount;
    }
}
