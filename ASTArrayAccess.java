/* Generated By:JJTree: Do not edit this line. ASTArrayAccess.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTArrayAccess extends SimpleNode {
  public ASTArrayAccess(int id) {
    super(id);
  }

  public ASTArrayAccess(yal2jvm p, int id) {
    super(p, id);
  }

    public void process(BufferedWriter s,SymbolTable st,String funcName){

      if (children != null) {
        for (int i = 0; i < children.length; ++i) {
          SimpleNode n = (SimpleNode)children[i];
          if (n != null) {
            n.process(s,st,funcName);
          }
        }
      }
    }

}
/* JavaCC - OriginalChecksum=bd38f05fb55ac0b6d4b6eb9386025960 (do not edit this line) */
