import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BookSorterTest {

	public static class NaturalCompare {

		@Test
		public void test01() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Bats", "Yai", 2000, 200);

			Assert.assertTrue(book1.compareTo(book2) < 0);
		}

		@Test
		public void test02() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Zee", 2000, 200);

			Assert.assertTrue(book1.compareTo(book2) < 0);
		}

		@Test
		public void test03() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Yai", 2001, 200);

			Assert.assertTrue(book1.compareTo(book2) < 0);
		}

		@Test
		public void test04() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Yai", 2000, 100);

			Assert.assertTrue(book1.compareTo(book2) < 0);
		}

		@Test
		public void test05() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Yai", 2000, 200);

			Assert.assertTrue(book1.compareTo(book2) == 0);
		}

	}

	public static class AuthorCompare {

		@Test
		public void test01() {
			Book book1 = new Book("Bats", "Yai", 2001, 100);
			Book book2 = new Book("Apes", "Zee", 2000, 200);

			int actual = Book.AUTHOR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual < 0);
		}

		@Test
		public void test02() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Bats", "Yai", 2000, 200);

			int actual = Book.AUTHOR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual < 0);
		}

		@Test
		public void test03() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Yai", 2000, 200);

			int actual = Book.AUTHOR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual == 0);
		}

	}

	public static class YearCompare {

		@Test
		public void test01() {
			Book book1 = new Book("Bats", "Zee", 2000, 100);
			Book book2 = new Book("Apes", "Yai", 2001, 200);

			int actual = Book.YEAR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual < 0);
		}

		@Test
		public void test02() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Bats", "Yai", 2000, 200);

			int actual = Book.YEAR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual < 0);
		}

		@Test
		public void test03() {
			Book book1 = new Book("Apes", "Yai", 2000, 200);
			Book book2 = new Book("Apes", "Yai", 2000, 200);

			int actual = Book.YEAR_COMPARATOR.compare(book1, book2);

			Assert.assertTrue(actual == 0);
		}

	}

	public static class ListCompare {
		private ArrayList<Book> input;
		private ArrayList<Book> actual;
		private ArrayList<Book> expected;

		private static final Book book1 = new Book("Dogs", "Yai", 2001, 98);
		private static final Book book2 = new Book("Apes", "Zai", 2002, 96);
		private static final Book book3 = new Book("Bats", "Wai", 2003, 99);
		private static final Book book4 = new Book("Cats", "Xai", 2000, 97);
		private static final Book book5 = new Book("Dogs", "Vai", 2001, 98);
		private static final Book book6 = new Book("Apes", "Zai", 2004, 96);
		private static final Book book7 = new Book("Bats", "Wai", 2003, 95);

		public void test(ArrayList<Book> expected, ArrayList<Book> actual) {
			assert expected.size() == actual.size();

			String format = "| %d | %s \t|\t%d | %s %n";
			StringBuilder debug = new StringBuilder("\n| # | expected \t|\t# | actual\n");

			for (int i = 0; i < expected.size(); i++) {
				debug.append(String.format(format, i + 1, expected.get(i), i + 1, actual.get(i)));
			}

			Assert.assertEquals(debug.toString(), expected, actual);
		}

		@Before
		public void setup() {
			input = new ArrayList<>();
			Collections.addAll(input, book1, book2, book3, book4, book5, book6, book7, book4);

			actual = new ArrayList<>();
			expected = new ArrayList<>();
		}

		@Test
		public void test01() {
			actual.addAll(input);
			Collections.sort(actual);
			Collections.addAll(expected, book2, book6, book3, book7, book4, book4, book5, book1);
			test(expected, actual);
		}

		@Test
		public void test02() {
			actual.addAll(input);
			Collections.sort(actual, Book.AUTHOR_COMPARATOR);
			Collections.addAll(expected, book5, book3, book7, book4, book4, book1, book2, book6);
			test(expected, actual);
		}

		@Test
		public void test03() {
			actual.addAll(input);
			Collections.sort(actual, Book.YEAR_COMPARATOR);
			Collections.addAll(expected, book4, book4, book5, book1, book2, book3, book7, book6);
			test(expected, actual);
		}

		@Test
		public void test04() {
			actual = Book.listByPages(input);
			Collections.addAll(expected, book3, book5, book1, book4, book4, book2, book6, book7);
			test(expected, actual);
		}

		@Test
		public void test05() {
			actual = Book.listByPages(input);

			// make sure input was not modified
			Collections.addAll(expected, book1, book2, book3, book4, book5, book6, book7, book4);
			test(expected, input);
		}
	}
}
