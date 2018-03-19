/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTDeclaration extends SimpleNode {

  private int element_id;
  private int element_value;
  private String signal;

  public ASTDeclaration(int id) {
    super(id);
  }

  public ASTDeclaration(yal2jvm p, int id) {
    super(p, id);
  }

  public void setElementId(int id){
    this.element_id =id;
  }

  public void setSignal(String signal){
    this.signal=signal;
  }

  public void setElementValue(String value){
    String finalValue;
    if(this.signal!=null)
    finalValue= this.signal +value;
    else
    finalValue=value;


    this.element_value=Integer.parseInt(finalValue);
  }

  @Override
  public String toString() {
    return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name  + "element id:" + this.element_id +" "+ "element value:"+ this.element_value;
  }
}
/* JavaCC - OriginalChecksum=5d869d09fafa3370307ad4a40f0167bb (do not edit this line) */
