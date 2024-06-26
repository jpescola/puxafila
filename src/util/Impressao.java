/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import model.Senha;

/**
 *
 * @author jpescola
 */
public abstract class Impressao {

    public static void imprimir(String s) {
        try {

            PrintService service = PrintServiceLookup.lookupDefaultPrintService();

            // prints the famous hello world! plus a form feed
            InputStream is = new ByteArrayInputStream(s.getBytes("UTF8"));

            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            pras.add(new Copies(1));

            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(is, flavor, null);
            DocPrintJob job = service.createPrintJob();

            job.print(doc, pras);
            is.close();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void imprimirSenha(Senha senha) {
        String s = ""
                + senha.getFila().getTipo().getNome() + "\n"
                + senha.getFila().getNome() + "\n"
                + senha.getFila().getPrefixoSenha() + senha.getNumero() + "\n";
        imprimir(s);
    }

}
