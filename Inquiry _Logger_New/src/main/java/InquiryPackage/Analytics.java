package InquiryPackage;

import java.util.List;

public class Analytics {
    private InquiryPackage.Inquiry inquiry;
    private int inquiryCount;
    private List<InquiryPackage.Inquiry> inquiryList;

    public Analytics() {}
    public static double RatioInquiriesToEnrollment() { return 0;}
    public static double RatioContactMethods() { return 0;}
    public static double RatioInstruments() { return 0;}
    public static void display() {
        RatioInquiriesToEnrollment();
        RatioContactMethods();
        RatioInstruments();
        System.out.println("Analytics display method has been called");
    }
}

