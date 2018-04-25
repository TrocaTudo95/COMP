import java.io.PrintStream;
import java.util.ArrayList;


/** String table entry
 *
 * There are three kinds of string table entries:
 * <ul>
 *   <li>a true string,
 *   <li>a string representation of an identifier, and
 *   <li>a string representation of an integer.
 * </ul>
 *
 * Having separate tables is convenient for code generation.  Different
 * data definitions are generated for string constants (StringSymbol)
 * and integer constants (IntSymbol).  Identifiers (IdSymbol) don't
 * produce static data definitions.
 * <p>
 *
 * codeDef and codeRef (defined by subclasses) are used by the code to
 * produce definitions and references (respectively) to constants.
 *
 * @see AbstractTable
 * */

 class AbstractSymbol {

    /** The stored string */
    protected String str;
    protected dataType data_type;
    protected dataType return_type;
    protected int initial_value;
    protected int number_of_parameters;
    protected ArrayList<dataType> parameters;
    public SymbolTable children;


    public AbstractSymbol(String str,dataType data_type, dataType return_type,int initial_value,ArrayList<dataType> parameters) {
	     this.str = str;
       this.data_type=data_type;
       this.return_type=return_type;
       this.initial_value=initial_value;
       this.parameters=parameters;
    }

    /** Tests if the string argument is equal to the string in this symbol.
     *
     * @param str the string to compare
     * @return true if the strings are equal
     * */
  //   public boolean equalString(String str, int len) {
	// String other = str.length() == len ? str : str.substring(0, len);
	// return this.str.equals(other);
  //   }


    /** Tests if two symbols are equal.
     *
     * Symbol equality is equivalent to equality of their indecies, so it
     * is only meaningful to compare symbols that came from the same
     * string table.
     *
     * @param another the other symbol
     * @return true if the symbols are equal
     * */
  //   public boolean equals(Object another) {
	// return (another instanceof AbstractSymbol) &&
	//     ((AbstractSymbol)another).index == this.index;
  //   }

    /** Returns the string representation of this symbol. */
    public String getString() {
	return str;
    }

    /** Returns a printable representation of this symbol. */
    public String toString() {
	return str;
    }

}
