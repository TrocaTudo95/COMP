/* Generated By:JJTree: Do not edit this line. ASTExprtest.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTExprtest extends SimpleNode {
  private String operation;
  public ASTExprtest(int id) {
    super(id);
  }

  public ASTExprtest(yal2jvm p, int id) {
    super(p, id);
  }

  public void setOperation(String operation){
  this.operation=operation;
}

@Override
public String toString() {
  if(this.operation!=null)
  return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name + "  operator:" + this.operation;
  else
  return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name ;
}

public void semanticAnalysis(SymbolTable st)throws ParseException{
  SemanticAnalyzer.comparison(st,this);
}
}
/* JavaCC - OriginalChecksum=ff3171bcbe6a3ba94811ed3933aebc1f (do not edit this line) */
