/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.mi.jdk;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.util.Enumeration;

import java.security.Security;
import java.security.Signature;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

/**
 *
 * @author Arlet
 */
public class PruebaMiJdk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
           
            //add at runtime the Bouncy Castle Provider
            //the provider is available only for this application
            Security.addProvider(new BouncyCastleProvider());
            
            //BC is the ID for the Bouncy Castle provider;
            if (Security.getProvider("BC") == null){
                System.out.println("Bouncy Castle provider is NOT available");
            }
            else{
                System.out.println("Bouncy Castle provider is available");
            }
            
            System.out.println("Curvas en el Bouncy Castle");
            Enumeration a = ECNamedCurveTable.getNames();
            while (a.hasMoreElements()) {
                String curvas2=a.nextElement().toString();
                System.out.println(curvas2);
            }
            
            try {
            String provider  = "BC";
            String algorithm = "EC";
            String[] curveNames = new String[] { "curva_1", "curva_2", "curva_3", "curva_4", "curva_5",
            "curva_6", "curva_7", "weierstrass_torcida_160"}; 
           
 
             KeyPairGenerator keyGen;
             ECGenParameterSpec ec;
             System.out.println(curveNames.length);
           for(int i = 0; i< curveNames.length; i++)
           {
               System.out.println(i);
               keyGen = KeyPairGenerator.getInstance(algorithm, provider);
               ec =new ECGenParameterSpec(curveNames[i]);
               System.out.println("Name " + ec.getName()); 
                 
               keyGen.initialize(new ECGenParameterSpec(curveNames[i]));
               KeyPair keyPair = keyGen.generateKeyPair();
               System.out.println("LLAVE PRIVADA    " + keyPair.getPrivate());
               System.out.println("LLAVE PUBLICA    " + keyPair.getPublic());
           }
           
          /* String curve = "brainpoolP160r1";
            
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm, provider);
             ECGenParameterSpec ec =new ECGenParameterSpec(curve);
            System.out.println("public " + ec.getName()); 
             
            keyGen.initialize(new ECGenParameterSpec(curve));
            KeyPair keyPair = keyGen.generateKeyPair();
            System.out.println("LLAVE PRIVADA   " + keyPair.getPrivate());
            System.out.println("LLAVE PUBLICA   " + keyPair.getPublic());
            
           */
            
           //System.out.println("public " + keyPair.getPublic());
           // System.out.println("private " + keyPair.getPrivate());
        } catch (Exception ex) {
            System.out.println("public ");
        }
        
    }
}

