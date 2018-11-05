package id.tokoonderdil.study.springmvc.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private StrongPasswordEncryptor strongPasswordEncryptor;

    @Autowired
    public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
        this.strongPasswordEncryptor = strongPasswordEncryptor;
    }

    @Override
    public String encryptString(String string) {
        return strongPasswordEncryptor.encryptPassword(string);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongPasswordEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
