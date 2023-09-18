package com.example.application.data.entity;

import jakarta.persistence.Entity;

/**
 * Status Entity
 */
@Entity
public class Status extends AbstractEntity {

    // ステータス情報
    private String name;

    public Status() {
    }

    // ステータス情報
    public Status(String name) {
        this.name = name;
    }

    // ステータス情報 取得/設定
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
