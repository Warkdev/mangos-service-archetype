#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public DAOException(String message) {
        super(message);
    }
}
