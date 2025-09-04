package com.seroter.azure_basic_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Events")
public class Article {
    
    @Id
	@GeneratedValue
    private Long id;

    private String title;

    private User author;

    private User[] likes;
    private User[] dislikes;
    private User[] shares;



}
