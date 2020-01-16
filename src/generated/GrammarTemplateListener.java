// Generated from /Users/CaelmBleidd/Programming/translator-generator/src/GrammarTemplate.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarTemplateParser}.
 */
public interface GrammarTemplateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GrammarTemplateParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GrammarTemplateParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(GrammarTemplateParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(GrammarTemplateParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#nodeValues}.
	 * @param ctx the parse tree
	 */
	void enterNodeValues(GrammarTemplateParser.NodeValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#nodeValues}.
	 * @param ctx the parse tree
	 */
	void exitNodeValues(GrammarTemplateParser.NodeValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#myRules}.
	 * @param ctx the parse tree
	 */
	void enterMyRules(GrammarTemplateParser.MyRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#myRules}.
	 * @param ctx the parse tree
	 */
	void exitMyRules(GrammarTemplateParser.MyRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#myRule}.
	 * @param ctx the parse tree
	 */
	void enterMyRule(GrammarTemplateParser.MyRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#myRule}.
	 * @param ctx the parse tree
	 */
	void exitMyRule(GrammarTemplateParser.MyRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#myTokens}.
	 * @param ctx the parse tree
	 */
	void enterMyTokens(GrammarTemplateParser.MyTokensContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#myTokens}.
	 * @param ctx the parse tree
	 */
	void exitMyTokens(GrammarTemplateParser.MyTokensContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarTemplateParser#myToken}.
	 * @param ctx the parse tree
	 */
	void enterMyToken(GrammarTemplateParser.MyTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarTemplateParser#myToken}.
	 * @param ctx the parse tree
	 */
	void exitMyToken(GrammarTemplateParser.MyTokenContext ctx);
}