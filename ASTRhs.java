/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTRhs extends SimpleNode {

  private String operation;
  public ASTRhs(int id) {
    super(id);
  }

  public ASTRhs(grammar p, int id) {
    super(p, id);
  }

  public void setOperation(String operation){
  this.operation=operation;
}

@Override
public String toString() {
  if(this.operation!=null)
  return grammarTreeConstants.jjtNodeName[id] + " " + this.name + "  operator:" + this.operation;
  else
  return grammarTreeConstants.jjtNodeName[id] + " " + this.name ;
}

}
/* JavaCC - OriginalChecksum=382452feeb0e2b1ea4adcce00e40f8b4 (do not edit this line) */
