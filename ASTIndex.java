/* Generated By:JJTree: Do not edit this line. ASTIndex.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTIndex extends SimpleNode {
  private int index;
  public ASTIndex(int id) {
    super(id);
  }

  public ASTIndex(yal2jvm p, int id) {
    super(p, id);
  }
  public void setIndex(String id){
    this.index=Integer.parseInt(id);
  }

  @Override
  public String toString() {
    return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name + "  value:" + this.index;
  }

}
/* JavaCC - OriginalChecksum=76e8fe9f0f42b1c688d912ad4dcd726a (do not edit this line) */
