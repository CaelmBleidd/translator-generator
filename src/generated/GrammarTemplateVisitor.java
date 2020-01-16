// Generated from /Users/CaelmBleidd/Programming/translator-generator/src/GrammarTemplate.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarTemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarTemplateVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GrammarTemplateParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(GrammarTemplateParser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#nodeValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeValues(GrammarTemplateParser.NodeValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#myRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyRules(GrammarTemplateParser.MyRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#myRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyRule(GrammarTemplateParser.MyRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#myTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyTokens(GrammarTemplateParser.MyTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarTemplateParser#myToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyToken(GrammarTemplateParser.MyTokenContext ctx);
}