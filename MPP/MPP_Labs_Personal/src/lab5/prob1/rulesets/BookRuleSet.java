package lab5.prob1.rulesets;

import java.awt.Component;

import lab5.prob1.gui.BookWindow;



/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	private BookWindow bookWin;
	@Override
	public void applyRules(Component ob) throws RuleException {
		bookWin = (BookWindow) ob;
		nonemptyRule();
		isbnRule();	
		priceRules();
	}
	

	private void nonemptyRule() throws RuleException {
		if(bookWin.getIsbnValue().trim().isEmpty() ||
			 bookWin.getTitleValue().trim().isEmpty() ||
			 bookWin.getPriceValue().trim().isEmpty()) {
			   throw new RuleException("All fields must be nonempty");
		}
	}
	

	private void isbnRule() throws RuleException {
		String val = bookWin.getIsbnValue().trim();
		try {
			Long.parseLong(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ISBN must be numeric");
		}	
		int len = val.length();
		if(len != 10 && len != 13) 
			throw new RuleException("ISBN must have 10 or 13 digits");
		if(len == 10 && !(val.charAt(0) == '0' || val.charAt(0) == '1')) {
			throw new RuleException("First digit of 10-digit ISBN must be 0 or 1");
		}
		if(len == 13 && !(val.startsWith("978") || val.startsWith("979"))) {
			throw new RuleException("All 13-digit ISBNs must begin with either '978' or '979'");
		}
	}
	private void priceRules() throws RuleException {
		String val = bookWin.getPriceValue().trim();
		double doubleVal = 0.00;
		try {
			doubleVal = Double.parseDouble(val);
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be a floating point number.");
		}
		int len = val.length();
		if(len < 3 || val.charAt(len-3) != '.') {
			throw new RuleException("Price must have exactly two digits after the decimal point.");
		}
		if(doubleVal <= 0.49) {
			throw new RuleException("Price must have value bigger than 0.49.");
		}
	}



}
