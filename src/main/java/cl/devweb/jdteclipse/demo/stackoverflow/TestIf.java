package cl.devweb.jdteclipse.demo.stackoverflow;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;


/**
 * https://stackoverflow.com/questions/50484559/how-to-check-if-a-visited-node-is-in-if-part-or-else-part-of-ifstatement-node-in
 * 
 * @author German
 *
 */
public class TestIf extends ASTVisitor {



    //If you use visit(IfStatement node) instead of visit(MethodInvocation node), 
    //you can visit both the then (getThenStatement()) and the else (getElseStatement()) branch with a separate visitor:
    @Override
    public boolean visit(IfStatement node) {
    
        Statement thenBranch = node.getThenStatement(); 
        if (thenBranch != null) {
            thenBranch.accept(new ASTVisitor(false) {
                @Override
                public boolean visit(MethodInvocation node) {
                    // handle method invocation in the then branch
                    return true; // false, if nested method invocations should be ignored
                }
            });
        }
    
        Statement elseBranch = node.getElseStatement(); 
        if (elseBranch != null) {
            elseBranch.accept(new ASTVisitor(false) {
                @Override
                public boolean visit(MethodInvocation node) {
                    // handle method invocation in the else branch
                    return true; // false, if nested method invocations should be ignored
                }
            });
        }
    
        return true; // false, if nested if statements should be ignored
    }


}
