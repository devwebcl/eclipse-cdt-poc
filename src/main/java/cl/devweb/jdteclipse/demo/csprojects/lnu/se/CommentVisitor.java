package cl.devweb.jdteclipse.demo.csprojects.lnu.se;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.LineComment;


/**
 * http://csprojects.lnu.se:23000/mohsen/stsextractor/blame/494214ebe7b85076dbe837268c8e660bde43333a/src/se/lnu/prosses/securityMonitor/JavaNormalizer.java
 * 
 * @author German
 *
 */
class CommentVisitor extends ASTVisitor {
    
    CompilationUnit cu;
    String source;
 
    public CommentVisitor(CompilationUnit cu, String source) {
        super();
        this.cu = cu;
        this.source = source;
    }
 
    public boolean visit(LineComment node) {
        
        int start = node.getStartPosition();
        int end = start + node.getLength();
        String comment = source.substring(start, end);
        System.out.println(comment);
        
        return true;
    }
 
 
}

