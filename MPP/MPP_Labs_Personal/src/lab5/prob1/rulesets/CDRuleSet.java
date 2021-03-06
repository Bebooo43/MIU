package lab5.prob1.rulesets;

import java.awt.Component;

import lab5.prob1.gui.CDWindow;


/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	private CDWindow cdWin;
	@Override
	public void applyRules(Component ob) throws RuleException {
		cdWin = (CDWindow) ob;
		nonemptyRule();
		priceRules();
	}
	
	private void nonemptyRule() throws RuleException {
		if(cdWin.getArtistValue().trim().isEmpty() ||
				cdWin.getPriceValue().trim().isEmpty() ||
				cdWin.getTitle().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void priceRules() throws RuleException {
		String val = cdWin.getPriceValue().trim();
		double doubleVal = 0.0;
		try {
			doubleVal = Double.parseDouble(val);
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be a floating point number.");
		}
		int len = val.length();
		if(val.charAt(len-3) != '.') {
			throw new RuleException("Price must have exactly two digits after the decimal point.");
		}
		if(doubleVal <= 0.49) {
			throw new RuleException("Price must have value bigger than 0.49.");
		}
	}
	
}
