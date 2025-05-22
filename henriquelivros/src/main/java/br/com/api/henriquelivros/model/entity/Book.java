package br.com.api.henriquelivros.model.entity;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Book
{
    private UUID uuid;
    private String title;

    public Book(UUID uuid, String title) {
        this.uuid = uuid;
        this.title = title;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }
}
