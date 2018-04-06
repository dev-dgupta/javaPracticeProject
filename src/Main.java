//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        String a = "343,232,453,231,";
//        a = (',' == a.charAt(a.length() - 1)) ? (a.substring(0, a.length() - 1)).trim() : a;
//        System.out.println(a);

//        String name = "name: "+"\"" + a + "\"";
//        System.out.println(name);

//        String a="54,56,544";
//        System.out.println(a.replace(",",""));
//
//        a="678";
//        System.out.println(a.replace(",",""));
//
//        a="";
//        System.out.println(a.replace(",",""));
//
//        a=null;
//        System.out.println(a.replace(",",""));
//
//        String content="\n" +
//                "{\n" +
//                "   \"html_attributions\" : [],\n" +
//                "   \"next_page_token\" : \"CpQCBQEAAJ24A_1nUNl1izQLcRuztscBHjsaO4CbUAp5BytKpRU1Jj0PF1uU-pmyAJWuECcqZ7Cn68cHxrKhLYi0ni6DcML6bCqU9DrZk57oHvzcXO-K3Hx0nywmvL6KS5ct-4G6dfqNoPozQXVDBtsCk6CThR52y9AR0_3lckSJWiVOBDQFwS1slKuHxuPgoXJ03bbYKhdMoVRw0hTPhTGiEAuROHkVsD0aOf_07qIoR5ZMQtV4qek-eHpoDbAUiv3tbo3eHh6efYfTxMI557T1rxH0OdqUb1s_szoQkMT06X6IHLOafy3q_ANbEsLLKlgkgoMIXsk0lWqZ1nyP2p1kToVnOtvXrrZdXDbUBX6FOCnbVwLTEhDWpAc27vK-pKXKk6sAknzdGhT01aw7ObVKW5gEdxUrQQnDMXCLuA\",\n" +
//                "   \"results\" : [\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0278812,\n" +
//                "               \"lng\" : 72.5319337\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0292301802915,\n" +
//                "                  \"lng\" : 72.53328268029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0265322197085,\n" +
//                "                  \"lng\" : 72.5305847197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"d44be3db035f5d553d6ffbea4ae7add49872c68e\",\n" +
//                "         \"name\" : \"Ahmedabad Heart Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJoQOCCs-EXjkRkqewknzvJV4\",\n" +
//                "         \"rating\" : 3,\n" +
//                "         \"reference\" : \"CmRRAAAAFeCoTZjDl8BY9dZshLiArFV_bI54d9Ges1O2z03sSQbSFkMq_iLk4G8GVofviSsLd9R14kgoJzRGfeMWMXMol-1NSKe7ZFYc6pHlQX6h7URs96QMiAScwcMd9LdWA5hkEhC4nOPodmKXIoylp2OM42u8GhSJMuXR3cW8XAETdM1qATVS4u2mcg\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"404,4th Floor, Asopalav House, Opp. Keshav Baug Party Plot,, 132 Feet Ring Road, Satellite,, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0504017,\n" +
//                "               \"lng\" : 72.51889109999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.05175068029151,\n" +
//                "                  \"lng\" : 72.5202400802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0490527197085,\n" +
//                "                  \"lng\" : 72.51754211970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"c25b3340308eaa67807a70c52607b715720ef05c\",\n" +
//                "         \"name\" : \"Vasant Nature Cure Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJ64JEZ1ObXjkRX29lxJp-wWE\",\n" +
//                "         \"rating\" : 4.2,\n" +
//                "         \"reference\" : \"CmRRAAAAXHYfqdG97-0Yb-G0_8VMuEAq1KK9EE_j23lbvhvenLkcDsn9coK8Icp4e3MtDlw4jMJOWZEtzpmdeZVvj3KwTCJKbcPYVZoOlJQ3VvI6MWQfMTmtUVshzwKP5qqT0m22EhCl1qOkJ8iW3MDe8D060wnbGhS_KYoUiuhQr2J6BvoXNl-onhBi5A\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Drive In Road, Thaltej Tekra, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.048659,\n" +
//                "               \"lng\" : 72.531109\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0500483802915,\n" +
//                "                  \"lng\" : 72.53265358029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0473504197085,\n" +
//                "                  \"lng\" : 72.5299556197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"bad6462ed8da973891661ae0781ba176ece49ce5\",\n" +
//                "         \"name\" : \"Sterling Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 3120,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115861285886111116111/photos\\\"\\u003ekeval rathod\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAgCm9s8zghg5-Ma4-mk2dRH22GngHIuyazYqMD0iKFb-wbP1IzxESyyw9pl0aMk0fkabsNctBGICZZ0cr9QR_YwI_Y-fFbVjdNpu5SLJsPVvaABvRrr3yJdMFNfPWIXBTEhCcGf1ZPD7emEWLSjOk1kHaGhRdmpmW20TqwDmkorg-eUCgz_-q7g\",\n" +
//                "               \"width\" : 4160\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJWUmAvK-EXjkRd39Yujfy1hs\",\n" +
//                "         \"rating\" : 3.5,\n" +
//                "         \"reference\" : \"CmRRAAAAdbckcTQ0NVai7mOt5ub3Y8jtX8z-_1E1cyHz5bNNn9MNw4nN-hEY5QEYBuAD7SFX6K3e6vyeY0T60uyO7rzJcVWjzPllRWK9kD2CpbV77_qwlXBLChrAAVrCIInEFfqwEhCFRHkRpUMpmfak5hzxtM8KGhQnOoHmm0cpJTDHtGtroMHGNqzgUw\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Sterling Hospital Road, Near Maharaja Agrasen Vidhyalaya,, Nr. Nilmani Society, Memnagar, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.038037,\n" +
//                "               \"lng\" : 72.51392199999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0393859802915,\n" +
//                "                  \"lng\" : 72.5152709802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0366880197085,\n" +
//                "                  \"lng\" : 72.51257301970848\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
//                "         \"id\" : \"de5f6752856d2d2a9310da159c1f1dc161af73bd\",\n" +
//                "         \"name\" : \"dr bharat agravat best dentist dental clinic\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : false,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 1365,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106907937961718143135/photos\\\"\\u003edr bharat agravat best dentist dental clinic\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRZAAAAeEajF4Yu327xfj7yNgTbA4OLagD9yS5GgRfOvHhgf2uDfUVx2EYIR9ejzl-QFC8qe5_YakaQRn6YiM6I1IjdOnP9F-BDb5gKciz2TguJS7hcL1HXtvmINa1wOBULSXGOEhAkzIPJ2ne4PS9zRUIhmFEGGhQ2ocAcDK59RP4nwUllvXnrxSPZYQ\",\n" +
//                "               \"width\" : 1364\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJ2zc-UEmbXjkRcfHdFeZQxKM\",\n" +
//                "         \"rating\" : 4.7,\n" +
//                "         \"reference\" : \"CmRSAAAAeM_cpwVqqlQWsuFNaSjXwfch99YxEqeF5wMvxF67JgoFJPV1teA2QbEAUSDA20sycN_EORvdSldigJXU9v61dq1VbEa8mo5A29PDSbNJ3jN7m5LZUBBqvY-2jxcbdALoEhDPBjzKPBRVa5nngIM5tSnIGhQ3XXAu0dsrQK971QqPR0kVk8jUGg\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [\n" +
//                "            \"dentist\",\n" +
//                "            \"hospital\",\n" +
//                "            \"doctor\",\n" +
//                "            \"health\",\n" +
//                "            \"point_of_interest\",\n" +
//                "            \"establishment\"\n" +
//                "         ],\n" +
//                "         \"vicinity\" : \"Cross Street\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0420819,\n" +
//                "               \"lng\" : 72.5308697\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0434308802915,\n" +
//                "                  \"lng\" : 72.53221868029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0407329197085,\n" +
//                "                  \"lng\" : 72.5295207197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
//                "         \"id\" : \"fd68faa9eac8181fa25e0c47c384e64be133cd5c\",\n" +
//                "         \"name\" : \"Apollo Clinic\",\n" +
//                "         \"place_id\" : \"ChIJq6qq6rCEXjkRELwD3JKTGXo\",\n" +
//                "         \"reference\" : \"CmRRAAAAY_rVsEoOk87cABzQgA9cWbxLbhhVWiPmSGhfHM1PY3w2twYhdHZAdQN3uZqnu8oOy8gvm5vmJv5FNee05rwsAaDkxn8bGnJxBTxs2gL5IZIQ728Bbv8FEVvsd43_wd6iEhDnEa-d1RcD0J5DMlXFTdTJGhTy0j_YlJ6qpdj-HEmbipk-FoneFg\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"A-801, Shakamba Tower, Gurukul, Near Gurukul, Gurukul, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.049397,\n" +
//                "               \"lng\" : 72.524334\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0507459802915,\n" +
//                "                  \"lng\" : 72.52568298029149\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0480480197085,\n" +
//                "                  \"lng\" : 72.52298501970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
//                "         \"id\" : \"4f192cba2236caeb56ba4d21e9496b8393d163b9\",\n" +
//                "         \"name\" : \"Dr.Keyur Panchal\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 513,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/112530380378979097935/photos\\\"\\u003eDr.Keyur Panchal\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAAEOExcD7v-h4F3YjofCcUlNEPWFLeI8uQa_69LMIkq-zS8jVJa1nTryfdk_DOYYL5E5xzNzp7kD0nO30Lo_wTAi_K8a-N_z5No-JVR_n2W-d1w5kOGehpJJ9lIKLj6reEhCd_waVKDj6AQ89zfgHTjxxGhTMuT6LCQ8rIcNYEL1V6WAI9zqxfQ\",\n" +
//                "               \"width\" : 1026\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJM4VRRayEXjkReS9O5xiVpUU\",\n" +
//                "         \"rating\" : 4.5,\n" +
//                "         \"reference\" : \"CmRRAAAAr31HfTYWvTdVOiwZE-Css19hTbJSNuFUrh0sch9NXdiyXBY_9N8MRRQgvLX6MeEROaFxqoUCBrqPklkJLJlTqF7MpJT2cphE3mblVzJGhwAegxr8Ld_jVIE6GpjoYwS1EhCPsYHPfCgzhz-1qjr77UzoGhQX08D9uJQckmkhAkqx0fN5qndp4A\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"First Floor, OPD Wing, SAL Hospital, Opp.Doordarshan Tower, Drive-in road, Thaltej, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.040212,\n" +
//                "               \"lng\" : 72.52821299999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0415609802915,\n" +
//                "                  \"lng\" : 72.5295619802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0388630197085,\n" +
//                "                  \"lng\" : 72.5268640197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"e18de4fb64f8e0e13f155d0ef2db25dee87ae531\",\n" +
//                "         \"name\" : \"Sanjivani Super Speciality Hospitals\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 1365,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109657955408684076304/photos\\\"\\u003eSanjivani Super Speciality Hospitals\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAdEX86rwxcTT7ksmDvq9DJ_csrNwS-Gtx5lMd5zrHCssJhFIS71hmBdcDLNMzcerGGkez7SItM_pZKt83NrcuixSE0wdHoMxDMDK49PF-2zh-TrrYE6G-Rn0SUTdSm7dlEhBu57OOViXZiwu1wZ3_NaEFGhTdpT2PlB3hiom2eLVhPpLEg6pQhw\",\n" +
//                "               \"width\" : 2048\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJd8gpy7eEXjkRiVXtR_A6E8c\",\n" +
//                "         \"rating\" : 3.7,\n" +
//                "         \"reference\" : \"CmRSAAAARBKnvIZRVBRUKpeASmoasiHUNrYmRtrcrLdgeMXtx7ciXGEaRWzQzIiOX0lu9w7j5f5SkQlQdot_4L8nq7N--M23mj4vDQU5RrULqQb2XmWJI4TRJkjUutoBnGvYTKApEhAdwN96-Kcnd5GE9nW2QHz4GhRXjQ4r1zqqGK5nB69JTUXqbU4P2A\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"1, Uday Park Society, Near Sunrise Park, Vastrapur, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.035978,\n" +
//                "               \"lng\" : 72.517516\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0373269802915,\n" +
//                "                  \"lng\" : 72.51886498029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0346290197085,\n" +
//                "                  \"lng\" : 72.5161670197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"d33e5d65c7efedb1371422493beb192b3d7a1f7e\",\n" +
//                "         \"name\" : \"Raksha Hospital\",\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 600,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109624651372312369209/photos\\\"\\u003eJack Whisk\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAiSHUitqky2cNvCKXcQUASRQULF4kBGT6qv4gnSlpCQj0u3l_ikcwo5uybKxTbdaFiMP0TIUwEkQ_-Qk1Xs0DaUzDe2Icxdtzu1FVOsFt7mh4nulGOm8uNXtH_GtGr6NjEhByO_5xLGd-R6Y6AwhP1KI3GhTdkgVsjqIEyNKokxQtCA8HVBgBZg\",\n" +
//                "               \"width\" : 800\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJGdj0VUqbXjkR9S0hPjNjGyg\",\n" +
//                "         \"rating\" : 4.3,\n" +
//                "         \"reference\" : \"CmRRAAAATooojRalUUlFmpWpeVls_Oj7KPsyJV_pw1wJFNdHELHke3jpGEVdV-yENGPhFYiTSvv3r0WXKd4rXP0jFE8Fx8_gpOzNdkoeq34jXBz_bsLR-gtvWO2QwHKtVu3UPfS-EhCbXmLWCTlawCVRJLMlhfbEGhRXUqXZ7zf8CjdO9vYt1y-U3-7sVQ\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"2 & 3rd Floor, Polyclinic Centre, Bodakdev, Opposite Judges Bunglow Bus Stand, Bodakdev, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.046643,\n" +
//                "               \"lng\" : 72.532478\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0479797302915,\n" +
//                "                  \"lng\" : 72.53434228029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0452817697085,\n" +
//                "                  \"lng\" : 72.53164431970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"66017233df3ca3728ee74368e6d96cfbd276a836\",\n" +
//                "         \"name\" : \"Iladevi Cataract & IOL Research Centre\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : false,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 2624,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/117492193120789757082/photos\\\"\\u003eKaid Johar Rampurpadediwala\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAJbcLHVcJd3uusyNKvo-7Vnnu3OIx59wNxTzukEdUzFJUaJOhsjzEZIc2EHSmnSRgiu34UmugCYsIdboBGXnSztRupB-vyD4XlI9x_tuOMuEJgDQrCRv2KDoTgShWi9a8EhD-2V5Uc1Tqjeki273Ut23NGhT75BdrD2J006IM5siUCKZHA_4qyg\",\n" +
//                "               \"width\" : 3916\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJj995VaWEXjkRSe8y_Itied4\",\n" +
//                "         \"rating\" : 5,\n" +
//                "         \"reference\" : \"CmRSAAAA2rvHV2Cy57jfMOjoVJRZlo7cLkOt3_VeSbSGbemQ2hwyM-tD71jnV_sliyMQ6nJN6d9HHba-ge5jY46xhTVHOXUFzxu6glRHkNV3cqRg-BGyB4t674BvarQKgZiWejolEhCFJPEAr92h15WkNtWi9BKnGhT3gqDYlbfqb3JsNiWHUrhrxcPs6Q\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Near Shreeji Complex, Gurukul Road, Memnagar, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.057983,\n" +
//                "               \"lng\" : 72.51248199999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0595882802915,\n" +
//                "                  \"lng\" : 72.51378313029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0568903197085,\n" +
//                "                  \"lng\" : 72.51108516970851\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"f12d2412a1d41480785a38f47e1bf981e88f5e5e\",\n" +
//                "         \"name\" : \"Columbia Asia Hospital - Ahmedabad\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 3058,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/115163757239721164521/photos\\\"\\u003eSrinivas Menon\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAJK8JYk6SrNcCN7qeM8wICDbHQZXDQzkQrajrgJ_R2qffmpVI0av9-6nSk_oa_HA3S8_-me_mAZo1eYVFn7ak0bWMcOFrpAo_MCxLruSMJj3tqtVuPgFRqclwkBsVcUy8EhAxcN0FeEp6oHpqk1kO6LYJGhQtX_0zqsL1Uq3DTDjXoRXezp0Cyg\",\n" +
//                "               \"width\" : 6008\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJ0yAypamcXjkRyJDK7aVeWLk\",\n" +
//                "         \"rating\" : 3.6,\n" +
//                "         \"reference\" : \"CmRSAAAAGy_HxZdCSnuZowRlhSIiL9w1DN7xL-1oNt1MTEQtqWyxa4k9Wrnp20XtjTtwLLiXKzPgZ2E6Y2bF43HlSFed1zZpo55Az3DjwlpWGCvuxqa6fMYcERP7EzCi66fP7M6rEhCK5HvrN0HU3y_w5ohtGtS5GhTsTRrveW4I-LTDTktlzLiKZGsUuw\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Plot No. 221/222, Hebatpur Road, Off S G Highway, Thaltej, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.03545,\n" +
//                "               \"lng\" : 72.52717\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0367989802915,\n" +
//                "                  \"lng\" : 72.52851898029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.03410101970849,\n" +
//                "                  \"lng\" : 72.52582101970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"b9e99dd129ccb7a7fb78074cc5de9957de8a5bd3\",\n" +
//                "         \"name\" : \"Parth Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 3264,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114002079779951877111/photos\\\"\\u003eBhavenkumar Bhankhariya\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAxbns3rV7YLSf_n7fM2hZmS4zjuqNM9JMi3t9b-2EhuR_RMv1laFy4JcEmCeB6Z5PK-yTHIA6bupBgwsUPPw5_IzxQQ2P4Gi2eKM75ES3EHzniiV_fr2j6ctEIODrTtFgEhC2IhsHeN3S5ZJV5A46wo9JGhRmnmMGCVysoSAxB4cB_MzQOdqGxw\",\n" +
//                "               \"width\" : 2448\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJ07iAdraEXjkR8D0HhpgrSGY\",\n" +
//                "         \"rating\" : 3.9,\n" +
//                "         \"reference\" : \"CmRRAAAAcQ5drYji_Byh5IYhaDMFShLTI8Mu81pDnGaST8io-wSzm1l5upganPFIQ3phG7EsAGtSggVNKeqZ6dmEOXPBkhuR93jLJ6lLjyQ6KN3ItsFqHZmhI9chBs6VONUdE4P6EhDIdjxYLBf6W9gF8ztWUEGqGhSoQL0wKinGRqDCgJiC-94EqOYd3w\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"3rd floor sigma excellence, near reagency tower, Vastrapur, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0363385,\n" +
//                "               \"lng\" : 72.52776659999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0376909302915,\n" +
//                "                  \"lng\" : 72.5290278302915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.03499296970849,\n" +
//                "                  \"lng\" : 72.52632986970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"d05f1f388b188483b7264ebbb8a35113abd5a2b3\",\n" +
//                "         \"name\" : \"Krishna Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : false,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJO41-X7aEXjkRbzA40azA9PI\",\n" +
//                "         \"rating\" : 4.1,\n" +
//                "         \"reference\" : \"CmRSAAAALiYWFHJYsMk3sUOASNo_zVLYlS6iguQxD44r_i3F3z_72nhSKgbwElmGB3XIMbabaZ3ck9YENq9ylD_vmpBXd6VTFD-VvAte0_8-u2wPJJLSfrklYE6eSl43DlpZm4moEhApmC587DmvWodlfOv8Y6ISGhSShl7SCrjTlVi5VxBKCCCYHA0Qjw\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Kismat Complex, Nehru Park, Sargam Marg, Mahavir Nagar society, Vastrapur, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0354324,\n" +
//                "               \"lng\" : 72.5164577\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0367813802915,\n" +
//                "                  \"lng\" : 72.5178066802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0340834197085,\n" +
//                "                  \"lng\" : 72.51510871970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"142240bd94be61e1097d3fb983b0da400a1336f1\",\n" +
//                "         \"name\" : \"Dr. Rahul Muchhadia\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 695,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/118122589043938558736/photos\\\"\\u003eDr. Rahul Muchhadia\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAEQ6XzHkQk358tu6bfT0DB-ChAL2E-pnpkIhSQZsmxIH75Fstanv2Vmz0cDa7qcMSdOTS_6_3gRXLkxrKSK9RkAlysKgn8zrlJKcx6Jxwi2K9IfOkrX2BQOOVGe01wHe-EhB6FFIm71P4BwdW54x4xKyeGhQ3aUZfIb3mbdloAif7pl-tIpZg4A\",\n" +
//                "               \"width\" : 1729\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJ02NQT0qbXjkRgs59FdPFHs0\",\n" +
//                "         \"rating\" : 5,\n" +
//                "         \"reference\" : \"CmRSAAAAOaGqhSQW1O2ZsI2WdrHC4ksw7KUxc1qY7pfVq-hdBWBudhNqHWGXAKk1A2T8bqnpw_MpVyAE3G29qNKNA1moGEkiblMA7po2hD1bElsVxdGYJkKWrKzsJBPKZsY5s28qEhB8HeY1ximYHoMd2HtVHg-7GhQFrJ3WecQxRg5kdBZWP9MlGMAHOg\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"dentist\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"primate, Satellite, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.051026,\n" +
//                "               \"lng\" : 72.518563\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0523749802915,\n" +
//                "                  \"lng\" : 72.5199119802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0496770197085,\n" +
//                "                  \"lng\" : 72.51721401970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
//                "         \"id\" : \"94c4989823c8c2ad359f61805a701467eacf8cd0\",\n" +
//                "         \"name\" : \"QED Clinical Services\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJF-QVnFSbXjkRn2Air7v-d9w\",\n" +
//                "         \"reference\" : \"CmRSAAAAnPHzXuYLPeozgUTyrbAFEMdHCySWSnJJk1Q_62ZLaNKv76uFsI7o1R_iqu6jVIDoKsOgaK8y3nzKNFx56AfifPgXWTVoVPNk2PNc6WdqidVVmJPJbTfNrFeNvrekA0gmEhCkWJ9Pq_2NXD6eaGBr1P46GhTR55y8ddfE7zrm43AhXfvflmMswQ\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Titanium Square, Patel Society, Jai Ambe Nagar, Thaltej, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0240529,\n" +
//                "               \"lng\" : 72.5297836\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0254018802915,\n" +
//                "                  \"lng\" : 72.5311325802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.02270391970849,\n" +
//                "                  \"lng\" : 72.52843461970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"7d94fe18c5b1011b9d57c817c0e53ba612cb6690\",\n" +
//                "         \"name\" : \"Shanti Multi Speclaity Hospital\",\n" +
//                "         \"place_id\" : \"ChIJoQOCCs-EXjkRrbMf4wGiCF8\",\n" +
//                "         \"reference\" : \"CmRRAAAAphccq-3CsMADyB_4OLBjCsXvbV1Xkx4OFyro-evRsSqbErdFpe0j37G76WBdv1KBxcqy2cA-_zVgUGd5HQcH0inG_dk-SK11tucf5_QpBwTNAyIzCISjuo9tDgzikHWfEhBR1cxQDxx_6ERj6ubPfxIMGhSbLx6REt7DPy-xRcti9YXAxgfNuA\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"402, Iscon Centre, 4th Floor Shivranjani Char Rasta, 132 Feet Ring Road, Satellite, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0540029,\n" +
//                "               \"lng\" : 72.52373829999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.05535188029151,\n" +
//                "                  \"lng\" : 72.5250872802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0526539197085,\n" +
//                "                  \"lng\" : 72.52238931970849\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"c0f2ece8bb269dd00c5708fccac96c29ee0eec57\",\n" +
//                "         \"name\" : \"Amin's Hospital For Women\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : false,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 2448,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/116967499855813882644/photos\\\"\\u003eAshley Moras\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAdSfSo4z7s8O8xBfD54jsg70qDhHwVWfze0g6Q4n4QwX9g0H2ng6Wya8oLWR4bEBBjwJ0UsMCTqyVZowIZbTYIbVcdLAmgjXEU2as5HnCL8MRYZZep4RMRZaDoGp4YaIAEhDk2Dj3uEiGYAXcA-CMq5woGhRXfBQEaVpYzvnjbwC8YaiPT898zg\",\n" +
//                "               \"width\" : 3264\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJgxVE1rGcXjkRUQj8pGsu52M\",\n" +
//                "         \"rating\" : 4.6,\n" +
//                "         \"reference\" : \"CmRRAAAAsimefomQ3gPRc2EhLIN68owVMgWNiUTa1c9KXtK-sEOA6fBU_7WdwjzZdsKtTlY76FIcGllSMaUXnTGFCdpT0YfWL_ZH4XoWjpfOu-B6F7NAikxq1QQ_nDT51jGIIeaqEhAVXO_MefVrsyphshPzTG0FGhTWoFjd24hrzFSNsY7HhaWry3fb6w\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"17, Manipushpa Society, Thaltej, Opposite Sarthi II Raw House, Thaltej, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.046142,\n" +
//                "               \"lng\" : 72.533762\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0473739802915,\n" +
//                "                  \"lng\" : 72.5351126802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0446760197085,\n" +
//                "                  \"lng\" : 72.53241471970848\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
//                "         \"id\" : \"dd9bbc813565c3997bbccc0cc852e3a56c52253d\",\n" +
//                "         \"name\" : \"Rushabh Uro Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : false,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJR4EU3ayEXjkR2o9bkopwhVU\",\n" +
//                "         \"rating\" : 5,\n" +
//                "         \"reference\" : \"CmRRAAAAJ4rP-V1SXcWKKhQSfMnQxSztYBGHSqJKY3Orcc7_VLWhsxpeyl1PSeF1v97N9uvaiRiLUC7ageMPm5FvN9jnQAqQmGBM55agEQjMx4MTByWUu3e1-cn-2e9g5uiHH02SEhBVghitAX8qwexaeGX2QoVmGhQ-jkagi-EUmY1Rhf0_SOXEzdX2mg\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"2nd Floor, Heritage Plaza, Opp. Gurukul Tower, Drive In Road, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.046655,\n" +
//                "               \"lng\" : 72.53246799999999\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0480039802915,\n" +
//                "                  \"lng\" : 72.5338169802915\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0453060197085,\n" +
//                "                  \"lng\" : 72.53111901970848\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"900fda02b9af49e212ee858cfce52818a8f9348d\",\n" +
//                "         \"name\" : \"Raghudeep Eye Hospital\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 725,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/117038957019600178197/photos\\\"\\u003eRaghudeep Eye Hospital\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAbQ1f6yRPYfGRrxIrhkItVc79iwNWilHFimT2TeiyER1e6_rxWltJYzarfE0EYl_jSBXVYtyskq3lu38W2WimPjWcoa0XODk8hH9GOIHBEyMNT3U1yXEc78Do0qIabyIjEhAChK05RbGvhEzDVMg__m8TGhS1R7UWrFUt3CRza7EheYDv6xHycg\",\n" +
//                "               \"width\" : 1957\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJS5BCEaSEXjkReBy_a3Tm5UI\",\n" +
//                "         \"rating\" : 4.5,\n" +
//                "         \"reference\" : \"CmRRAAAAYDcQZKczOCvQDRcEy5lUNvFbJH2ni-ihRval68cRUfXgi_8srVLbUf9uFQVHMHCLj9cn746aEU6md8_riPrO3HgoyRM627Qus3LadONt3cjT5pkb3JzjFO6u3776VpJ6EhCHDN5wKgswvasGJZdo2VsRGhTcfJ0t9CNp7J7GJvVuILSOeNNJIA\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"doctor\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"Gurukul Road, Opp. Gurukul Tower, Near Shreeji Complex, Memnagar, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.0532291,\n" +
//                "               \"lng\" : 72.5191842\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0546525802915,\n" +
//                "                  \"lng\" : 72.52053038029149\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0519546197085,\n" +
//                "                  \"lng\" : 72.51783241970848\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"908c4f89558235e0a94a98f169b6d079c0a8426e\",\n" +
//                "         \"name\" : \"Transcyber Adi Inc\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"place_id\" : \"ChIJxV1s3VSbXjkR1ZMW4Nt0RVs\",\n" +
//                "         \"rating\" : 4,\n" +
//                "         \"reference\" : \"CmRRAAAAStiqtGtB_6NjUL0hjTVtJi4FX_2peIxW8sepI_3tDDf5-yBGH39a7W7cP2_iG4xJPUo-vnhzRH789LWcfnG17nmx-oka4lJpd3u57_CuKdJFTCzwJ6-Q0U2MrXbCHR-NEhBuoTK1-TjDy9ZoyFU9Y4APGhQMne1-fUiSS37OAc_2v8kK9vyHlQ\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"0/35, New York trade Center, Near Thaltej Cross Road, S. G. Highway, Sarkhej - Gandhinagar Highway, Patel Society, Jai Ambe Nagar, Thaltej, Ahmedabad\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "         \"geometry\" : {\n" +
//                "            \"location\" : {\n" +
//                "               \"lat\" : 23.033101,\n" +
//                "               \"lng\" : 72.527017\n" +
//                "            },\n" +
//                "            \"viewport\" : {\n" +
//                "               \"northeast\" : {\n" +
//                "                  \"lat\" : 23.0344499802915,\n" +
//                "                  \"lng\" : 72.52836598029151\n" +
//                "               },\n" +
//                "               \"southwest\" : {\n" +
//                "                  \"lat\" : 23.0317520197085,\n" +
//                "                  \"lng\" : 72.5256680197085\n" +
//                "               }\n" +
//                "            }\n" +
//                "         },\n" +
//                "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/doctor-71.png\",\n" +
//                "         \"id\" : \"6ed2cee748707cfd8cf24989679d91a7e68c5685\",\n" +
//                "         \"name\" : \"Ayuraksha Clinic & Cosmetic & Laser Center\",\n" +
//                "         \"opening_hours\" : {\n" +
//                "            \"open_now\" : true,\n" +
//                "            \"weekday_text\" : []\n" +
//                "         },\n" +
//                "         \"photos\" : [\n" +
//                "            {\n" +
//                "               \"height\" : 2046,\n" +
//                "               \"html_attributions\" : [\n" +
//                "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/116519856514996236682/photos\\\"\\u003eAyuraksha Clinic &amp; Cosmetic &amp; Laser Center\\u003c/a\\u003e\"\n" +
//                "               ],\n" +
//                "               \"photo_reference\" : \"CmRaAAAAOF8eZn96LQuzvdgtpLFqitCqeUC-zeeOGUhZTJAhbinMWdxU7NltV_0mM3EPfnfCEH11MZojez8rHmVvy37Zp7U0yOwGEkkvWHy9YVR-cGdXzdyhRjDK4gOzkKJPP5qvEhCGYMeq0PdHw-AgCJTJuSrdGhSFgcjpPVXb8XJlYQbuz7Lny3J8DA\",\n" +
//                "               \"width\" : 2194\n" +
//                "            }\n" +
//                "         ],\n" +
//                "         \"place_id\" : \"ChIJd8gpy7eEXjkRKdQUPlo8oXg\",\n" +
//                "         \"rating\" : 5,\n" +
//                "         \"reference\" : \"CmRRAAAAvASRAlgNndmmWkcJ2cT7rBfmGy4cQkdj_xgzN2QAhmNC0X_Lo3GQV_KLZRSMVHgtWiu-nTuIuyMs9jGHAWrbP2njuWjoMFuiLa28zAv0RQ488quqs0XIo58iT6c6XrAhEhDMbNDeF6rFfSwXEKGY6n6LGhTfV6bfp0cow78JCtxrftCRXzoGbA\",\n" +
//                "         \"scope\" : \"GOOGLE\",\n" +
//                "         \"types\" : [ \"hospital\", \"health\", \"point_of_interest\", \"establishment\" ],\n" +
//                "         \"vicinity\" : \"C, 11, Sattelite Centre, Opposite Swaminarayan Tample, Near Mansi Complex,, Vastrapur, Ahmedabad\"\n" +
//                "      }\n" +
//                "   ],\n" +
//                "   \"status\" : \"OK\"\n" +
//                "}";
////if(content.contains("[]"))
////    content=content.replace("[]","null");
//        JSONObject jObject = new JSONObject(content);
////        HashMap<Object, Object> map = new Gson().fromJson(content,
////                new TypeToken<HashMap<Object, Object>>() {}.getType());
//
//        JSONArray resultMap = (JSONArray) jObject.get("results");
//       String resultCount =  String.valueOf(resultMap.length());
            getRemainder();
//        String apiUrl="ct=6403&ty=lmt&tyrf=4d423838343530&pty=10002&unit=12800&bd=11701&area=2234&fac=null&dvc=web&apiVersion=2.0&reqRemark=testing&src=msite";
//        apiUrl=apiUrl.replace("apiVersion=2.0", "apiVersion=" + "2.5");
//        System.out.println(apiUrl);

//        StringBuilder str= new StringBuilder("hello,how are you,");
//        str.append("hhhh");
//        str.append(",");
//        System.out.println(',' == str.charAt(str.length() - 1));
//        System.out.println(','.equalsIgnoreCasestr.charAt(str.length() - 1) ? str.substring(0, (str.length() - 1))
//                .trim().toString() : str.toString());
//        System.out.println(getOneDecimalVal(Math.abs(0.7620294162482947)));
//        System.out.println(getOneDecimalVal(Math.abs(0.7120294162482947)));
//        SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");

//        try {
//            Date date=s.parse("28/08/2012");
//            System.out.println(new Timestamp(date.getTime()));
////            System.out.println(new Timestamp(new Date("28/08/2012").getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);
//        Calendar c=Calendar.getInstance();

//
//        System.out.println(new Date("28/08/2012"));
//        System.out.println(new Date("08/28/2012"));
//        System.out.println(new Date("2012-08-28"));
//        System.out.println(new Date("2012/08/28"));
//        System.out.println(new Date("2012/28/08"));
////        System.out.println("Hello World!");

//        System.out.println(formatNumberForComma(234567890));
//        System.out.println(formatNumberForComma(23456178));
//        System.out.println(formatNumberForComma(2345678));
//        System.out.println(formatNumberForComma(783532));
//        System.out.println(formatNumberForComma(78352));
//        System.out.println(formatNumberForComma(2343));
//        System.out.println(formatNumberForComma(233));
//        System.out.println(formatNumberForComma(23));
//        System.out.println(formatNumberForComma(3));


//        Date d2 = new Date();
//        Date d1 = new Date(13848318035l);
//        Date startDate = new Date();
//                Date endDate   = new Date(2016,12,25);

//        long duration  = endDate.getTime() - startDate.getTime();
//
//        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
//        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
//        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
//        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
//        long diff = d1.getTime() - d2.getTime();
//        long diffSeconds = diff / 1000 % 60;
//        long diffMinutes = diff / (60 * 1000) % 60;
//        long diffHours = diff / (60 * 60 * 1000);
//        int diffInDays = (int) diff / (1000 * 60 * 60 * 24);

//        Date dt2 = new DateAndTime().getCurrentDateTime();

//        LocalDate today = LocalDate.now();
//        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
//
//        Period p = Period.between(birthday, today);
//        long p2 = ChronoUnit.DAYS.between(birthday, today);
//
//        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months, and " + p.getDays() + " days old. (" + p2 + " days total)");
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
//        int days = 3;
//        // Add days
//        calendar.add(date.getMonth(), days);
//        Date newDate = calendar.getTime();
//
////
//        Date now = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(now);
//        c.add(Calendar.DATE, 3);
//        c.set(Calendar.HOUR_OF_DAY,0);
//        c.set(Calendar.MINUTE,0);
//        c.set(Calendar.SECOND,0);
//        c.set(Calendar.MILLISECOND,0);
//        Date newdt = c.getTime();
//        System.out.println(now);
//        System.out.println(newdt);
//        long difference = newdt.getTime() - now.getTime();
//        System.out.println(difference);

//        float a=2.25f;
//        System.out.println(Math.ceil(a));
//        System.out.println(Math.signum(Math.floor(a)));
//        System.out.println(Math.round(a));
//        System.out.println(isMobNumCorrect("2041040449"));
//        System.out.println(isMobNumCorrect("9810245125"));
//        System.out.println(isMobNumCorrect("98145125"));
//        System.out.println(isMobNumCorrect("8102451295"));
//        System.out.println(isMobNumCorrect("7102451200"));
//        System.out.println(isMobNumCorrect("0123456789"));
//        System.out.println(isMobNumCorrect("1234567890"));
//        System.out.println(isMobNumCorrect("0000000000"));
//        System.out.println(isMobNumCorrect("6098754321"));


//        int a = 1;
//        int b = 2;
//        int c ;
//        for (int i = 0; i < 9; i++) {
//            c = new Random().nextBoolean() ? a : b;
//            System.out.println(c);
//        }

//        System.out.println(getFormat(0,"",999,"AAABC"));
//        System.out.println(getFormat(0,"a",999,"AAABC"));
//        System.out.println(getFormat(3,"v",999,"AAABC"));
//        System.out.println(getFormat(0,"",99,""));
//        System.out.println(getFormat(0,"",0,""));
//        System.out.println(getFormat(0,"",999,"AAABC"));

//        System.out.println(getSMS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa323aaaaaaa",
//                "<userName>************<prj/loc name>", 0, "", 99, ""));
//        System.out.println(getSMS
//                ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa4545dgdgdfgfdhgfdhfdhfhfghgfhgfhfdhdfhdhdhfdhfhfhhghgaaaaaaaaaaaaa323aaaaaaa", "<userName>*******<prj/loc name>", 0, "", 99, ""));
//        System.out.println(getSMS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaffhfhgfhfghgfjgjgfjgjgfjgfjg " +
//                "aaaaaaaaaaaa323aaaaaaa", "<userName><prj/loc " + "name>", 0, "dsvdsgvfdgbggggggggggggg " +
//                "fffffffffffffffffffffffffffffffff", 99, "ffffffffff"));
//        System.out.println(getSMS("Hello aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa323aaaaaaa", "<userName>*******", 0, "", 99,
//                "Projectdfgfdgfdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
//                        ""));
//        System.out.println(getSMS("aaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa323aaaaaaa", "<userName>*******<prj/loc name>", 10, "", 99, "fbfbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
//        System.out.println(getSMS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa a323aaaaaaa", "<userName>*******", 0, "", 0, ""));
//        System.out.println(getSMS("", "<userName>*******<prj/loc name>", 0, "", 0, "dgdgfdf"));
//        System.out.println(getSMS(null, "<userName>*******", 0, "", 0, "dgdgfdf"));
//        System.out.println(getSMS(null, "<userName>*******<prj/loc name>", 0, "", 0, null));
//        System.out.println(getSMS(null, "<userName>*******<prj/loc name>", 0, "", 99, null));
//        System.out.println(getSMS(null, "<userName>*******<prj/loc name>", 10, null, 0, null));


    }

    public static String getOneDecimalVal(double n) {
//        DecimalFormat df = new DecimalFormat("#.#");
//        df.setRoundingMode(RoundingMode.FLOOR);
        BigDecimal bd = new BigDecimal(n).setScale(1, RoundingMode.HALF_UP);
//        d = bd.doubleValue();
//        return df.format(n);
        return String.valueOf(bd.doubleValue());
    }

    public static long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime) {
        long milliseconds1 = oldTime.getTime();
        long milliseconds2 = currentTime.getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffMinutes;
    }

    public static String getSMS(String name, String sms, long psmId, String prjName, long locId, String locName) {

        if (chkNull(name))
            sms = sms.replace("<userName>", "");
        else {
            if (name.length() > 15)
                sms = sms.replace("<userName>", getFirstWord(name));
            else
                sms = sms.replace("<userName>", name);
        }

        if (sms.contains("<prj/loc name>")) {
            if (psmId != 0L) {
                if (chkNull(prjName))
                    sms = sms.replace("<prj/loc name>", "");
                else
                    sms = sms.replace("<prj/loc name>", prjName.length() > 17 ? prjName.substring
                            (0, 17).trim() + "..." : prjName.trim());
            } else {
                if (chkNull(locName))
                    sms = sms.replace("<prj/loc name>", "");
                else
                    sms = sms.replace("<prj/loc name>", locName.length() > 17 ? locName.substring
                            (0, 17).trim() + "..." : locName.trim());
            }
        }
        return sms;
    }

    public static int getFormat(long psmId, String prjName, long locId, String locName) {
//        return new Random().nextBoolean() ? 1 : 2;

        if ((psmId != 0L && !chkNull(prjName)) || (locId != 0L && !chkNull(locName)))
            return 2;
        else
            return 1;

    }

    public static boolean isMobNumCorrect(String mobileNum) {
        if (chkNull(mobileNum) || mobileNum.length() != 10)
            return false;

        char[] str = mobileNum.toCharArray();
        char ch = str[0];

        if (Character.getNumericValue(ch) < 7)
            return false;

        int count = 1;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ch)
                count++;
        }

        if (count == 10)
            return false;
        return true;
    }


    public static boolean chkNull(Object value) {
        String strValue = null;

        if (value instanceof Integer) {
            strValue = value.toString();
        } else if (value instanceof Long) {
            strValue = value.toString();
        } else if (value instanceof String) {
            strValue = value.toString();
        }

        if ((strValue == null) || (strValue != null && ("".equals(strValue.trim()) || "null".equals(strValue.trim()) || "-1".equals(strValue.trim()) || strValue.trim().length() == 0))) {
            return true;
        } else {
            return false;
        }


    }

    public static boolean retargetToday(Date inBetween) {
        LocalDate now = new DateTime().toLocalDate();
        boolean ans;
        LocalDate beforeDate, afterDate;
        LocalDate event = new DateTime(inBetween).toLocalDate();
        switch (now.getDayOfWeek()) {
            case 6:
                beforeDate = now.minusDays(5);
                afterDate = now.minusDays(3);

                if ((event.isBefore(afterDate) && event.isAfter(beforeDate)) || event.isEqual(afterDate) || event.isEqual(beforeDate))
                    ans = true;
                else
                    ans = false;

                break;
            case 7:
                beforeDate = now.minusDays(3);
                afterDate = now.minusDays(1);

                if ((event.isBefore(afterDate) && event.isAfter(beforeDate)) || event.isEqual(afterDate) || event.isEqual(beforeDate))
                    ans = true;
                else
                    ans = false;
                break;
            default:
                ans = false;
                break;
        }
        return ans;
    }

    private static String getFirstWord(String text) {
        if (text.indexOf(' ') > -1) { // Check if there is more than one word.
            return text.substring(0, text.indexOf(' ')).trim(); // Extract first word.
        } else {
            return text; // Text is the first word itself.
        }
    }

    private static String formatNumberForComma(long number) {

        StringBuilder buffer = new StringBuilder().append(number);
        int length = buffer.length();
        if (length > 3) {
            length = length - 3;
            buffer.insert(length, ",");

            while (length > 2) {
                length = length - 2;
                buffer.insert(length, ",");
            }
        }
        return buffer.toString();
    }

        private static void getRemainder(){

                int l=2306996;
                System.out.println(l&4);
        }
}
