package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class CrmService {

    // メンバー変数
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository,
                      CompanyRepository companyRepository,
                      StatusRepository statusRepository) { 
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    // 全顧客情報取得 テキスト検索 切り替え
    public List<Contact> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) { 
            return contactRepository.findAll();
        } else {
            return contactRepository.search(stringFilter);
        }
    }

    // 顧客数
    public long countContacts() {
        return contactRepository.count();
    }

    // 顧客削除
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    // 顧客保存
    public void saveContact(Contact contact) {
        if (contact == null) { 
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        contactRepository.save(contact);
    }

    // 全会社情報取得
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    // 全ステータス情報取得
    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }
}