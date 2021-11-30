package InquiryPackage;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class SheetQuickstart {
    private static final SimpleDateFormat timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
    private static Sheets sheetService;
    private static final String APPLICATION_NAME = "Inquiries for Love Family Piano";
    private static final String spreadsheetId = "1SXO7520d4IK4NLgZ04KyGQEqk4Jl7l7tCQCdmclkVvI";
    //private static final String spreadsheetId = "1Tb698IkImSrjLX6dFPHUZVI3LlKFDIHPyisnep7nunQ";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static Credential authorize() throws IOException, GeneralSecurityException {
        InputStream in = SheetQuickstart.class.getResourceAsStream("/credentials.json");
        assert in != null;
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY, clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;
    }

    public static Sheets getSheetService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void sheetsRun() throws IOException, GeneralSecurityException {
        String time = new SimpleDateFormat("MM/dd/yyyy @ hh:mm:ss aa").format(new java.util.Date());
        String fName = "Aaron";
        String lName = "Allsup";
        String sName = "Adelaide";
        String email = "adallsup@byui.edu";
        String phone = "(801)400-6455";
        String Instruments = "Guitar, Piano";
        String cMethod = "Phone";
        String invited = "yes";
        String preview = "11/30/2021";
        String showedUp = "yes";
        String eInvite = "yes";
        String enrolled = "yes";
        String pMethod = "email";
        String notes = "Has multiple children that might enroll depending on experience with oldest child.";

        try {
            sheetService = getSheetService();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.security.GeneralSecurityException e) {
            e.printStackTrace();
        }

        ValueRange appendBody = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList(time, fName, lName, sName, email, phone, Instruments,
                                cMethod, invited, preview, showedUp, eInvite, enrolled,
                                pMethod, notes)
                ));
        AppendValuesResponse appendResult = sheetService.spreadsheets().values()
                .append(spreadsheetId, "sheet1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("Insert_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();





        String range = "Sheet1!A2:O2";

        ValueRange response = sheetService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found");
        } else {
            for (List row: values) {
                System.out.printf("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s", row.get(0), row.get(1), row.get(2),
                        row.get(3), row.get(4), row.get(5), row.get(6), row.get(7),row.get(8), row.get(9), row.get(10), row.get(11),
                        row.get(12), row.get(13), row.get(14));
            }
        }
    }
}