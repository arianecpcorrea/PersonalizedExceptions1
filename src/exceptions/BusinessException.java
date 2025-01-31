
//criar exceções específicas ajuda vc a dar tratamentos diferentes personalizados
package exceptions;

// BusinessException porque foi uma regra de negócio que foi infrigida

public class BusinessException extends RuntimeException {// aqui fiz a BusinessException herdar a
    // RuntimeException do Java

    // agora vou fazer um construtor para instanciar como String
    public BusinessException(String msg) {
        super(msg);// aqui usei o construtor da RuntimeException na classe Account
    }

}
