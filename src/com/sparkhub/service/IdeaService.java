package com.sparkhub.service;

import com.sparkhub.dao.IdeaDAO;

public class IdeaService {

    IdeaDAO dao = new IdeaDAO();

    public void addIdea(String user, String idea) {
        dao.addIdea(user, idea);
    }

    public void viewIdeas(String user) {
        String arr[] = dao.getOtherIdeas(user);

        System.out.println("\n===== OTHER USER IDEAS =====");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                System.out.println(arr[i]);
        }
    }

    public void searchIdea(String keyword) {
        dao.searchIdea(keyword);
    }

    public void editIdea(String user, String oldIdea, String newIdea) {
        dao.editIdea(user, oldIdea, newIdea);
    }
}