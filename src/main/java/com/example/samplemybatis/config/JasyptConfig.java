package com.example.samplemybatis.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    private static final String JASPYT_KEY = "CJON-cjolivenetwork-Workscan";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(JASPYT_KEY);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static String getEncrypt(String decryptValue){
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(JASPYT_KEY);
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        return standardPBEStringEncryptor.encrypt(decryptValue);
    }

    public static String getDecrypt(String encryptValue){
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(JASPYT_KEY);
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        return standardPBEStringEncryptor.decrypt(encryptValue);
    }

//	public static void main(String[] args) {
//		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
//		standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
//		standardPBEStringEncryptor.setPassword("CJON-cjolivenetwork-Workscan");
//
//		String url = standardPBEStringEncryptor.encrypt("testurl");
//		System.out.println("url = " + url);
//
//		String id = standardPBEStringEncryptor.encrypt("testid");
//		System.out.println("um = " + id);
//
//		String pw = standardPBEStringEncryptor.encrypt("testpw");
//		System.out.println("um = " + pw);
//
////		String des1 = standardPBEStringEncryptor.decrypt(url);
//		String des1 = standardPBEStringEncryptor.decrypt("lxi33hL7MAx71YGdrRLLLseKmjGIS841krKKi3PzzteEmTL5ZZSobft6/FnYFmqy55Gr+Fpn367Mb177hK9OSGjRZg1LuuzAYL8ZOce2StYtXKus8D4rqIGBx+OtYwTCY91F1nTNkJZt7Hz4ijxoniUTa3NT3f/T");
//		System.out.println("des = " + des1);
//
////		String des2 = standardPBEStringEncryptor.decrypt(id);
//		String des2 = standardPBEStringEncryptor.decrypt("OCu5kzIHQpnyg1n9nVxhZDHQWaTy2b6x");
//		System.out.println("des = " + des2);
//
////		String des3 = standardPBEStringEncryptor.decrypt(id);
//		String des3 = standardPBEStringEncryptor.decrypt("u53pB1aJUFi8sE1OzXA4ILMI7LCeOSmV");
//		System.out.println("des = " + des3);
//	}

}
