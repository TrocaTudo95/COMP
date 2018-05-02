import java.util.ArrayList;

public class SemanticAnalyzer {


    public static boolean checkVarArray(SymbolTable t, String name, String func_name){
        if( ! t.getTypeVariable(func_name, name).equals("ARRAY")){
            System.out.println("Semantic error - The variable "+name+ " is not an array");
            return false;
        }
        return true;
    }


    public static boolean checkVarInitialized(SymbolTable t, String name, String func_name){

        int init = t.getInitializationOfSymbol(func_name, name);
        if(init == -3){
            System.out.println("Semantic error - The variable "+name+ " is not initialized");
            return false;
        }
        return true;
    }


    public static boolean checkVarExists(SymbolTable t, String name, String func_name,int line){
      int result;
         result=t.checkVarExists( name,func_name,line);
         if(result==0){
            System.out.println("Semantic error - The variable "+name+ " was not declared;");
            return false;
        }
        if(result==2){
           System.out.println("Semantic error - The variable "+name+ " was not declared before being used;");
           return false;
       }
        return true;
    }



    public static boolean checkVarScalar(SymbolTable t, String name, String func_name){
        if(!t.getTypeVariable(func_name,name).equals("INT")){
            System.out.println("Semantic error - The variable "+name+ " is not a scalar");
            return false;
        }
        return true;
    }



    /*
     * Validates a function call
     */
    public static boolean validateFunction(SymbolTable t, SimpleNode nd)throws ParseException{

        String call_name = nd.getName();
        ASTArgumentList call;
        //TODO funcoes nao feitas por mim
        //if(nd.jjtGetNumChildren()==0)

         call = (ASTArgumentList)nd.jjtGetChild(0);
         String err;
         int i_err=-798;



        ArrayList<String> names = t.mainTable.get(call_name).getParameters();
        ArrayList<String> types=  t.mainTable.get(call_name).getTypes();

        if(names==null){
          err="Semantic error - The function "+call_name+" does not exist";
          yal2jvm.error_skipto(i_err,err);
            //System.out.println("Semantic error - The function "+call_name+" does not exist");
            return false;
        }
        else{
            /* check the number of parameters */
            int nArgs=0;
            if( call.jjtGetNumChildren()!=0 ){

                nArgs = call.jjtGetNumChildren();
            }
            if(nArgs != names.size()){
              err="Semantic error - number of arguments in function "+call_name;
                yal2jvm.error_skipto(i_err,err);
                return false;
            }
            else if(call.jjtGetNumChildren()!=0) {


                for(int i = 0; i < nArgs; i++){

                    boolean res=false;

                    SimpleNode test = (SimpleNode)call.jjtGetChild(i);

                    if( test instanceof ASTArgument ){
                        //check if variable exists
                        if(! checkVarExists(t, test.getName(), test.getFuncName(),test.getToken().beginLine )) {
                            return false;
                        }

                        String type = t.getTypeVariable(test.getFuncName(),test.getName());
                        err="the type is: "+ type+" and it should be: "+types.get(i);
                          yal2jvm.error_skipto(i_err,err);
                        res =  types.get(i).equals(type);

                    }


                    if(!res){
                      int h=i+1;
                      err="Semantic Error - Argument "+test.getName()+" do not match with the "+h +"º argument of the function " +call_name;
                         yal2jvm.error_skipto(i_err,err);
                        return false;
                    }
                }
            }
            return true;
        }
    }




    /*
     * Checks if a comparison is valid
     */
    public boolean comparison(SymbolTable t, Node[] children){
        SimpleNode n1 = (SimpleNode) children[0];
        String name = n1.getName();
        String func_name = n1.getFuncName();
        int line = n1.getToken().beginLine;
        SimpleNode rhs = (SimpleNode) children[1];
        boolean ret = false;
        switch(n1.getClass().getName()){
            case "ASTArrayAccess":
                ret = checkVarExists(t, name, func_name,line) && checkVarArray(t,name, func_name);

                SimpleNode nd = (SimpleNode)n1.children[0];
                if(nd instanceof ASTIndex){
                    checkVarExists(t, nd.getName(), nd.getFuncName(), nd.getToken().beginLine);
                }
                break;

            case "ASTScalarAccess":
                ret = checkVarExists(t, name, func_name, line) && checkVarArray(t,name,func_name);
                break;

            case "ASTSimpleAccess":
                ret = checkVarExists(t, name, func_name, line) && checkVarScalar(t,name, func_name) && checkVarInitialized(t,name, func_name);
                break;
        }
        /* validate assignment */
        SimpleNode aux = (SimpleNode)rhs.children[0];
        if(aux.children == null){
            ret = checkVarScalar(t,aux.getName(), aux.getFuncName()) && checkVarInitialized(t,aux.getName(), aux.getFuncName());
        }
        else{
            //TODO add the other options a < b.size a < b[3] a < b.call()
        }
        return ret;
    }


    public void compStructureAssignment(){

    }




    /*
     *  Checks the assignment of a scalar
     */
    public String nonIntegerAssignment(Node node, SymbolTable t){

        SimpleNode nn = (SimpleNode)node;
        String name = nn.getName();
        String func_name = nn.getFuncName();
        int line = nn.getToken().beginLine;

        if(nn.children==null && checkVarExists(t, name, func_name, line) && checkVarInitialized(t,name, func_name)){   //a=N

            if(t.getTypeVariable(func_name, name).equals("ARRAY")){
                return "Array";
            }
            else if( checkVarScalar(t, name, func_name) && checkVarInitialized(t,name, func_name)){
                return "Scalar";
            }
        }

        else if(nn.children!=null){

            SimpleNode nd = (SimpleNode)nn.children[0];
            name = nd.getName();
            func_name = nd.getFuncName();
            line = nd.getToken().beginLine;

            if(nd instanceof ASTArrayAccess ){  //a=N[x]

                if(! ( checkVarExists(t, name, func_name, line) && checkVarInitialized(t, name, func_name) &&checkVarArray(t, name, func_name))) return null;

                nd = (SimpleNode)nd.children[0];
                name = nd.getName();
                func_name = nd.getFuncName();
                line = nd.getToken().beginLine;

                if(nd instanceof ASTIndex ){  //a=N[b]

                    if( checkVarExists(t, name, func_name, line) && checkVarScalar(t, name, func_name)&& checkVarInitialized(t,name, func_name)){
                        return "Scalar";
                    }
                    else {
                        return null;
                    }
                }

                else if(nd instanceof ASTArraySize){   //a=N[0]
                    return "Scalar";
                }
            }

            else if(nd instanceof ASTScalarAccess ){ //a=N.size

                if(! ( checkVarExists(t, name, func_name, line) && checkVarArray(t, name, func_name))) return null;
                return "Scalar";
            }

            else if(nd instanceof ASTFunction){   //a=N.b()
                return "Scalar";
            }

            else if(nd instanceof ASTCall){  //a=N()

                try{
                  if(validateFunction(t, nd)){
                      String type = t.getRetType(nd.getName());
                      if(type.equals("void")){
                          System.out.println("Semantic error - Assigning a variable to a void function");
                          return null;
                      }
                      return type;
                  }
                }
                catch(Exception e){
                  return null;
                }
            }
        }
        return null;
    }
}
