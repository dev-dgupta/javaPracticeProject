package enumsProb;

import java.util.List;

/**
 * Created by Divya.Gupta on 24-11-2016.
 */
public class EnumExample {



        enum BankTokens {

            f216e990e8b417c6a88159731f36f06a("Bajaj"),
            f216e990e8b417c6a88159731f33346a("ICICI");

            private String value;


            private BankTokens(String value) {
                this.value = value;
            }

            public String getValue() {
                return this.value;
            }



        }

    public static void main(String[] args) {

        String token = "f216e990e8b417c6a88159731f36f06a";
        BankTokens[] bankTokensList=BankTokens.values();

        for(int i=0;i<bankTokensList.length;i++){
            if(BankTokens.values()[i].name().equals(token))
                System.out.println(BankTokens.values()[i].getValue());
        }

    }
}
