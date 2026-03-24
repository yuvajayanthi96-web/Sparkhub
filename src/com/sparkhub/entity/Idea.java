package com.sparkhub.entity;
public class Idea {
private int id;
private String username;
private String idea;

public Idea() {}  

public Idea(String username, String idea) {  
    this.username = username;  
    this.idea = idea;  
}  

public String getUsername() { return username; }  
public String getIdea() { return idea; }

}