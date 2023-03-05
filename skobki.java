// Написать метод, определяющую правильность расстановки скобок в выражении.
//  * Могут содержаться следующие скобки: ()[]{}<>
//  * () -> true
//  * []{}((<>)) -> true
//  * ) -> false
//  * [) -> false
//  * []{}(<)> -> false

import java.util.Scanner;
import java.util.Stack;

public class skobki {

	public static void main(final String[] args) throws Exception {
		Scanner Scanner = new Scanner(System.in);	
		System.out.printf("Введите строку из скобок вида ()[]{}<> для прочерки последовтельности: ");
        String str = Scanner.nextLine();
        Scanner.close();
		char[] symbols = str.toCharArray();
		Stack<Character> stack = new Stack<>(); // Инициация стека
		for(char c : symbols) {
			if (c == '(' || c == '{' || c == '[') { //Добавление открывающихся скобок
				stack.push(c);
			} 
			if (c == ')' || c == '}' || c == ']') { //Добавление закрывающих скобок
				if(!stack.isEmpty()) { //Если стек не пустой->продолжается проверка
					char fromStack = stack.peek();
					if((c == ')' && fromStack == '(') || 
							(c == '}' && fromStack == '{') ||
							(c == ']' && fromStack == '[')) {
						stack.pop(); //Из стека удалена открывающая скобка;
					} else { //Несоответствие последней открывающей на стеке->прерывание;
						break;
					}
				} else { //Если стек пустой, то строка от пользовател начинается с закрывающей->прерывание
					stack.add(c);
					break;					
				}
			}
			
		}
		
		if(!stack.isEmpty()) {
            System.out.printf("Последовательность скобок %s НЕ корректная ", str);
		} else {
			System.out.printf("Последовательность скобок %s корректная ", str);
		}
	}
}