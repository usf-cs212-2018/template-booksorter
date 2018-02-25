import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {

	/** Title of the book. */
	public final String title;

	/** Author(s) of the book. */
	public final String author;

	/** Year of the book. */
	public final int year;

	/** Number of pages in the book. */
	public final int pages;

	/**
	 * Initializes a book from the provided parameters.
	 *
	 * @param title
	 *            title of the book
	 * @param author
	 *            author(s) of the book
	 * @param year
	 *            year of the book
	 * @param pages
	 *            number of pages in the book
	 */
	public Book(String title, String author, int year, int pages) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
	}

	@Override
	public String toString() {
		return String.format("%s by %s, %d pages, %d.", this.title, this.author, this.pages, this.year);
	}
		
	/**
	 * Compares books by title in ascending order. If the titles are the same,
	 * compares by author in ascending order. If the authors are the same,
	 * compares by year in ascending order. If the years are the same, compares
	 * by pages in descending order.
	 *
	 * @see String#compareTo(String)
	 * @see Integer#compare(int, int)
	 */
	@Override
	public int compareTo(Book other) {
		// TODO Implement this method.
		return 0;
	}

	// TODO Implement the following comparator using an anonymous inner class.
	/**
	 * Compares books by author in ascending order. If the authors are the same,
	 * uses the natural ordering of books.
	 */
	public static final Comparator<Book> AUTHOR_COMPARATOR = null;

	// TODO Implement the following comparator using a private static nested class.
	/**
	 * Compares books by year in ascending order. If the years are the same,
	 * uses the natural ordering of books.
	 */
	public static final Comparator<Book> YEAR_COMPARATOR = null;

	/**
	 * Returns a list of books sorted by pages in descending order, and if the
	 * pages are the same, uses the natural book ordering. Does NOT modify the
	 * original collection.
	 *
	 * @param books
	 *            collection of books to sort
	 *
	 * @return list of books sorted by pages
	 * @see Collections#sort(List, Comparator)
	 * @see ArrayList#ArrayList(Collection)
	 */
	public static final ArrayList<Book> listByPages(Collection<Book> books) {
		// TODO Implement this method using an anonymous inner class.
		return null;
	}

	/*
	 * Instructor Note: Do NOT try to place Book objects (or any custom object)
	 * in a data structure requiring uniqueness with this implementation. This
	 * includes sets (either HashSet or TreeSet), or as keys for maps (either
	 * HashMap or TreeMap).
	 *
	 * This is because we have not defined what it means for two Book objects to
	 * be equal (i.e. we have not overridden the hashCode() and equals()
	 * methods) or taken into account duplicates in our comparison methods.
	 *
	 * There are some really great discussions on StackOverflow as to why this
	 * is the case, but we won't get into that during class. You can also find a
	 * good writeup on how to do this properly at:
	 * http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
	 */
}
