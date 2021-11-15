package org.biblioteca.models;

import org.david.Unique;

public final class Book implements Unique {

    private final String title;
    private final String author;
    private final int pages;
    private final int uniqueId;

    public Book(String title, String author, int pages, int uniqueId) {
        this.uniqueId = uniqueId;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int getUniqueId() {
        return uniqueId;
    }

    @Override
    public String toString() {
        return "- \"" + title + "\" por \"" + author + "\" (" + getUniqueId() + ")";
    }
}
