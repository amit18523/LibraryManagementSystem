package com.example.demo.Model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity

@Table(name = "books")
public class Book {

    @Id
    @Column(name = "bookId", unique = true)
    private Long bookId;

    @Column(name = "serialNo", length = 50, nullable = false, unique = true)
    private Long serialNo;

    @Column(name = "price", length = 50, nullable = false)
    private Long price;

    @Column(name = "bookName", length = 50, nullable = false)
    private String bookName;

    @ManyToMany( cascade = { CascadeType.ALL})
	@JoinTable(name = "booksAuthors", joinColumns = { @JoinColumn(name = "bookId" , referencedColumnName = "bookId") }, inverseJoinColumns = {
			@JoinColumn(name = "authorId") })
	private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "booksCategories", joinColumns = { @JoinColumn(name = "bookId", referencedColumnName = "bookId") }, inverseJoinColumns = {
            @JoinColumn(name = "categoryId") })
    private Set<Category> categories = new HashSet<Category>();

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public Long getPrice() {
        return price;
    }
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}