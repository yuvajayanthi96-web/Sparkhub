package com.sparkhub.controller;

import com.sparkhub.service.IdeaService;

public class IdeaController {

    IdeaService service = new IdeaService();

    public void createIdea(String user, String idea) {
        service.addIdea(user, idea);
    }

    public void showIdeas(String user) {
        service.viewIdeas(user);
    }

    public void searchIdea(String keyword) {
        service.searchIdea(keyword);
    }

    public void editIdea(String user, String oldIdea, String newIdea) {
        service.editIdea(user, oldIdea, newIdea);
    }
}