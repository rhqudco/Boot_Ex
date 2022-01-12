package book;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}

	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		ArrayList<BookVO> bookList = service.listAllBook();
		model.addAttribute("bookList", bookList);
		return "book/bookListView";
	}

	@RequestMapping("/book/newBookForm")
	public String newBookForm() {
		return "book/newBookForm";
	}

	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO book) {
		System.out.println(book.getBookNo());
		service.insertBook(book);
		return "redirect:./listAllBook";
	}

	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo, Model model) {
		BookVO book = service.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "book/bookDetailView";
	}

	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo, Model model) {
		BookVO book = service.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "book/updateBookForm";
	}

	@RequestMapping("/book/updateBook")
	public String detailViewBook(BookVO book) {
		service.updateBook(book);
		return "redirect:/book/listAllBook";
	}

	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		service.deleteBook(bookNo);
		return "redirect:/book/listAllBook";
	}

	@ResponseBody
	@RequestMapping("book/bookNoCheck")
	public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		
		String result = "use";
		if(bookNo_result != null) {
			result = "no_use";
		}
		return result;
	}

	@RequestMapping("/book/bookSearchForm")
	public String bookSearchForm() {
		return "book/bookSearchForm";
	}

	@ResponseBody
	@RequestMapping("/book/bookSearch")
	public ArrayList<BookVO> bookSearch(@RequestParam HashMap<String, Object> param, Model model){
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList", bookList);
		return bookList;
	}
}