/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected int value;
  protected yal2jvm parser;
  protected Token firstToken;
  protected Token lastToken;
  protected String name;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(yal2jvm p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(int value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  public Token jjtGetFirstToken() { return firstToken; }
  public void jjtSetFirstToken(Token token) { this.firstToken = token; }
  public Token jjtGetLastToken() { return lastToken; }
  public void jjtSetLastToken(Token token) { this.lastToken = token; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return yal2jvmTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }


  public void process(BufferedWriter s){
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.process(s);
        }
      }
    }
  }

  public int getId() {
    return id;
  }

  public void setName(String name){
    this.name=name;
  }
  public void setValue(String value){
    this.value=Integer.parseInt(value);
  }

  public String getName(){
    return  this.name;
  }
  public String getSymbolTableName() {
    return yal2jvmTreeConstants.jjtNodeName[id]+ " " + this.name;
  }

  public SymbolTable getSymbolTable(){
    SymbolTable st =new SymbolTable(this.name);
    AbstractSymbol nt;
    st.enterScope();

    for(int i=0; i<children.length;i++){
      SimpleNode n = (SimpleNode)children[i];
            if(n instanceof ASTFunction){
            //get the table for the function
                nt = ((ASTFunction)n).getSymbol();
                st.addId(nt.getString(),nt);
                nt.print();
            }
            else if(n instanceof ASTDeclaration){
               nt = ((ASTDeclaration)n).getSymbol();
               st.addId(nt.getString(),nt);
               nt.print();
            }
    }
    return st;
  }
}


/* JavaCC - OriginalChecksum=ac0da302db6d74d4623f1efffa69f6a2 (do not edit this line) */
