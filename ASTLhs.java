/* Generated By:JJTree: Do not edit this line. ASTLhs.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTLhs extends SimpleNode {
  public ASTLhs(int id) {
    super(id);
  }

  public ASTLhs(yal2jvm p, int id) {
    super(p, id);
  }
  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
              System.out.println(children[i].getClass().getName());
        if(children[i].getClass().getName() == "ASTAccessElement"){
        ASTAccessElement n = (ASTAccessElement)children[i];
        if (n != null) {
          System.out.println("Looking for locals on lhs");
          n.lookForLocals(this.name,st);

        }
      }
    }
  }
  }

}
/* JavaCC - OriginalChecksum=3ff9e3ae6aa569f2c1475e98d7f21869 (do not edit this line) */
