/* Generated By:JJTree: Do not edit this line. ASTStmtlst.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTStmtlst extends SimpleNode {
  public ASTStmtlst(int id) {
    super(id);
  }

  public ASTStmtlst(yal2jvm p, int id) {
    super(p, id);
  }

  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTStmt"){
        ASTStmt n = (ASTStmt)children[i];
        if (n != null) {
          n.lookForLocals(func_name,st);
        }
      }
    }
  }
  }



}
/* JavaCC - OriginalChecksum=e4907d08d4dc838a2e5bc5d181c95272 (do not edit this line) */
