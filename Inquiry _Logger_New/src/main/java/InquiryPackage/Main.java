package InquiryPackage;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) {
        InquiryPackage.GUI pro = new InquiryPackage.GUI();
        pro.run();
        SheetQuickstart quickstart = new SheetQuickstart();
        try {
            quickstart.sheetsRun();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
