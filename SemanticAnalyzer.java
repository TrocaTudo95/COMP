import java.util.ArrayList;

public class SemanticAnalyzer {
    //
    // public static boolean checkVarExists(SymbolTable t, String name){
    //
    //     if(! t.containsSymbol( name )){
    //         System.out.println("Semantic error - The variable "+name+ " was not declared;");
    //         return false;
    //     }
    //     return true;
    // }
    //
    // public static boolean checkVarArray(SymbolTable t, String name){
    //     if( ! t.getTypeOfSymbol(name).equals("Array")){
    //         System.out.println("Semantic error - The variable "+name+ " is not an array");
    //         return false;
    //     }
    //     return true;
    // }
    //
    // public static boolean checkVarInitialized(SymbolTable t, String name){
    //
    //     int init = t.getInitializationOfSymbol(name);
    //     if(init == -3){
    //         System.out.println("Semantic error - The variable "+name+ " is not initialized");
    //         return false;
    //     }
    //     return true;
    // }
    //
    //
    // public static boolean checkVarScalar(SymbolTable t, String name){
    //     if(!t.getTypeOfSymbol(name).equals("Scalar")){
    //         System.out.println("Semantic error - The variable "+name+ " is not a scalar");
    //         return false;
    //     }
    //     return true;
    // }
    //
    //
    //
    // /*
    //  * Validates a function call
    //  */
    // public static boolean validateFunction(SymbolTable t, SimpleNode nd){
    //
    //     ASTCall call = (ASTCall)nd;
    //     String call_name = call.getName();
    //
    //     ArrayList<String> names = t.mainTable.get(call_name).getParameters();
    //
    //     if(names==null){
    //         System.out.println("Semantic error - The function "+call_name+" does not exist");
    //         return false;
    //     }
    //     else{
    //         /* check the number of parameters */
    //         int nArgs=0;
    //         if( nd.children!=null ){
    //             SimpleNode ndd = (SimpleNode)nd.children[0];
    //             nArgs = ndd.children.length-1;
    //         }
    //         if(nArgs != names.size()){
    //             System.out.println("Semantic error - number of arguments");
    //             return false;
    //         }
    //         else if(nd.children!=null ) {
    //             SimpleNode ndd = (SimpleNode)nd.children[0];
    //
    //             for(int i = 0; i < nArgs; i++){
    //
    //                 boolean res=false;
    //
    //                 SimpleNode test = (SimpleNode) ndd.children[i];
    //
    //                 if( test instanceof ASTArgument ){
    //
    //                     if(! (checkVarExists(t, test.getName()) && checkVarInitialized(t, test.getName())) ) {
    //                         return false;
    //                     }
    //
    //                     String type = t.getTypeOfSymbol(test.getName());
    //                     res =  names.get(i).equals(type);
    //
    //                 }
    //
    //                 else if(test instanceof ASTArgumentInteger){
    //                     res = names.get(i).equals("Scalar");
    //                 }
    //
    //                 if(!res){
    //                     System.out.println("Semantic Error - Arguments do not match!");
    //                     return false;
    //                 }
    //             }
    //         }
    //         return true;
    //     }
    // }
    //
    //
    // /*
    //  * Checks if a comparison is valid
    //  */
    // public boolean comparison(SymbolTable t, Node[] children){
    //     SimpleNode n1 = (SimpleNode) children[0];
    //     String name = n1.getName();
    //     SimpleNode rhs = (SimpleNode) children[1];
    //     boolean ret = false;
    //     switch(n1.getClass().getName()){
    //         case "ASTArrayAccess":
    //             ret = checkVarExists(t, name) && checkVarArray(t,name);
    //
    //             SimpleNode nd = (SimpleNode)n1.children[0];
    //             if(nd instanceof ASTIndexID){
    //                 checkVarExists(t, nd.getName());
    //             }
    //             break;
    //
    //         case "ASTScalarAccess":
    //             ret = checkVarExists(t, name) && checkVarArray(t,name);
    //             break;
    //
    //         case "ASTSimpleAccess":
    //             ret = checkVarExists(t, name) && checkVarScalar(t,name) && checkVarInitialized(t,name);
    //             break;
    //     }
    //     /* validate assignment */
    //     SimpleNode aux = (SimpleNode)rhs.children[0];
    //     if(aux.children == null){
    //         ret = checkVarScalar(t,aux.getName()) && checkVarInitialized(t,aux.getName());
    //     }
    //     else{
    //         //TODO add the other options a < b.size a < b[3] a < b.call()
    //     }
    //     return ret;
    // }
    //
    //
    // public void compStructureAssignment(){
    //
    // }
    //
    //
    //
    //
    // /*
    //  *  Checks the assignment of a scalar
    //  */
    // public String nonIntegerAssignment(Node node, SymbolTable t){
    //
    //     SimpleNode nn = (SimpleNode)node;
    //     String name = nn.getName();
    //
    //     if(nn.children==null && checkVarExists(t, name) && checkVarInitialized(t,name)){   //a=N
    //
    //         if(t.getTypeOfSymbol(name).equals("Array")){
    //             return "Array";
    //         }
    //         else if( checkVarScalar(t, name) && checkVarInitialized(t,name)){
    //             return "Scalar";
    //         }
    //     }
    //
    //     else if(nn.children!=null){
    //
    //         SimpleNode nd = (SimpleNode)nn.children[0];
    //         name = nd.getName();
    //
    //         if(nd instanceof ASTArrayAccess ){  //a=N[x]
    //
    //             if(! ( checkVarExists(t, name) && checkVarInitialized(t, name) &&checkVarArray(t, name))) return null;
    //
    //             nd = (SimpleNode)nd.children[0];
    //             name = nd.getName();
    //
    //             if(nd instanceof ASTIndexID ){  //a=N[b]
    //
    //                 if( checkVarExists(t, name) && checkVarScalar(t, name)&& checkVarInitialized(t,name)){
    //                     return "Scalar";
    //                 }
    //                 else {
    //                     return null;
    //                 }
    //             }
    //
    //             else if(nd instanceof ASTIndexInteger){   //a=N[0]
    //                 return "Scalar";
    //             }
    //         }
    //
    //         else if(nd instanceof ASTScalarAccess ){ //a=N.size
    //
    //             if(! ( checkVarExists(t, name) && checkVarArray(t, name))) return null;
    //             return "Scalar";
    //         }
    //
    //         else if(nd instanceof ASTFunctionTermAccess){   //a=N.b()
    //             return "Scalar";
    //         }
    //
    //         else if(nd instanceof ASTCall){  //a=N()
    //
    //             if(validateFunction(t, nd)){
    //                 String type = t.getRetType(nd.getName());
    //                 if(type.equals("void")){
    //                     System.out.println("Semantic error - Assigning a variable to a void function");
    //                     return null;
    //                 }
    //                 return type;
    //             }
    //             else return null;
    //         }
    //     }
    //     return null;
    // }
}
