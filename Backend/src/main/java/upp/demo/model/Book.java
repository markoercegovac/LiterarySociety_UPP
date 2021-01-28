package upp.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User owner;

	@ManyToMany
	private List<User> editors = new ArrayList<>();

	@ManyToMany
	private List<User> betaReaders = new ArrayList<>();

	@Column
	private String isbn;

	@Column
	private String title;

	@Column
	private int publishingYear;

	@Column
	private int noOfPages;

	@Column(columnDefinition="text")
	private String synopsis;

	@ManyToOne
	private Genre genre;

	@Column
	private Boolean published;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return publishingYear == book.publishingYear &&
				noOfPages == book.noOfPages &&
				id.equals(book.id) &&
				Objects.equals(isbn, book.isbn) &&
				Objects.equals(title, book.title) &&
				Objects.equals(published, book.published);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isbn, title, publishingYear, noOfPages, published);
	}
}
