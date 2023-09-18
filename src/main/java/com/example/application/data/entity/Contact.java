package com.example.application.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Contact Entity
 */
@Entity
public class Contact extends AbstractEntity {

    // ファーストネーム
    @NotEmpty
    private String firstName = "";

    // ラストネーム
    @NotEmpty
    private String lastName = "";

    // ManyToOne 会社
    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Company company;

    // ManyToOne ステータス
    @NotNull
    @ManyToOne
    private Status status;

    // メールアドレス
    @Email
    @NotEmpty
    private String email = "";

    // 氏名
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    // ファーストネーム 取得/設定
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // ラストネーム 取得/設定
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // 会社 取得/設定
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    // ステータス 取得/設定
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    // メールアドレス 取得/設定
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
