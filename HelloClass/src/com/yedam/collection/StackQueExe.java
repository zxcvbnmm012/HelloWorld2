package com.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueExe {
	public static void main(String[] args) {
		// Stack : LIFO -> LastInFirstout (후입선출)
		// push() : in
		// pop() : out
		System.out.println(">> Stack");
		Stack<String> books = new Stack<String>();
		books.push("1.이것이자바다");
		books.push("2.HTML,CSS");
		books.push("3.자바스크립트기초");
		
		while(!books.isEmpty()) {  // isEmpty() : 비어있으면 true
			System.out.println(books.pop());
		}
		
		
		// Queue : FIFO -> FirstInFirstOut (선입선출)
		// offer() : in
		// poll() : out
		System.out.println();
		System.out.println(">> Queue");
		Queue<String> orders = new LinkedList<String>();
		orders.offer("1.카페라떼");
		orders.offer("2.아메리카노");
		orders.offer("3.녹차");
		
		while(!orders.isEmpty()) {
			System.out.println(orders.poll());
		}
		
	} // end of main
}
