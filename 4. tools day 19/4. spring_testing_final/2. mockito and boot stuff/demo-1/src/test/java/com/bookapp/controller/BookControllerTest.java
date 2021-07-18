package com.bookapp.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private BookService bookService;
//	@Test
//	public void testAllBooks() throws Exception {
//		List<Book>books=Arrays.asList(new Book("java", "raj", 500.00),
//				new Book("python", "ekta", 600.00));
//		
//		when(bookService.getAll()).thenReturn(books);
//		
//		String url="/book";
//		
//		mockMvc.perform(get(url)).andExpect(status().isOk());
//	}
	
//	@Test
//	public void testAllBooks() throws Exception {
//		List<Book>books=Arrays.asList(new Book("java", "raj", 500.00),
//				new Book("python", "ekta", 600.00));
//		
//		when(bookService.getAll()).thenReturn(books);
//		
//		String url="/book";
//		
//		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//		
//		//Converting response to json
//		String actualJsonResponse=mvcResult.getResponse().getContentAsString();
//		
//		System.out.println(actualJsonResponse);
//		
//		//converting to json using object mapper
//		String expectedJsonResponse=objectMapper.writeValueAsString(books);
//		
//		assertThat(actualJsonResponse).isEqualToIgnoringCase(expectedJsonResponse);
//	}
	
	@Test
	public void testAddBook() throws Exception{
		Book bookAdded= new Book("java", "raj", 500.00);
		
		String jsonStringBookAdded=objectMapper.writeValueAsString(bookAdded);
		
		when(bookService.addBook(bookAdded)).thenReturn(bookAdded);
		
		String url="/book";
		mockMvc.perform(
				post(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookAdded))
				)
				.andExpect(status().isOk());
				//.andExpect(content().string(jsonStringBookAdded));			
	}
	
	@Test
	public void testUpdateBookNameCanNotNull() throws Exception{
		Book bookAdded= new Book("", "raj", 500.00);
		
		String jsonStringBookAdded=objectMapper.writeValueAsString(bookAdded);
		
		when(bookService.addBook(bookAdded)).thenReturn(bookAdded);
		
		String url="/book";
		
		mockMvc.perform(
				put(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookAdded))
				)
				.andExpect(status().isOk());
				//.andExpect(content().string(jsonStringBookAdded));			
	}
	
	
	@Test
	public void testDeleteBookNameCanNotNull() throws Exception{
		int bookId=1;
		
		
		doNothing().when(bookService).deleteBook(bookId);
		
		String url="/book";
		
		mockMvc.perform(get(url))	.andExpect(status().isOk());
		
		verify(bookService, times(1)).deleteBook(bookId);
	}
	
	
}








