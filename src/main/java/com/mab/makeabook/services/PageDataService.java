package com.mab.makeabook.services;

import com.mab.makeabook.models.Page;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class PageDataService {
    @Value("${bookapp.title}")
    String appTitle;
    List<Page> availablePages = new ArrayList<>();

    PageDataService() {
        availablePages.add(new Page("index", "Home", "Home page", "/"));
        availablePages.add(new Page("register", "Register", "Create an account", "/register"));
        availablePages.add(new Page("login", "Login", "Login to start chatting", "/login"));
        availablePages.add(new Page("constructor", "Constructor", "Make a Book", "/constructor"));
        availablePages.add(new Page("myBooks", "My Books", "My Books", "/myBooks"));
    }

    public Page getPage(String pageName){
        for (Page page: this.availablePages){
            if (page.getName().equalsIgnoreCase(pageName)) return page;
        }
        return null;
    }

    public List<Page> getPages(){
        return availablePages;
    }

    public String getAppTitle() {
        return appTitle;
    }
}
