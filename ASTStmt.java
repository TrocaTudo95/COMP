/* Generated By:JJTree: Do not edit this line. ASTStmt.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTStmt extends SimpleNode {
  public ASTStmt(int id) {
    super(id);
  }

  public ASTStmt(yal2jvm p, int id) {
    super(p, id);
  }

  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
            if(children[i].getClass().getName() == "ASTAssign"){
        ASTAssign n = (ASTAssign)children[i];
        if (n != null) {
        n.lookForLocals(func_name,st);

        }
      }
    }
  }
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
/* JavaCC - OriginalChecksum=bf4117653231575e76a58ace23384507 (do not edit this line) */
