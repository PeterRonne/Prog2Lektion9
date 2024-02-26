package opgave01.models;

public class Vault<E> {
    private E secret;
    private String password;

    public Vault(E secret, String password) {
        this.secret = secret;
        this.password = password;
    }

    public E getSecret(String password) {
        if (this.password.equals(password)) {
            return secret;
        }
        else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
